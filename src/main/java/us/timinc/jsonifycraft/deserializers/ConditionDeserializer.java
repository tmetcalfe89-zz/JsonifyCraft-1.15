package us.timinc.jsonifycraft.deserializers;

import com.google.gson.*;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.description.ConditionDescription;

import java.lang.reflect.Type;
import java.util.HashMap;

public class ConditionDeserializer implements JsonDeserializer<ConditionDescription> {
    private static HashMap<String, Type> conditionClasses = new HashMap<>();

    public static void registerDescription(String name, Type type) {
        JsonifyCraft.log("Registering condition deserializer: %s", name);
        conditionClasses.put(name, type);
    }

    @Override
    public ConditionDescription deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonifyCraft.log("Deserializing condition: %s", type);
        return context.deserialize(jsonObject, conditionClasses.get(type));
    }
}
