package net.tank.gloom.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
     public static final ResourceKey<Biome> GLOOM_PLAINS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation("gloom", "gloom_plains"));
}
