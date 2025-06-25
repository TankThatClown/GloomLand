package net.tank.gloom.entity.client;
import com.mojang.blaze3d.vertex.PoseStack;

import net.tank.gloom.GloomMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.tank.gloom.entity.custom.GlowToadEntity;

public class GlowToadRenderer extends MobRenderer<GlowToadEntity, GlowToadModel<GlowToadEntity>> {
    public GlowToadRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GlowToadModel<>(pContext.bakeLayer(ModModelLayer.GLOW_TOAD_LAYER)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(GlowToadEntity pEntity) {
        return new ResourceLocation(GloomMod.MODID, "textures/entity/toad_texture.png");
    }

    @Override
    public void render(GlowToadEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}