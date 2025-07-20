package net.tank.gloom.entity.custom;
import net.tank.gloom.entity.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.tank.gloom.entity.ai.ModJumpGoal;
import org.jetbrains.annotations.Nullable;

import net.tank.gloom.item.ModFoodItems;
import net.tank.gloom.item.ModItems;
public class GlowToadEntity extends Animal{
public GlowToadEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }
        @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.GLOW_TOAD_ENTITY.get().create(pLevel);
    }
    @Override
    protected SoundEvent getAmbientSound(){
        return SoundEvents.FROG_AMBIENT;
    }
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.FROG_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.FROG_DEATH;
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 12D)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }
    @Override
public boolean checkSpawnRules(LevelAccessor world, MobSpawnType spawnReason) {
    BlockPos pos = this.blockPosition();
    return world.getBlockState(pos.below()).isSolid() &&
           super.checkSpawnRules(world, spawnReason);
}
     @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this,1.5D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, Ingredient.of(ModFoodItems.GLOWSHROOM.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5,new ModJumpGoal(this,0.8D,2.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

    }
     @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ModFoodItems.GLOWSHROOM.get()); // or your custom breeding item
    }
}