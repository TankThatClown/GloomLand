package net.tank.gloom.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.GloomMod;
import net.tank.gloom.entity.ModEntities;

public class ModSpawnEggItems {
    public static final DeferredRegister<Item> SPAWN_EGG_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GloomMod.MODID);

    public static final RegistryObject<Item> GLOW_TOAD_SPAWN_EGG = SPAWN_EGG_ITEMS.register("glow_toad_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntities.GLOW_TOAD_ENTITY, 0x57B3F4,0x498EE0,
                            new Item.Properties()));

    public static void register(IEventBus eventBus){
        SPAWN_EGG_ITEMS.register(eventBus);
    }
}
