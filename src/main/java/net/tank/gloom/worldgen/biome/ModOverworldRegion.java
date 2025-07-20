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
        final Climate.Parameter temperature = Climate.Parameter.span(0.55F, 0.8F);      // temperature
        final Climate.Parameter humidity = Climate.Parameter.span(0.3F, 0.6F);          // humidity
        final Climate.Parameter continentalness = Climate.Parameter.span(0.4F, 0.6F);  // continentalness
        final Climate.Parameter erosion = Climate.Parameter.span(0.0F, 0.8F);           // erosion
        final Climate.Parameter depth = Climate.Parameter.span(0.3F, 0.5F);             // depth
        final Climate.Parameter weirdness = Climate.Parameter.span(-0.3F, 0.3F);       // weirdness

        /*mapper.accept(Pair.of(Climate.parameters(temperature,humidity,continentalness,erosion,depth,weirdness,0.0F), ModBiomes.GLOOM_PLAINS));*/
        this.addBiomeSimilar(mapper, Biomes.PLAINS, ModBiomes.GLOOM_PLAINS);
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {

        });

    }
}