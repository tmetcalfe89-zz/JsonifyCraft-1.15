package us.timinc.jsonifycraft.world;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import us.timinc.jsonifycraft.description.BlockDescription;
import us.timinc.jsonifycraft.description.WorldObjectDescription;

public class JsonedBlockItem extends BlockItem {
    private WorldObjectDescription description;

    public JsonedBlockItem(Block block, BlockDescription blockDescription) {
        super(block, blockDescription.genItemProperties());
        description = blockDescription;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return stack.getItem() == this && description.hasFlag("shimmer");
    }
}
