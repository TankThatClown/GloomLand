package net.tank.gloom.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.tank.gloom.GloomMod;
import net.tank.gloom.entity.custom.GlowToadEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GlowToadRenderer extends GeoEntityRenderer<GlowToadEntity> {

    public GlowToadRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GlowToadModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GlowToadEntity entity) {
        return new ResourceLocation(GloomMod.MODID, "textures/entity/glow_toad.png");
    }

    @Override
    public void render(GlowToadEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        if (entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
}