package net.tank.gloom.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.GloomMod;

public class ModEquipmentItems {
    public static final DeferredRegister<Item> EQUIPMENT_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GloomMod.MODID);
    public static final RegistryObject<Item> SHADOWSTEEL_SWORD= EQUIPMENT_ITEMS.register("shadowsteel_sword",
            ()->new SwordItem(ModTiers.SHADOWSTEEL,3,-2.4F,new Item.Properties()));
    public static final RegistryObject<Item> SHADOWSTEEL_SHOVEL = EQUIPMENT_ITEMS.register("shadowsteel_shovel",
            ()->new ShovelItem(ModTiers.SHADOWSTEEL, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SHADOWSTEEL_PICKAXE = EQUIPMENT_ITEMS.register("shadowsteel_pickaxe",
            ()->new PickaxeItem(ModTiers.SHADOWSTEEL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> SHADOWSTEEL_AXE = EQUIPMENT_ITEMS.register("shadowsteel_axe",
            ()->new AxeItem(ModTiers.SHADOWSTEEL, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SHADOWSTEEL_HOE = EQUIPMENT_ITEMS.register("shadowsteel_hoe",
            ()->new HoeItem(ModTiers.SHADOWSTEEL, -3, 0.0F, new Item.Properties()));
    public static void register(IEventBus eventBus){
        EQUIPMENT_ITEMS.register(eventBus);
    }

}
