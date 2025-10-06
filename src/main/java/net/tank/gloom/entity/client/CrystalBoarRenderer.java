package net.tank.gloom.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.tank.gloom.GloomMod;
import net.tank.gloom.entity.custom.CrystalBoarEntity;
import net.tank.gloom.entity.custom.GlowToadEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrystalBoarRenderer extends GeoEntityRenderer<CrystalBoarEntity> {

    public CrystalBoarRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalBoarModel());
    }
    @Override
    public ResourceLocation getTextureLocation(CrystalBoarEntity pEntity) {
        return new ResourceLocation(GloomMod.MODID, "textures/entity/crystal_boar.png");
    }

    @Override
    public void render(CrystalBoarEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
