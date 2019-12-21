package us.timinc.mcutil;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import org.apache.commons.lang3.EnumUtils;

import java.util.HashMap;
import java.util.Map;

public abstract class MCRegistry<T> {
    public static final MCRegistry<ToolType> TOOL_TYPES = new MCRegistry<ToolType>() {
        @Override
        public MCRegistry<ToolType> setup() {
            return this;
        }

        @Override
        public ToolType getFromName(String name) {
            return ToolType.get(name);
        }

        @Override
        public boolean isValidName(String name) {
            return true;
        }
    }.setup();

    public static final MCRegistry<SoundType> SOUND_TYPES = new MCRegistry<SoundType>() {
        private Map<String, SoundType> soundTypes;

        @Override
        public MCRegistry<SoundType> setup() {
            soundTypes = new HashMap<>();

            soundTypes.put("WOOD", SoundType.WOOD);
            soundTypes.put("GROUND", SoundType.GROUND);
            soundTypes.put("PLANT", SoundType.PLANT);
            soundTypes.put("STONE", SoundType.STONE);
            soundTypes.put("METAL", SoundType.METAL);
            soundTypes.put("GLASS", SoundType.GLASS);
            soundTypes.put("CLOTH", SoundType.CLOTH);
            soundTypes.put("SAND", SoundType.SAND);
            soundTypes.put("SNOW", SoundType.SNOW);
            soundTypes.put("LADDER", SoundType.LADDER);
            soundTypes.put("ANVIL", SoundType.ANVIL);
            soundTypes.put("SLIME", SoundType.SLIME);
            soundTypes.put("field_226947_m_", SoundType.field_226947_m_);
            soundTypes.put("WET_GRASS", SoundType.WET_GRASS);
            soundTypes.put("CORAL", SoundType.CORAL);
            soundTypes.put("BAMBOO", SoundType.BAMBOO);
            soundTypes.put("BAMBOO_SAPLING", SoundType.BAMBOO_SAPLING);
            soundTypes.put("SCAFFOLDING", SoundType.SCAFFOLDING);
            soundTypes.put("SWEET_BERRY_BUSH", SoundType.SWEET_BERRY_BUSH);
            soundTypes.put("CROP", SoundType.CROP);
            soundTypes.put("STEM", SoundType.STEM);
            soundTypes.put("NETHER_WART", SoundType.NETHER_WART);
            soundTypes.put("LANTERN", SoundType.LANTERN);

            return this;
        }

        @Override
        public SoundType getFromName(String name) {
            return soundTypes.get(name.toUpperCase());
        }

        @Override
        public boolean isValidName(String name) {
            return soundTypes.containsKey(name.toUpperCase());
        }
    }.setup();

