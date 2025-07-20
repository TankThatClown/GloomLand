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
import net.tank.gloom.GloomMod;
import net.tank.gloom.block.*;
public class ModBlockItems {
            public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GloomMod.MODID);
            public static final RegistryObject<Item> GLOOMSTONE =BLOCK_ITEMS.register("gloomstone",
        () -> new BlockItem(ModBlocks.GLOOMSTONE.get(), new Item.Properties()));
        public static final RegistryObject<Item> GLOOM_DIRT = BLOCK_ITEMS.register("gloom_dirt", 
        () -> new BlockItem(ModBlocks.GLOOM_DIRT.get(), new Item.Properties()));
        public static final RegistryObject<Item> GLOOM_GRASS= BLOCK_ITEMS.register("gloom_grass", 
        () -> new BlockItem(ModBlocks.GLOOM_GRASS.get(), new Item.Properties()));
    public static final RegistryObject<Item> GLOWSHROOM_CAP = BLOCK_ITEMS.register("glowshroom_cap",
    ()-> new BlockItem(ModPlantBlocks.GLOWSHROOM_CAP.get(), new Item.Properties()));

     public static final RegistryObject<Item> GLOWSHROOM_STALK = BLOCK_ITEMS.register("glowshroom_stalk",
    ()-> new BlockItem(ModPlantBlocks.GLOWSHROOM_STALK.get(), new Item.Properties()));

     public static final RegistryObject<Item> GLOWSHROOM_SPORE = BLOCK_ITEMS.register("glowshroom_spore",
    ()-> new BlockItem(ModPlantBlocks.GLOWSHROOM_SPORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> GLOOM_IRON_ORE = BLOCK_ITEMS.register("gloom_iron_ore",
    ()-> new BlockItem(ModOreBlocks.GLOOM_IRON_ORE.get(),new Item.Properties()));

    public static final RegistryObject<Item> GLOOM_GOLD_ORE = BLOCK_ITEMS.register("gloom_gold_ore",
            ()-> new BlockItem(ModOreBlocks.GLOOM_GOLD_ORE.get(),new Item.Properties()));

      public static final RegistryObject<Item> DUSK_LILY = BLOCK_ITEMS.register("dusk_lily",
    ()-> new BlockItem(ModPlantBlocks.DUSK_LILY.get(),new Item.Properties()));

      public static final RegistryObject<Item> MUCK_BLOCK = BLOCK_ITEMS.register("muck_block",
    ()-> new BlockItem(ModBlocks.MUCK_BLOCK.get(),new Item.Properties()));

     public static void register(IEventBus eventBus){
        BLOCK_ITEMS.register(eventBus);
    }
}
