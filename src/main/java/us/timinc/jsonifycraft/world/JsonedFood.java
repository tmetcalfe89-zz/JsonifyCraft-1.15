package us.timinc.jsonifycraft.world;

import us.timinc.jsonifycraft.description.FoodDescription;

public class JsonedFood extends JsonedItem {
  private final FoodDescription foodDescription;

  public JsonedFood(FoodDescription foodDescription) {
    super(foodDescription);

    this.foodDescription = foodDescription;
  }
}
