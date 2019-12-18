package us.timinc.jsonifycraft.description;

import com.google.common.primitives.Ints;
import net.minecraft.item.Item;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.mcutil.MCRegistry;

public class WorldObjectDescription extends JsonDescription {
    public String name;
    public String group = "misc";
    public String rarity = "common";
    public int stack = 64;

    public Item.Properties genItemProperties() {
        Item.Properties properties = new Item.Properties();

        properties.group(MCRegistry.ITEM_GROUPS.getFromName(group));
        properties.maxStackSize(Ints.constrainToRange(stack, 1, 64));
        if (MCRegistry.RARITIES.isValidName(rarity)) {
            properties.rarity(MCRegistry.RARITIES.getFromName(rarity));
        } else {
            JsonifyCraft.log("Attempted rarity %s for %s, but it does not exist.", rarity, name);
        }

        return properties;
    }
}
