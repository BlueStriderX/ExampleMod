package starloader.examplemod.element.items;

import api.config.BlockConfig;
import org.schema.game.common.data.element.ElementCategory;
import org.schema.game.common.data.element.ElementInformation;
import starloader.examplemod.ExampleMod;

/**
 * Abstract Item class.
 *
 * @author TheDerpGamer
 * @since 07/02/2021
 */
public abstract class Item {

    protected ElementInformation itemInfo;

    public Item(String name, ElementCategory category) {
        itemInfo = BlockConfig.newElement(ExampleMod.getInstance(), name, new short[6]);
        itemInfo.setPlacable(false);
        itemInfo.setPhysical(false);
        BlockConfig.setElementCategory(itemInfo, category);
    }

    public final ElementInformation getItemInfo() {
        return itemInfo;
    }

    public final short getId() {
        return itemInfo.getId();
    }

    public abstract void initialize();
}