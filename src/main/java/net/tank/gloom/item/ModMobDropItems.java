package net.tank.gloom.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.GloomMod;

public class ModMobDropItems {
    public static final DeferredRegister<Item> MOB_DROP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GloomMod.MODID);

    public static final RegistryObject<Item> TOAD_HIDE = MOB_DROP_ITEMS.register("toad_hide",
            ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){ MOB_DROP_ITEMS.register(eventBus);
    }

}
