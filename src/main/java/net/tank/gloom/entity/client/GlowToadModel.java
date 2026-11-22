package net.tank.gloom.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.tank.gloom.entity.custom.CrystalBoarEntity;
import net.tank.gloom.entity.custom.GlowToadEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import static net.tank.gloom.GloomMod.MODID;

public class GlowToadModel extends DefaultedEntityGeoModel<GlowToadEntity> {
	public GlowToadModel() {
		super(new ResourceLocation(MODID, "glow_toad"));
	}
	@Override
	public ResourceLocation getTextureResource(GlowToadEntity entity) {
		return new ResourceLocation(MODID, "textures/entity/glow_toad.png");
	}

	@Override
	public ResourceLocation getAnimationResource(GlowToadEntity entity) {
		return new ResourceLocation(MODID, "animations/glow_toad.animation.json");
	}

	@Override
	public void setCustomAnimations(GlowToadEntity entity, long instanceId,
									AnimationState<GlowToadEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		EntityModelData modelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

		if (head == null || modelData == null) {
			return;
		}

		float yaw = Mth.clamp(modelData.netHeadYaw(), -30.0F, 30.0F);
		float pitch = Mth.clamp(modelData.headPitch(), -25.0F, 45.0F);

		head.setRotY(-yaw * Mth.DEG_TO_RAD);
		head.setRotX(-pitch * Mth.DEG_TO_RAD);
	}
}