package net.tank.gloom.block.grower;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.tank.gloom.worldgen.ModConfiguredFeature;
public class GlowshroomGrower extends AbstractTreeGrower {
 /*private static final ResourceKey<Registry<ConfiguredFeature<?, ?>>> CONFIGURED_FEATURE_REGISTRY = 
        ResourceKey.createRegistryKey(new ResourceLocation("minecraft", "configured_feature")); */
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeature.GLOWSHROOM_KEY;
    }
    
}
