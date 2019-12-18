package us.timinc.jsonifycraft.world;

import com.google.common.primitives.Ints;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.description.ItemDescription;
import us.timinc.jsonifycraft.description.WorldObjectDescription;
import us.timinc.mcutil.MCRegistry;

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
}
