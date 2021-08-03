package starloader.examplemod;

import api.common.GameClient;
import api.config.BlockConfig;
import api.listener.Listener;
import api.listener.events.input.KeyPressEvent;
import api.mod.StarLoader;
import api.mod.StarMod;
import api.utils.gui.ModGUIHandler;
import org.apache.commons.io.IOUtils;
import starloader.examplemod.element.ElementManager;
import starloader.examplemod.gui.menu.MyGUIMenuControlManager;
import starloader.examplemod.manager.ConfigManager;
import starloader.examplemod.manager.LogManager;
import starloader.examplemod.manager.MessageType;
import starloader.examplemod.manager.ResourceManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * ExampleMod main class.
 *
 * @author TheDerpGamer
 * @since 08/03/2021
 */
public class ExampleMod extends StarMod {

    //Instance
    private static ExampleMod instance;
    public static ExampleMod getInstance() {
        return instance;
    }
    public ExampleMod() {

    }
    public static void main(String[] args) {

    }

    //Misc Data
    private final String[] overwriteClasses = new String[] {
            //Todo: Class overwriting tutorial
    };
    public MyGUIMenuControlManager menuControlManager;


    @Override
    public void onEnable() {
        instance = this;
        ConfigManager.initialize(this);
        LogManager.initialize();
        ResourceManager.loadResources(this);
        registerListeners();
        LogManager.logMessage(MessageType.INFO, "Successfully loaded mod data.");
    }

    @Override
    public byte[] onClassTransform(String className, byte[] byteCode) {
        for(String name : overwriteClasses) if(className.endsWith(name)) return overwriteClass(className, byteCode);
        return super.onClassTransform(className, byteCode);
    }

    @Override
    public void onBlockConfigLoad(BlockConfig blockConfig) {
        //Systems
        //ElementManager.addBlock(new MyBlock()); Todo: Custom block tutorial

        ElementManager.initialize();
    }

    private void registerListeners() {
        StarLoader.registerListener(KeyPressEvent.class, new Listener<KeyPressEvent>() {
            @Override
            public void onEvent(KeyPressEvent event) {
                if(event.getChar() == ';' && GameClient.getClientState().getPlayerInputs().isEmpty()) {
                    if(menuControlManager == null) {
                        menuControlManager = new MyGUIMenuControlManager();
                        ModGUIHandler.registerNewControlManager(getSkeleton(), menuControlManager);
                    }
                    menuControlManager.setActive(!menuControlManager.isActive());
                }
            }
        }, this);
    }

    private byte[] overwriteClass(String className, byte[] byteCode) { //Todo: Class overwriting tutorial
        byte[] bytes = null;
        try {
            ZipInputStream file = new ZipInputStream(new FileInputStream(this.getSkeleton().getJarFile()));
            while(true) {
                ZipEntry nextEntry = file.getNextEntry();
                if(nextEntry == null) break;
                if(nextEntry.getName().endsWith(className + ".class")) bytes = IOUtils.toByteArray(file);
            }
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        if(bytes != null) return bytes;
        else return byteCode;
    }
}
