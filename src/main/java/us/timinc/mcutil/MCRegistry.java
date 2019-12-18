package us.timinc.mcutil;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import org.apache.commons.lang3.EnumUtils;
import us.timinc.jsonifycraft.JsonifyCraft;

import java.util.HashMap;

public abstract class MCRegistry<T> {
    public static MCRegistry<ItemGroup> ITEM_GROUPS = new MCRegistry() {
        private HashMap<String, ItemGroup> itemGroups;

        @Override
        public MCRegistry<ItemGroup> setup() {
            itemGroups = new HashMap<>();
            for (ItemGroup group : ItemGroup.GROUPS) {
                addItemGroup(group);
            }
            return this;
        }

        @Override
        public ItemGroup getFromName(String name) {
            return itemGroups.getOrDefault(name, null);
        }

        @Override
        public boolean isValidName(String name) {
            return itemGroups.containsKey(name);
        }

        public void addItemGroup(ItemGroup itemGroup) {
            JsonifyCraft.log(itemGroup.getPath().toLowerCase());
            itemGroups.put(itemGroup.getPath().toLowerCase(), itemGroup);
        }
    }.setup();

    public static MCRegistry<Rarity> RARITIES = new MCRegistry<Rarity>() {
        @Override
        public MCRegistry<Rarity> setup() {
            return this;
        }

        @Override
        public Rarity getFromName(String name) {
            return Rarity.valueOf(name.toUpperCase());
        }

        @Override
        public boolean isValidName(String name) {
            return EnumUtils.isValidEnum(Rarity.class, name.toUpperCase());
        }
    }.setup();

    public abstract MCRegistry<T> setup();

    public abstract T getFromName(String name);

    public abstract boolean isValidName(String name);
}
