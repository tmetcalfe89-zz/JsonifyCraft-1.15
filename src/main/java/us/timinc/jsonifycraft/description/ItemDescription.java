package us.timinc.jsonifycraft.description;

import net.minecraft.item.Item;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.world.JsonedItem;

import java.util.ArrayList;
import java.util.List;

public class ItemDescription extends WorldObjectDescription implements IItemProvider {
    public int stack = 64;

    @Override
    public List<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new JsonedItem(this).setRegistryName(JsonifyCraft.MODID, this.name));

        return items;
    }
}