    public static final MCRegistry<MaterialColor> MATERIAL_COLORS = new MCRegistry<MaterialColor>() {
        private Map<String, MaterialColor> materialColors;

        @Override
        public MCRegistry<MaterialColor> setup() {
            materialColors = new HashMap<>();

            materialColors.put("AIR", MaterialColor.AIR);
            materialColors.put("GRASS", MaterialColor.GRASS);
            materialColors.put("SAND", MaterialColor.SAND);
            materialColors.put("WOOL", MaterialColor.WOOL);
            materialColors.put("TNT", MaterialColor.TNT);
            materialColors.put("ICE", MaterialColor.ICE);
            materialColors.put("IRON", MaterialColor.IRON);
            materialColors.put("FOLIAGE", MaterialColor.FOLIAGE);
            materialColors.put("SNOW", MaterialColor.SNOW);
            materialColors.put("CLAY", MaterialColor.CLAY);
            materialColors.put("DIRT", MaterialColor.DIRT);
            materialColors.put("STONE", MaterialColor.STONE);
            materialColors.put("WATER", MaterialColor.WATER);
            materialColors.put("WOOD", MaterialColor.WOOD);
            materialColors.put("QUARTZ", MaterialColor.QUARTZ);
            materialColors.put("ADOBE", MaterialColor.ADOBE);
            materialColors.put("MAGENTA", MaterialColor.MAGENTA);
            materialColors.put("LIGHT_BLUE", MaterialColor.LIGHT_BLUE);
            materialColors.put("YELLOW", MaterialColor.YELLOW);
            materialColors.put("LIME", MaterialColor.LIME);
            materialColors.put("PINK", MaterialColor.PINK);
            materialColors.put("GRAY", MaterialColor.GRAY);
            materialColors.put("LIGHT_GRAY", MaterialColor.LIGHT_GRAY);
            materialColors.put("CYAN", MaterialColor.CYAN);
            materialColors.put("PURPLE", MaterialColor.PURPLE);
            materialColors.put("BLUE", MaterialColor.BLUE);
            materialColors.put("BROWN", MaterialColor.BROWN);
            materialColors.put("GREEN", MaterialColor.GREEN);
            materialColors.put("RED", MaterialColor.RED);
            materialColors.put("BLACK", MaterialColor.BLACK);
            materialColors.put("GOLD", MaterialColor.GOLD);
            materialColors.put("DIAMOND", MaterialColor.DIAMOND);
            materialColors.put("LAPIS", MaterialColor.LAPIS);
            materialColors.put("EMERALD", MaterialColor.EMERALD);
            materialColors.put("OBSIDIAN", MaterialColor.OBSIDIAN);
            materialColors.put("NETHERRACK", MaterialColor.NETHERRACK);
            materialColors.put("WHITE_TERRACOTTA", MaterialColor.WHITE_TERRACOTTA);
            materialColors.put("ORANGE_TERRACOTTA", MaterialColor.ORANGE_TERRACOTTA);
            materialColors.put("MAGENTA_TERRACOTTA", MaterialColor.MAGENTA_TERRACOTTA);
            materialColors.put("LIGHT_BLUE_TERRACOTTA", MaterialColor.LIGHT_BLUE_TERRACOTTA);
            materialColors.put("YELLOW_TERRACOTTA", MaterialColor.YELLOW_TERRACOTTA);
            materialColors.put("LIME_TERRACOTTA", MaterialColor.LIME_TERRACOTTA);
            materialColors.put("PINK_TERRACOTTA", MaterialColor.PINK_TERRACOTTA);
            materialColors.put("GRAY_TERRACOTTA", MaterialColor.GRAY_TERRACOTTA);
            materialColors.put("LIGHT_GRAY_TERRACOTTA", MaterialColor.LIGHT_GRAY_TERRACOTTA);
            materialColors.put("CYAN_TERRACOTTA", MaterialColor.CYAN_TERRACOTTA);
            materialColors.put("PURPLE_TERRACOTTA", MaterialColor.PURPLE_TERRACOTTA);
            materialColors.put("BLUE_TERRACOTTA", MaterialColor.BLUE_TERRACOTTA);
            materialColors.put("BROWN_TERRACOTTA", MaterialColor.BROWN_TERRACOTTA);
            materialColors.put("GREEN_TERRACOTTA", MaterialColor.GREEN_TERRACOTTA);
            materialColors.put("RED_TERRACOTTA", MaterialColor.RED_TERRACOTTA);
            materialColors.put("BLACK_TERRACOTTA", MaterialColor.BLACK_TERRACOTTA);

            return this;
        }

        @Override
        public MaterialColor getFromName(String name) {
            return materialColors.get(name.toUpperCase());
        }

        @Override
        public boolean isValidName(String name) {
            return materialColors.containsKey(name.toUpperCase());
        }
    }.setup();
    public static MCRegistry<ItemGroup> ITEM_GROUPS = new MCRegistry<ItemGroup>() {
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

    public abstract MCRegistry<? extends T> setup();

    public abstract T getFromName(String name);

    public abstract boolean isValidName(String name);
}
