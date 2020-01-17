package us.timinc.jsonifycraft.description.condition;

import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.description.ConditionDescription;
import us.timinc.jsonifycraft.event.EventContext;

public class RollCondition extends ConditionDescription {
    public int sides = 6;
    public int target = 1;

    @Override
    public boolean evaluate(EventContext event) {
        int rolled = event.world.rand.nextInt(sides);
        boolean success = rolled < target;
        JsonifyCraft.log("Dice roll: %s/%s, target <%s.", rolled, sides, target);
        return success;
    }
}
