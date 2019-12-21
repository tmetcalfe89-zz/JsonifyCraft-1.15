package us.timinc.jsonifycraft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import us.timinc.jsonifycraft.description.JsonDescription;
import us.timinc.jsonifycraft.description.providers.IProviderBlock;
import us.timinc.jsonifycraft.description.providers.IProviderItem;
import us.timinc.jsonifycraft.deserializers.GameDeserializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.Arrays;

class DescriptionLoader {
    private ArrayList<JsonDescription> gameObjects = new ArrayList<>();
    private Gson gson;

    DescriptionLoader() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(JsonDescription.class, new GameDeserializer());
        gson = gsonBuilder.create();
        try {
            loadGameObjects();
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    private void loadGameObjects() throws FileSystemException {
        File globalDir = new File("gameobjects");
        if (!globalDir.exists() && !globalDir.mkdirs()) {
            throw new FileSystemException("Unable to create gameobjects directory.");
        }
        searchDirectory(globalDir);
    }

    private void searchDirectory(File dir) {
        File[] dirFiles = dir.listFiles();

        if (dirFiles == null) {
            return;
        }

        Arrays.stream(dirFiles).filter(File::isDirectory).forEach(this::searchDirectory);
        Arrays.stream(dirFiles).filter(x -> x.getName().endsWith(".json")).forEach(this::addObjectsFrom);
    }

    private void addObjectsFrom(File file) {
        try {
            gameObjects.addAll(Arrays.asList(gson.fromJson(new FileReader(file), JsonDescription[].class)));
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void registerItems(IForgeRegistry<Item> registry) {
        gameObjects.stream()
                .filter(IProviderItem.class::isInstance)
                .flatMap(itemProvider -> ((IProviderItem) itemProvider).getItems().stream())
                .forEach(item -> {
                    JsonifyCraft.log("Registering item: %s", item.getRegistryName());
                    registry.register(item);
                });
    }

    void registerBlocks(IForgeRegistry<Block> registry) {
        gameObjects.stream()
                .filter(IProviderBlock.class::isInstance)
                .flatMap(blockProvider -> ((IProviderBlock) blockProvider).getBlocks().stream())
                .forEach(block -> {
                    JsonifyCraft.log("Registering block: %s", block.getRegistryName());
                    registry.register(block);
                });
    }
}
