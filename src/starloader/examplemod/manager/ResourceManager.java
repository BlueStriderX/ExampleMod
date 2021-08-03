package starloader.examplemod.manager;

import api.utils.textures.StarLoaderTexture;
import starloader.examplemod.ExampleMod;
import java.util.HashMap;

/**
 * Manages mod files and resources.
 *
 * @author TheDerpGamer
 * @since 07/02/2021
 */
public class ResourceManager {

    private static final String[] textureNames = {
            //Todo: Texture tutorial
    };

    private static final HashMap<String, StarLoaderTexture> textureMap = new HashMap<>();

    public static void loadResources(final ExampleMod instance) {
        StarLoaderTexture.runOnGraphicsThread(new Runnable() {
            @Override
            public void run() {
                //Load Textures
                for(String texturePath : textureNames) {
                    String textureName = texturePath.substring(texturePath.lastIndexOf('/') + 1);
                    try {
                        if(textureName.endsWith("icon")) {
                            textureMap.put(textureName, StarLoaderTexture.newIconTexture(instance.getJarBufferedImage("starloader/examplemod/resources/textures/" + texturePath + ".png")));
                        } else {
                            textureMap.put(textureName, StarLoaderTexture.newBlockTexture(instance.getJarBufferedImage("starloader/examplemod/resources/textures/" + texturePath + ".png")));
                        }
                    } catch(Exception exception) {
                        LogManager.logException("Failed to load texture \"" + texturePath + "\"", exception);
                    }
                }
            }
        });
    }

    public static StarLoaderTexture getTexture(String name) {
        return textureMap.get(name);
    }
}