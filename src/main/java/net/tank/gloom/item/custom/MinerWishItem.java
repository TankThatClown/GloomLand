package net.tank.gloom.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tank.gloom.tag.ModTags;

public class MinerWishItem extends Item {

    public MinerWishItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!level.isClientSide) {
            Player player = pContext.getPlayer();
            if (player != null) {
                BlockPos startBlockPos = pContext.getClickedPos();
                int x = startBlockPos.getX();
                int y = startBlockPos.getY();
                int z = startBlockPos.getZ();
                Direction facing = player.getDirection();
                int fx = facing.getStepX();
                int fz = facing.getStepZ();
                int rx = -fz;
                int rz = fx;
                for (int forward = 0; forward <= 40; forward++) {
                    for (int right = -5; right <= 5; right++) {
                        for (int up = 0; up <= 10; up++) {
                            int targetX = x + fx * forward + rx * right;
                            int targetZ = z + fz * forward + rz * right;
                            int targetY = y + up;
                            BlockPos targetBlockPos = new BlockPos(targetX, targetY, targetZ);
                            BlockState state = level.getBlockState(targetBlockPos);
                            if (!level.isEmptyBlock(targetBlockPos)&&(state.is(ModTags.WISH_CAN_DESTROY))) {
                                level.destroyBlock(targetBlockPos, false, player);
                            }
                        }
                    }
                }
                pContext.getItemInHand().shrink(1);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
