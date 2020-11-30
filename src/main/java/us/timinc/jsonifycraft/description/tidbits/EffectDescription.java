package us.timinc.jsonifycraft.description.tidbits;

import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectDescription {
  public String effect;
  public int duration;
  public int amplifier;
  public float probability = 1;

  private transient EffectInstance effectInstance = null;

  public EffectInstance getEffect() {
    if (effectInstance == null) {
      effectInstance = new EffectInstance(ForgeRegistries.POTIONS.getValue(new ResourceLocation(effect)), duration, amplifier);
    }
    return effectInstance;
  }
}
