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

public class ModFoodItems {
            public static final DeferredRegister<Item> FOOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GloomMod.MODID);
            public static final RegistryObject<Item> GLOWSHROOM = FOOD_ITEMS.register("glowshroom",
        ()->new BlockItem(ModPlantBlocks.GLOWSHROOM.get(), 
            new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(3)           
                .saturationMod(0.4f)  
                .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F) // effect and chance
                .build()
        )));

         public static void register(IEventBus eventBus){
        FOOD_ITEMS.register(eventBus);
    }
}
