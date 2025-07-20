package net.tank.gloom.worldgen.biome.surface;
import net.tank.gloom.block.*;
import java.util.Random;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.tank.gloom.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Blocks;
public class ModSurfaceRule {
    private static final SurfaceRules.RuleSource GLOOM_DIRT=makeStateRule(ModBlocks.GLOOM_DIRT.get());
    private static final SurfaceRules.RuleSource GLOOM_GRASS=makeStateRule(ModBlocks.GLOOM_GRASS.get());
    private static final SurfaceRules.RuleSource GLOOM_STONE=makeStateRule(ModBlocks.GLOOMSTONE.get());
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isGloomPlains = SurfaceRules.isBiome(ModBiomes.GLOOM_PLAINS);
    SurfaceRules.ConditionSource isAboveWater = SurfaceRules.waterBlockCheck(-1, 0);
    SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAboveWater, GRASS_BLOCK), DIRT);
    SurfaceRules.ConditionSource isAbove50 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(50), 0);
    SurfaceRules.RuleSource gloomRules = SurfaceRules.sequence(
        SurfaceRules.ifTrue(isAbove50,
            SurfaceRules.ifTrue(isAboveWater
            ,SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
            GLOOM_GRASS))
            ),
        SurfaceRules.ifTrue(isAbove50,
            SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, 
            GLOOM_DIRT)
            )
    );

    return SurfaceRules.sequence(
        SurfaceRules.ifTrue(isGloomPlains, gloomRules)
    );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
