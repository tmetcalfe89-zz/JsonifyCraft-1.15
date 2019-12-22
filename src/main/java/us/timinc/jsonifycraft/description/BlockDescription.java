package us.timinc.jsonifycraft.description;

import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.description.providers.IProviderBlock;
import us.timinc.jsonifycraft.description.providers.IProviderItem;
import us.timinc.jsonifycraft.description.tidbits.Harvester;
import us.timinc.jsonifycraft.world.JsonedBlock;
import us.timinc.jsonifycraft.world.JsonedBlockItem;
import us.timinc.mcutil.MCRegistry;

import java.util.ArrayList;
import java.util.List;

public class BlockDescription extends WorldObjectDescription implements IProviderBlock, IProviderItem {
    public String material = "earth";
    public String sounds = "stone";
    public String mapcolor = "";
    public int light = 0;
    public float resistance = -1.0F;
    public float hardness = -1.0F;
    public float slip = -1.0F;
    public Harvester harvester = null;

    transient List<Block> blocks;

    @Override
    public List<Block> getBlocks() {
        if (blocks == null) {
            blocks = new ArrayList<>();

            blocks.add(new JsonedBlock(this).setRegistryName(JsonifyCraft.MODID, this.name));
        }
        return blocks;
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        getBlocks()
                .forEach(block -> items.add(new JsonedBlockItem(block, this).setRegistryName(JsonifyCraft.MODID, this.name)));
        return items;
    }

    public Block.Properties genBlockProperties() {
        Block.Properties properties;

        // Map color
        if (mapcolor.isEmpty() || !MCRegistry.MATERIAL_COLORS.isValidName(mapcolor)) {
            properties = Block.Properties.create(MCRegistry.MATERIALS.getFromName(material));
        } else {
            properties = Block.Properties.create(MCRegistry.MATERIALS.getFromName(material), MCRegistry.MATERIAL_COLORS.getFromName(mapcolor));
        }

        // Ghost
        if (hasFlag("ghost")) {
            properties.doesNotBlockMovement();
        }

        // Sound type
        if (MCRegistry.SOUND_TYPES.isValidName(sounds)) {
            properties.sound(MCRegistry.SOUND_TYPES.getFromName(sounds));
        }

        // Light
        if (light >= 0 && light <= 15) {
            properties.lightValue(light);
        } else {
            int trueLight = Ints.constrainToRange(light, 0, 15);
            JsonifyCraft.log("Attempted light value of %s is invalid. Set to %s.", light, trueLight);
            properties.lightValue(trueLight);
        }

        // Hardness and resistance
        if ((hardness >= 0) ^ (resistance >= 0)) {
            properties.hardnessAndResistance(Math.max(hardness, resistance));
        } else if (hardness != -1.0F && resistance != -1.0F) {
            properties.hardnessAndResistance(0);
        }

        // Slipperiness
        if (slip != -1.0F) {
            properties.slipperiness(Floats.constrainToRange(slip, 0.001F, 0.999F));
        }

        // Tool
        if (harvester != null) {
            properties.harvestTool(harvester.getTool());
            properties.harvestLevel(harvester.level);
        }

        return properties;
    }
}
