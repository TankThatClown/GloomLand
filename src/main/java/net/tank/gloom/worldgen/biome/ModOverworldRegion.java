package net.tank.gloom.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        /*Climate.ParameterPoint gloomPlainsPoint = new Climate.ParameterPoint(
                Climate.Parameter.span(0.8F, 0.95F),  // temperature range
                Climate.Parameter.span(0.3F, 0.6F),  // humidity range
                Climate.Parameter.span(0.4F, 0.7F),  // continentalness
                Climate.Parameter.span(0.3F, 0.6F),  // erosion
                Climate.Parameter.point(0.125F),       // depth
                Climate.Parameter.span(-0.2F, 0.2F), // weirdness
                0L                                    // offset
        ); 

        mapper.accept(Pair.of(gloomPlainsPoint, ModBiomes.GLOOM_PLAINS)); */
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, ModBiomes.GLOOM_PLAINS);
        }); 
    }
}