package net.tank.gloom;
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

public class ModItems {
        public static final String MODID = "gloom";
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
        public static final RegistryObject<Item> GLOOM_STONE_ITEM = ITEMS.register("gloom_stone", () -> new BlockItem(ModBlocks.GLOOM_STONE.get(), new Item.Properties()));
        public static final RegistryObject<Item> GLOOM_DIRT_ITEM = ITEMS.register("gloom_dirt", () -> new BlockItem(ModBlocks.GLOOM_DIRT.get(), new Item.Properties()));
        public static final RegistryObject<Item> GLOOM_GRASS_ITEM = ITEMS.register("gloom_grass", () -> new BlockItem(ModBlocks.GLOOM_GRASS.get(), new Item.Properties()));
        public static final RegistryObject<Item> GLOWSHROOM = ITEMS.register("glowshroom",
        ()->new GlowBlockItem(ModBlocks.GLOWSHROOM.get(), 
            new Item.Properties()
            .food(new FoodProperties.Builder()
                .nutrition(3)           // how much hunger it restores
                .saturationMod(0.4f)   // saturation modifier
                .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F) // effect and chance
                .build()
        )));

         public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    public static class GlowBlockItem extends BlockItem{
        public GlowBlockItem(Block block,Properties properties){
            super(block,properties);
        }

        @Override
        public boolean isFoil(ItemStack pStack) {
            return true;
        }
    }
}
