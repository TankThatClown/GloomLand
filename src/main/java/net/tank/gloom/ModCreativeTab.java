package net.tank.gloom;
import net.minecraft.core.registries.Registries;
import net.tank.gloom.block.ModOreBlocks;
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
                // Terrain Blocks
                output.accept(ModBlockItems.GLOOMSTONE.get());
                output.accept(ModBlockItems.GLOOM_GRASS.get());
                output.accept(ModBlockItems.MUCK_BLOCK.get());
                output.accept(ModBlockItems.GLOOM_IRON_ORE.get());
                output.accept(ModBlockItems.GLOOM_GOLD_ORE.get());
                output.accept(ModBlockItems.SHADOWSTEEL_ORE.get());
                output.accept(ModBlockItems.DEEPSLATE_SHADOWSTEEL_ORE.get());
                //Plant BLocks
                output.accept(ModBlockItems.GLOWSHROOM_CAP.get());
                output.accept(ModBlockItems.GLOWSHROOM_STALK.get());
                output.accept(ModBlockItems.GLOWSHROOM_SPORE.get());
                output.accept(ModBlockItems.DUSK_LILY.get());
                output.accept(ModBlockItems.SHADOWBERRY_BUSH.get());
                output.accept(ModBlockItems.BARE_SHADOWBERRY_BUSH.get());

                // Items
                output.accept(ModItems.GLOWING_STICK.get());
                output.accept(ModItems.MUCK_BOMB.get());
                output.accept(ModItems.MINER_WISH.get());
                output.accept(ModItems.SHADOWSTEEL_INGOT.get());
                //Equipment
                output.accept(ModEquipmentItems.SHADOWSTEEL_SWORD.get());
                output.accept(ModEquipmentItems.SHADOWSTEEL_AXE.get());
                output.accept(ModEquipmentItems.SHADOWSTEEL_PICKAXE.get());
                output.accept(ModEquipmentItems.SHADOWSTEEL_SHOVEL.get());
                output.accept(ModEquipmentItems.SHADOWSTEEL_HOE.get());

                output.accept(ModEquipmentItems.SHADOWSTEEL_HELMET.get());
                output.accept(ModEquipmentItems.SHADOWSTEEL_CHESTPLATE.get());
                output.accept(ModEquipmentItems.SHADOWSTEEL_LEGGINGS.get());
                output.accept(ModEquipmentItems.SHADOWSTEEL_BOOTS.get());

                // Food
                output.accept(ModFoodItems.GLOWSHROOM.get());
                output.accept(ModFoodItems.SHADOWBERRY.get());
                //Mob Drops
                output.accept(ModMobDropItems.TOAD_HIDE.get());
                // Spawn Eggs
                output.accept(ModSpawnEggItems.GLOW_TOAD_SPAWN_EGG.get());
                output.accept(ModSpawnEggItems.CRYSTAL_BOAR_SPAWN_EGG.get());
            })
            .build()
    );

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
