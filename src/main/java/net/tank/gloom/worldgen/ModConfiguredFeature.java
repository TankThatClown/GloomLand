package net.tank.gloom.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModConfiguredFeature {
   public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWSHROOM_KEY = registerKey("giant_glowshroom");
     
   public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation("gloom", name));
    }
}
