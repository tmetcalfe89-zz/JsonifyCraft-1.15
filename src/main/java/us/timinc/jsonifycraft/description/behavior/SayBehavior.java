package us.timinc.jsonifycraft.description.behavior;

import net.minecraft.util.text.TranslationTextComponent;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.description.BehaviorDescription;
import us.timinc.jsonifycraft.event.EventContext;

public class SayBehavior extends BehaviorDescription {
    public String message;

    @Override
    public void behave(EventContext eventContext) {
        if (eventContext.player != null) {
            JsonifyCraft.log("Sending message '%s' to player.", message);
            eventContext.player.sendMessage(new TranslationTextComponent(message));
        } else {
            JsonifyCraft.log("Attempted to send message to null player.");
        }
    }
}
