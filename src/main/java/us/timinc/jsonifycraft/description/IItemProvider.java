package us.timinc.jsonifycraft.description;

import net.minecraft.item.Item;

import java.util.List;

public interface IItemProvider extends IGameObjectProvider {
    @Override
    public List<Item> getItems();
}
