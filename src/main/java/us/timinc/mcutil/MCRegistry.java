package us.timinc.mcutil;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import org.apache.commons.lang3.EnumUtils;
import us.timinc.jsonifycraft.JsonifyCraft;

import java.util.HashMap;
import java.util.Map;

public abstract class MCRegistry<T> {
    public static MCRegistry<ItemGroup> ITEM_GROUPS = new MCRegistry() {
        private Map<String, ItemGroup> itemGroups;

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

    public static MCRegistry<Material> MATERIALS = new MCRegistry<Material>() {
        private Map<String, Material> materials;

        @Override
        public MCRegistry<Material> setup() {
            materials = new HashMap<>();

            materials.put("AIR", Material.AIR);
            materials.put("STRUCTURE_VOID", Material.STRUCTURE_VOID);
            materials.put("PORTAL", Material.PORTAL);
            materials.put("CARPET", Material.CARPET);
            materials.put("PLANTS", Material.PLANTS);
            materials.put("OCEAN_PLANT", Material.OCEAN_PLANT);
            materials.put("TALL_PLANTS", Material.TALL_PLANTS);
            materials.put("SEA_GRASS", Material.SEA_GRASS);
            materials.put("WATER", Material.WATER);
            materials.put("BUBBLE_COLUMN", Material.BUBBLE_COLUMN);
            materials.put("LAVA", Material.LAVA);
            materials.put("SNOW", Material.SNOW);
            materials.put("FIRE", Material.FIRE);
            materials.put("MISCELLANEOUS", Material.MISCELLANEOUS);
            materials.put("WEB", Material.WEB);
            materials.put("REDSTONE_LIGHT", Material.REDSTONE_LIGHT);
            materials.put("CLAY", Material.CLAY);
            materials.put("EARTH", Material.EARTH);
            materials.put("ORGANIC", Material.ORGANIC);
            materials.put("PACKED_ICE", Material.PACKED_ICE);
            materials.put("SAND", Material.SAND);
            materials.put("SPONGE", Material.SPONGE);
            materials.put("SHULKER", Material.SHULKER);
            materials.put("WOOD", Material.WOOD);
            materials.put("BAMBOO_SAPLING", Material.BAMBOO_SAPLING);
            materials.put("BAMBOO", Material.BAMBOO);
            materials.put("WOOL", Material.WOOL);
            materials.put("TNT", Material.TNT);
            materials.put("LEAVES", Material.LEAVES);
            materials.put("GLASS", Material.GLASS);
            materials.put("ICE", Material.ICE);
            materials.put("CACTUS", Material.CACTUS);
            materials.put("ROCK", Material.ROCK);
            materials.put("IRON", Material.IRON);
            materials.put("SNOW_BLOCK", Material.SNOW_BLOCK);
            materials.put("ANVIL", Material.ANVIL);
            materials.put("BARRIER", Material.BARRIER);
            materials.put("PISTON", Material.PISTON);
            materials.put("CORAL", Material.CORAL);
            materials.put("GOURD", Material.GOURD);
            materials.put("DRAGON_EGG", Material.DRAGON_EGG);
            materials.put("CAKE", Material.CAKE);

            return this;
        }

        @Override
        public Material getFromName(String name) {
            return materials.get(name.toUpperCase());
        }

        @Override
        public boolean isValidName(String name) {
            return materials.containsKey(name.toUpperCase());
        }
    }.setup();

    public abstract MCRegistry<T> setup();

    public abstract T getFromName(String name);

    public abstract boolean isValidName(String name);
}
