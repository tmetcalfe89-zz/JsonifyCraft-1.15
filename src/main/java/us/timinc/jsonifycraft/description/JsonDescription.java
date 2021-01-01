package us.timinc.jsonifycraft.description;

import java.util.Arrays;

public class JsonDescription {
    public String name;
    public String type;
    public String[] flags = {};

    public boolean hasFlag(String flag) {
        return Arrays.asList(flags).contains(flag);
    }
}
