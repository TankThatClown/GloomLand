package net.tank.gloom.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tank.gloom.entity.ModEntities;
import net.tank.gloom.entity.custom.GlowToadEntity;

import static net.tank.gloom.GloomMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModCommonEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GLOW_TOAD_ENTITY.get(), GlowToadEntity.createAttributes().build());
    }
}
