package us.timinc.jsonifycraft.world;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import us.timinc.jsonifycraft.description.ItemDescription;
import us.timinc.jsonifycraft.event.EventContext;
import us.timinc.jsonifycraft.event.EventProcessor;

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

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        if (description == null || world.isRemote) {
            return super.onItemRightClick(world, player, hand);
        }

        EventContext eventContext = new EventContext(world, player);
        if (EventProcessor.process(eventContext, description.events, "itemrightclick")) {
            return ActionResult.func_226248_a_(player.getHeldItem(hand));
        } else {
            return ActionResult.func_226250_c_(player.getHeldItem(hand));
        }
    }
}
