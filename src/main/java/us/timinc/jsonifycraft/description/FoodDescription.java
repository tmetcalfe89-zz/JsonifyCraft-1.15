package us.timinc.jsonifycraft.description;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import us.timinc.jsonifycraft.JsonifyCraft;
import us.timinc.jsonifycraft.description.tidbits.EffectDescription;
import us.timinc.jsonifycraft.world.JsonedFood;

import java.util.ArrayList;
import java.util.List;

public class FoodDescription extends ItemDescription {
  public int hunger;
  public float saturation;
  public boolean meat;
  public boolean canEatWhenFull;
  public boolean fastToEat;
  public EffectDescription[] effects = {};

  private transient Food food = null;

  @Override
  public List<Item> getItems() {
    ArrayList<Item> items = new ArrayList<>();

    items.add(new JsonedFood(this).setRegistryName(JsonifyCraft.MODID, this.name));

    return items;
  }

  @Override
  public Item.Properties genItemProperties() {
    return super.genItemProperties().food(getFood());
  }

  public Food getFood() {
    if (food == null) {
      Food.Builder foodBuilder = new Food.Builder()
          .hunger(hunger)
          .saturation(saturation);
      if (meat) {
        foodBuilder.meat();
      }
      if (canEatWhenFull) {
        foodBuilder.setAlwaysEdible();
      }
      if (fastToEat) {
        foodBuilder.fastToEat();
      }
      for (EffectDescription effectDescription : effects) {
        foodBuilder.effect(() -> effectDescription.getEffect(), effectDescription.probability);
      }
      food = foodBuilder.build();
    }
    return food;
  }
}
