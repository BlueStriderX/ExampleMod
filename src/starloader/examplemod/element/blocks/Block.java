package starloader.examplemod.element.blocks;

import api.config.BlockConfig;
import org.schema.game.common.data.element.ElementCategory;
import org.schema.game.common.data.element.ElementInformation;
import starloader.examplemod.ExampleMod;

/**
 * Abstract Block class.
 *
 * @author TheDerpGamer
 * @since 07/02/2021
 */
public abstract class Block {

    protected ElementInformation blockInfo;

    public Block(String name, ElementCategory category) {
        blockInfo = BlockConfig.newElement(ExampleMod.getInstance(), name, new short[6]);
        BlockConfig.setElementCategory(blockInfo, category);
    }

    public final ElementInformation getBlockInfo() {
        return blockInfo;
    }

    public final short getId() {
        return blockInfo.getId();
    }

    public abstract void initialize();
}