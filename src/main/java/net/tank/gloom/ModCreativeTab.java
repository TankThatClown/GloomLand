package net.tank.gloom;
import net.minecraft.core.registries.Registries;
import net.tank.gloom.item.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.network.chat.Component;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import org.slf4j.Logger;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GloomMod.MODID);

    public static final RegistryObject<CreativeModeTab> GLOOM_TAB = TABS.register("gloom_tab", () ->
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.gloom_tab")) // Your tab's display name
            .icon(() -> new ItemStack(ModBlockItems.MUCK_BLOCK.get()))
            .displayItems((itemDisplayParameters,output)->{
                output.accept(ModBlockItems.GLOOM_STONE.get());
                output.accept(ModBlockItems.GLOOM_DIRT.get());
                output.accept(ModBlockItems.GLOOM_GRASS.get());
                output.accept(ModBlockItems.MUCK_BLOCK.get());
                output.accept(ModFoodItems.GLOWSHROOM.get());
                output.accept(ModBlockItems.GLOWSHROOM_CAP.get());
                output.accept(ModBlockItems.GLOWSHROOM_STALK.get());
                output.accept(ModBlockItems.GLOOM_IRON_ORE.get());
                output.accept(ModBlockItems.GLOWSHROOM_SPORE.get());
                output.accept(ModItems.GLOWING_STICK.get());
                output.accept(ModItems.MUCK_BOMB.get()); 
                output.accept(ModBlockItems.DUSK_LILY.get());
            })
            .build()
    );

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
