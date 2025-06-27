package net.tank.gloom.entity.custom;
import net.tank.gloom.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.tank.gloom.item.ModItems;
import net.minecraft.core.BlockPos;
import net.tank.gloom.block.*;
public class MuckBombEntity extends ThrowableItemProjectile{
    public MuckBombEntity(EntityType<? extends ThrowableItemProjectile> type, Level world) {
        super(type, world);
    }
    public MuckBombEntity(Level world) {
        super(ModEntities.MUCK_BOMB_ENTITY.get(), world);
    }
    public MuckBombEntity(Level world, LivingEntity shooter) {
        super(ModEntities.MUCK_BOMB_ENTITY.get(), shooter, world);
    }
    @Override
    protected Item getDefaultItem() {
        return ModItems.MUCK_BOMB.get();
    }
    

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        int startX=(int)this.getX()-1;
        int endX=(int)this.getX()+1;
        int startY = (int)(this.getY());
        int endY = (int)(this.getY())-2;
        int startZ = (int)(this.getZ() - 1);
        int endZ = (int)(this.getZ() + 1);
        
        BlockPos centerPos = new BlockPos((int)this.getX(),(int)this.getY(),(int)this.getZ());
        BlockState centerState = this.level().getBlockState(centerPos);
        BlockState aboveState = this.level().getBlockState(centerPos.above());
        
        boolean canPlace= !(centerState.liquid()||
        aboveState.liquid()||
        this.isInWater()||
        this.isInLava());
        if(!this.level().isClientSide()) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3.0f, Level.ExplosionInteraction.TNT);
            
            if(canPlace)
            {
            for(int xPos=startX;xPos<=endX;xPos++){
                for(int zPos=startZ;zPos<=endZ;zPos++){
                    for(int yPos=startY;yPos>=endY;yPos--){
                        BlockPos pos = new BlockPos(xPos, yPos, zPos);
                        BlockState state = this.level().getBlockState(pos);
                        if (!(this.level().isEmptyBlock(pos)||state.liquid()||state.is(Blocks.BEDROCK))) {
                            this.level().setBlock(pos, ModBlocks.MUCK_BLOCK.get().defaultBlockState(), 3);
                         }
                    }
                }
            }
            }
            this.level().broadcastEntityEvent(this, ((byte) 3)); 
        }

        this.discard();
        super.onHitBlock(pResult);
       
    } 
}
