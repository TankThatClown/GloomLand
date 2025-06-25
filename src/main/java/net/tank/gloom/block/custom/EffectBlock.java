package net.tank.gloom.block.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
public class EffectBlock extends Block {
    MobEffectInstance effect;
    public EffectBlock(Properties properties,MobEffectInstance effect){
        super(properties);
        this.effect=effect;
    }

    @Override
    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        if(!world.isClientSide&&entity instanceof LivingEntity){
            LivingEntity living = (LivingEntity)entity;
            if (!living.hasEffect(effect.getEffect())) {
                living.addEffect(new MobEffectInstance(effect));
            } else {
                MobEffectInstance current = living.getEffect(effect.getEffect());
                if (current.getDuration() < 20) {
                    living.addEffect(new MobEffectInstance(effect));
                }
            }
        }
        super.stepOn(world, pos, state, entity);
    }
}
