package net.tank.gloom.block.custom;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.tank.gloom.block.ModBlocks;
public  class GloomPlant extends BushBlock{
        public GloomPlant(Properties properties) {
            super(properties);
        }

        public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = world.getBlockState(belowPos);
        return belowState.is(ModBlocks.GLOOM_DIRT.get()) || belowState.is(ModBlocks.GLOOM_GRASS.get());
        } 
    }