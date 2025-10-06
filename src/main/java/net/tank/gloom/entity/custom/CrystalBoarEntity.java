package net.tank.gloom.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.item.Items;

import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.tank.gloom.entity.ModEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CrystalBoarEntity extends Animal implements GeoEntity {
    private MeleeAttackGoal meleeAttackGoal;
    private PanicGoal panicGoal;
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(CrystalBoarEntity.class, EntityDataSerializers.BOOLEAN);
    public int attackAnimationDuration = 20;

    public CrystalBoarEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Override
    public void tick() {
        super.tick();
        if(getAttacking()){
            attackAnimationDuration--;
            if(attackAnimationDuration<0){
                setAttacking(false);
                attackAnimationDuration=20;
            }
        }
    }

    @Override
    public void aiStep(){
        super.aiStep();
        this.updateSwingTime();
    }
    public boolean getAttacking(){
        return this.entityData.get(ATTACKING);
    }
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.CRYSTAL_BOAR_ENTITY.get().create(pLevel);
    }
    /*@Override
    public int getCurrentSwingDuration(){
        return 20;
    } */
    @Override
    protected SoundEvent getAmbientSound(){
        return SoundEvents.HOGLIN_AMBIENT;
    }
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.HOGLIN_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.HOGLIN_DEATH;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ATTACK_DAMAGE,4f)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK,1f)
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
         meleeAttackGoal = new MeleeAttackGoal(this, 1.2f, false){
             @Override
             protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
                 double d0 = this.getAttackReachSqr(pEnemy);
                 if (pDistToEnemySqr <= d0 && this.getTicksUntilNextAttack() <= 0) {
                     ((CrystalBoarEntity)this.mob).setAttacking(true);
                     this.resetAttackCooldown();
                     this.mob.swing(InteractionHand.MAIN_HAND);
                     this.mob.doHurtTarget(pEnemy);
                 }
             }
             @Override
             public void stop(){
                 super.stop();
                 attackAnimationDuration=20;
                 ((CrystalBoarEntity)this.mob).setAttacking(false);
             }
             @Override
             protected int getAttackInterval() {
                 return 20;
             }
             @Override
             public boolean canUse() {
                 return !(CrystalBoarEntity.this.isBaby()) && super.canUse();
             }
         };
         panicGoal = new PanicGoal(this,1.5D){
             @Override
             public boolean canUse() {
                 return CrystalBoarEntity.this.isBaby() && super.canUse();
             }
         };
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1,meleeAttackGoal);
        this.goalSelector.addGoal(1, panicGoal);
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return CrystalBoarEntity.this.isBaby() && super.canUse();
            }
        }).setAlertOthers()); // retaliate when attacked
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this){
            @Override
            public boolean canUse() {
                return !(CrystalBoarEntity.this.isBaby()) && super.canUse();
            }
        }));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.GOLDEN_CARROT), false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

    }
    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.GOLDEN_CARROT); // or your custom breeding item
    }
    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "Move", state -> {
            return (state.isMoving() ? state.setAndContinue(DefaultAnimations.WALK)
                    :state.setAndContinue(DefaultAnimations.IDLE));
        }));

        controllerRegistrar.add(new AnimationController<>(this, "Attack", state -> {
            if (getAttacking())
                return state.setAndContinue(DefaultAnimations.ATTACK_SWING);
            state.resetCurrentAnimation();

            return PlayState.STOP;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
