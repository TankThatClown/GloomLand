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
        final Climate.Parameter temperature = Climate.Parameter.span(-0.45F, -0.15F);      // temperature
        final Climate.Parameter humidity = Climate.Parameter.span(-1.0F, -0.35F);          // humidity
        final Climate.Parameter continentalness = Climate.Parameter.span(0.2F,0.6F);  // continentalness
        final Climate.Parameter erosion = Climate.Parameter.span(-0.78F, -0.375F);           // erosion
        final Climate.Parameter weirdness = Climate.Parameter.span(-0.2F, 0.2F);       // weirdness
        final Climate.Parameter depth = Climate.Parameter.point(0.0F);             // depth
        Climate.ParameterPoint gloomPoint = new Climate.ParameterPoint(
                temperature,
                humidity,
                continentalness,
                erosion,
                depth,
                weirdness,
                0L
        );
       // this.addBiome(mapper,gloomPoint, ModBiomes.GLOOM_PLAINS);
        this.addBiomeSimilar(mapper, Biomes.PLAINS, ModBiomes.GLOOM_PLAINS);
        this.addBiomeSimilar(mapper,Biomes.SUNFLOWER_PLAINS,ModBiomes.GLOOM_PLAINS);
        this.addBiomeSimilar(mapper,Biomes.MEADOW,ModBiomes.GLOOM_PLAINS);
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {

        });

    }
}