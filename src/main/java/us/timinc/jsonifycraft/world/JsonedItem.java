package us.timinc.jsonifycraft.world;

import com.google.common.primitives.Ints;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.description.ItemDescription;
import us.timinc.mcutil.MCRegistry;

public class JsonedItem extends Item {
    private final ItemDescription description;

    public JsonedItem(ItemDescription itemDescription) {
        super(genProperties(itemDescription));
        this.description = itemDescription;
    }

    private static Item.Properties genProperties(ItemDescription itemDescription) {
        Item.Properties properties = new Item.Properties();

        properties.group(MCRegistry.ITEM_GROUPS.getFromName(itemDescription.group));
        properties.maxStackSize(Ints.constrainToRange(itemDescription.stack, 1, 64));
        if (MCRegistry.RARITIES.isValidName(itemDescription.rarity)) {
            properties.rarity(MCRegistry.RARITIES.getFromName(itemDescription.rarity));
        } else {
            JsonifyCraft.log("Attempted rarity %s for %s, but it does not exist.", itemDescription.rarity, itemDescription.name);
        }

        return properties;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return stack.getItem() == this && description.hasFlag("shimmer");
    }
}
