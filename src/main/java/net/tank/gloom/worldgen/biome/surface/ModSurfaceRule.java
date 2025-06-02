package net.tank.gloom.worldgen.biome.surface;
import net.tank.gloom.block.*;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.block.Block;
import net.tank.gloom.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Blocks;
public class ModSurfaceRule {
    private static final SurfaceRules.RuleSource GLOOM_DIRT=makeStateRule(ModBlocks.GLOOM_DIRT.get());
    private static final SurfaceRules.RuleSource GLOOM_GRASS=makeStateRule(ModBlocks.GLOOM_GRASS.get());
        private static final SurfaceRules.RuleSource GLOOM_STONE=makeStateRule(ModBlocks.GLOOM_STONE.get());
    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isGloomPlains = SurfaceRules.isBiome(ModBiomes.GLOOM_PLAINS);
    SurfaceRules.ConditionSource isAboveWater = SurfaceRules.waterBlockCheck(-1, 0);

    // Rule block only applied if biome == GLOOM_PLAINS
    SurfaceRules.RuleSource gloomRules = SurfaceRules.sequence(
        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
            SurfaceRules.ifTrue(isAboveWater, GLOOM_GRASS)), // grass on top if above water
        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, GLOOM_DIRT), // dirt under top
        GLOOM_STONE // fallback (e.g. caves)
    );

    return SurfaceRules.sequence(
        SurfaceRules.ifTrue(isGloomPlains, gloomRules) // Only override in GLOOM_PLAINS
  
    );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
