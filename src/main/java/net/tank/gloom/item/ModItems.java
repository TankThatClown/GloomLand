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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import org.slf4j.Logger;

import net.tank.gloom.GloomMod;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GloomMod.MODID);
        public static final RegistryObject<Item> GLOOM_STONE_ITEM = ITEMS.register("gloom_stone", 
        () -> new BlockItem(ModBlocks.GLOOM_STONE.get(), new Item.Properties()));
        public static final RegistryObject<Item> GLOOM_DIRT_ITEM = ITEMS.register("gloom_dirt", 
        () -> new BlockItem(ModBlocks.GLOOM_DIRT.get(), new Item.Properties()));
        public static final RegistryObject<Item> GLOOM_GRASS_ITEM = ITEMS.register("gloom_grass", 
        () -> new BlockItem(ModBlocks.GLOOM_GRASS.get(), new Item.Properties()));
        public static final RegistryObject<Item> GLOWSHROOM = ITEMS.register("glowshroom",
        ()->new BlockItem(ModBlocks.GLOWSHROOM.get(), 
            new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(3)           
                .saturationMod(0.4f)  
                .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F) // effect and chance
                .build()
        )));
    public static final RegistryObject<Item> GLOWSHROOM_CAP = ITEMS.register("glowshroom_cap",
    ()-> new BlockItem(ModBlocks.GLOWSHROOM_CAP.get(), new Item.Properties()));

     public static final RegistryObject<Item> GLOWSHROOM_STALK = ITEMS.register("glowshroom_stalk",
    ()-> new BlockItem(ModBlocks.GLOWSHROOM_STALK.get(), new Item.Properties()));

     public static final RegistryObject<Item> GLOWSHROOM_SPORE = ITEMS.register("glowshroom_spore",
    ()-> new BlockItem(ModBlocks.GLOWSHROOM_SPORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> GLOOM_IRON_ORE = ITEMS.register("gloom_iron_ore",
    ()-> new BlockItem(ModBlocks.GLOOM_IRON_ORE.get(),new Item.Properties()));
         
    public static final RegistryObject<Item> GLOWING_STICK = ITEMS.register("glowing_stick",
    ()-> new Item(new Item.Properties()));
    
     public static final RegistryObject<Item> MUCK_BOMB = ITEMS.register("muck_bomb",
    ()->new MuckBombItem(new Item.Properties())); 
    
    
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
