package us.timinc.jsonifycraft.description.tidbits;

import net.minecraftforge.common.ToolType;
import us.timinc.mcutil.MCRegistry;

public class Harvester {
    public String tool;
    public int level = 0;

    public ToolType getTool() {
        return MCRegistry.TOOL_TYPES.getFromName(tool);
    }
}
