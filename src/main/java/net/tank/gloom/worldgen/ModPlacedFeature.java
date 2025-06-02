package net.tank.gloom.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModPlacedFeature {
   public static final ResourceKey<PlacedFeature> PLACED_GLOWSHROOM_KEY = registerKey("placed_giant_glowshroom");
     
   public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation("gloom", name));
    }
}
