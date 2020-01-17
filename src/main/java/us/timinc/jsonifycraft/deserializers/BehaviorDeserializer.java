package us.timinc.jsonifycraft.deserializers;

import com.google.gson.*;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.description.BehaviorDescription;

import java.lang.reflect.Type;
import java.util.HashMap;

public class BehaviorDeserializer implements JsonDeserializer<BehaviorDescription> {
    private static HashMap<String, Type> behaviorClasses = new HashMap<>();

    public static void registerDescription(String name, Type type) {
        JsonifyCraft.log("Registering behavior deserializer: %s", name);
        behaviorClasses.put(name, type);
    }

    @Override
    public BehaviorDescription deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonifyCraft.log("Deserializing behavior: %s", type);
        return context.deserialize(jsonObject, behaviorClasses.get(type));
    }
}
