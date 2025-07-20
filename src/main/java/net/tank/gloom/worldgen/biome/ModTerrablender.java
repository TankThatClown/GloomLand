package net.tank.gloom.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation("gloom", "overworld"), 2));
    }
}
