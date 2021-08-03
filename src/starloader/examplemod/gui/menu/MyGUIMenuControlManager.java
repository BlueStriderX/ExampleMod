package starloader.examplemod.gui.menu;

import api.common.GameClient;
import api.utils.gui.GUIControlManager;
import api.utils.gui.GUIMenuPanel;

/**
 * <Description>
 *
 * @author TheDerpGamer
 * @since 08/03/2021
 */
public class MyGUIMenuControlManager extends GUIControlManager {

    public MyGUIMenuControlManager() {
        super(GameClient.getClientState());
    }

    @Override
    public GUIMenuPanel createMenuPanel() {
        return new MyGUIMenuPanel(getState());
    }
}
