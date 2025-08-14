package net.tank.gloom.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.tank.gloom.entity.ModEntities;
import net.tank.gloom.entity.client.GlowToadModel;
import net.tank.gloom.entity.client.GlowToadRenderer;
import net.tank.gloom.entity.client.ModModelLayer;
import static net.tank.gloom.GloomMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        // Some client setup code
        EntityRenderers.register(ModEntities.MUCK_BOMB_ENTITY.get(), ThrownItemRenderer::new);
        EntityRenderers.register(ModEntities.GLOW_TOAD_ENTITY.get(), GlowToadRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayer.GLOW_TOAD_LAYER, GlowToadModel::createBodyLayer);
    }


}
