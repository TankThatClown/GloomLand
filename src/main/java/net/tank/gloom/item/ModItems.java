package net.tank.gloom.item;
import net.tank.gloom.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.food.FoodProperties;
import net.tank.gloom.item.custom.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import org.slf4j.Logger;

import net.tank.gloom.GloomMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GloomMod.MODID);
  
    public static final RegistryObject<Item> GLOWING_STICK = ITEMS.register("glowing_stick",
    ()-> new Item(new Item.Properties()));
    
     public static final RegistryObject<Item> MUCK_BOMB = ITEMS.register("muck_bomb",
    ()->new MuckBombItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> MINER_WISH = ITEMS.register("miner_wish",
            ()->new MinerWishItem(new Item.Properties().stacksTo(16)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
