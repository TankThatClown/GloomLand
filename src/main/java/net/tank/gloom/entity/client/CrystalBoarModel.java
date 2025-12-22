package net.tank.gloom.entity.client;



import net.minecraft.resources.ResourceLocation;

import net.minecraft.util.Mth;
import net.tank.gloom.entity.custom.CrystalBoarEntity;

import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import net.tank.gloom.GloomMod;
import software.bernie.geckolib.model.data.EntityModelData;

import static net.tank.gloom.GloomMod.MODID;


public class CrystalBoarModel extends DefaultedEntityGeoModel<CrystalBoarEntity> {

    public CrystalBoarModel() {
        super(new ResourceLocation(MODID, "crystal_boar"));
    }

    @Override
    public ResourceLocation getTextureResource(CrystalBoarEntity entity) {
        return new ResourceLocation(MODID, "textures/entity/crystal_boar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrystalBoarEntity entity) {
        return new ResourceLocation(MODID, "animations/crystal_boar.animation.json");
    }
    @Override
    public void setCustomAnimations(CrystalBoarEntity animatable, long instanceId, AnimationState<CrystalBoarEntity> animationState) {
       /* CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null&&(!animatable.getAttacking())) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(-entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(-entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }*/
    }
}