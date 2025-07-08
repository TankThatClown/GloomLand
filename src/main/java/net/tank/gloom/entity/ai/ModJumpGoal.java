package net.tank.gloom.entity.ai;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class ModJumpGoal extends Goal {
    private final Mob mob;
    private int cooldown;
    private double speed;  // Tune this
    private double jumpHeight;
    public ModJumpGoal(Mob pMob,double speed,double jumpHeight){
        this.mob = pMob;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP));
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
        return (mob.onGround())&&(mob.getRandom().nextInt(20)==0);
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
