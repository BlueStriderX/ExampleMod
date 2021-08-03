package starloader.examplemod.gui.menu;

import api.utils.gui.GUIMenuPanel;
import org.schema.schine.graphicsengine.forms.gui.GUIAncor;
import org.schema.schine.graphicsengine.forms.gui.newgui.GUIContentPane;
import org.schema.schine.input.InputState;

/**
 * <Description>
 *
 * @author TheDerpGamer
 * @since 08/03/2021
 */
public class MyGUIMenuPanel extends GUIMenuPanel {

    public MyGUIMenuPanel(InputState inputState) {
        super(inputState, "MyGUIMenuPanel", 750, 450);
    }

    @Override
    public void recreateTabs() {
        guiWindow.clearTabs();
        createFirstTab();
        createSecondTab();
    }

    private void createFirstTab() {
        GUIContentPane contentPane = guiWindow.addTab("FIRST TAB");
        contentPane.setTextBoxHeightLast(450); //Just in case the height is 0 for some reason
        contentPane.addDivider(400); //Split the pane horizontally
        contentPane.addNewTextBox(0, 200); //Split the pane vertically

        GUIAncor contentA = contentPane.getContent(0, 0);
        GUIAncor contentB = contentPane.getContent(0, 1);
        GUIAncor contentC = contentPane.getContent(1, 0);
    }

    private void createSecondTab() {
        GUIContentPane contentPane = guiWindow.addTab("FIRST TAB");
        contentPane.setTextBoxHeightLast(450);
    }
}
