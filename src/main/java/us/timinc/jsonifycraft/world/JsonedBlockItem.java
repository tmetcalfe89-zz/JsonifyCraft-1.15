package us.timinc.jsonifycraft.world;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import us.timinc.jsonifycraft.description.BlockDescription;

import javax.annotation.Nullable;
import java.util.List;

public class JsonedBlockItem extends BlockItem {
    private final BlockDescription description;

    public JsonedBlockItem(Block block, BlockDescription blockDescription) {
        super(block, blockDescription.genItemProperties());
        description = blockDescription;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return stack.getItem() == this && description.hasFlag("shimmer");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (description.hasFlag("lore")) {
            tooltip.add(new TranslationTextComponent(String.format("block.jsonifycraft.%s.lore", description.name)));
        }
    }
}
