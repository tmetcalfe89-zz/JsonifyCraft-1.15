package us.timinc.jsonifycraft.description;

import us.timinc.jsonifycraft.event.EventContext;

public abstract class BehaviorDescription extends JsonDescription {
    public abstract void behave(EventContext eventContext);
}
