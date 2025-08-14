package net.tank.gloom.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class ModLeapGoal extends Goal {
    private final Mob mob;
    private int cooldown;
    private double speed;  // Tune this
    private double jumpHeight;
    public ModLeapGoal(Mob pMob,double speed,double jumpHeight){
        this.mob = pMob;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Flag.MOVE));
        this.speed = speed;
        this.jumpHeight=jumpHeight;
        cooldown=100;
    }

    @Override
    public boolean canUse() {
        if(cooldown>0){
            cooldown--;
            return false;
        }

        Level level = mob.level();
        float yaw = mob.getYRot();
        double rad = Math.toRadians(yaw);
        double dx = -Math.sin(rad); // X offset
        double dz = Math.cos(rad);  // Z offset
        BlockPos frontPos = mob.blockPosition().offset((int)Math.round(dx*2), 0, (int)Math.round(dz*2));
        BlockPos groundPos= frontPos.below();
        boolean forwardCheck=level.getBlockState(frontPos).isAir();
        boolean belowCheck=level.getBlockState(groundPos).isSolidRender(level,groundPos);
        boolean frontCheck=forwardCheck&&belowCheck;
        return (mob.onGround())&&(mob.getRandom().nextInt(20)==0)&&(frontCheck);
    }
    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void start() {
        super.start();
        double yVelocity= Math.sqrt(2*0.08*jumpHeight);
        Vec3 lookVec = mob.getLookAngle();
        mob.setDeltaMovement(
                lookVec.x * speed,
                yVelocity,
                lookVec.z * speed
        );
        cooldown=200;
    }
}
