package us.timinc.jsonifycraft.world;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import us.timinc.jsonifycraft.description.ItemDescription;
import us.timinc.jsonifycraft.event.EventContext;
import us.timinc.jsonifycraft.event.EventProcessor;

import javax.annotation.Nullable;
import java.util.List;

public class JsonedItem extends Item {
    private final ItemDescription description;

    public JsonedItem(ItemDescription itemDescription) {
        super(itemDescription.genItemProperties());
        this.description = itemDescription;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return stack.getItem() == this && description.hasFlag("shimmer");
    }

//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
//        if (description == null || world.isRemote) {
//            return super.onItemRightClick(world, player, hand);
//        }
//
//        EventContext eventContext = new EventContext(world, player);
//        if (EventProcessor.process(eventContext, description.events, "itemrightclick")) {
//            return ActionResult.resultSuccess(player.getHeldItem(hand));
//        } else {
//            return super.onItemRightClick(world, player, hand);
//        }
//    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (description.hasFlag("lore")) {
            tooltip.add(new TranslationTextComponent(String.format("item.jsonifycraft.%s.lore", description.name)));
        }
    }
}
