package us.timinc.jsonifycraft.description;

import us.timinc.jsonifycraft.event.EventContext;

public abstract class ConditionDescription extends JsonDescription {
    public abstract boolean evaluate(EventContext eventContext);
}
