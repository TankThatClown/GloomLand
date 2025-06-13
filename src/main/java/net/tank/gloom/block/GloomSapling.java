package net.tank.gloom.block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
public class GloomSapling extends SaplingBlock{
        
        public GloomSapling(AbstractTreeGrower grower,Properties properties) {
            super(grower,properties);
        }

         public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = world.getBlockState(belowPos);
        return belowState.is(ModBlocks.GLOOM_DIRT.get()) || belowState.is(ModBlocks.GLOOM_GRASS.get());
        } 
    }