package us.timinc.jsonifycraft.world;

import net.minecraft.block.Block;
import us.timinc.jsonifycraft.description.BlockDescription;

public class JsonedBlock extends Block {
    private final BlockDescription description;

    public JsonedBlock(BlockDescription blockDescription) {
        super(blockDescription.genBlockProperties());
        this.description = blockDescription;
    }
}
