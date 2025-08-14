package net.tank.gloom;
import java.util.ArrayList;

import com.mojang.logging.LogUtils;

import net.tank.gloom.block.*;
import net.tank.gloom.item.*;
import net.tank.gloom.worldgen.biome.ModTerrablender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import terrablender.api.SurfaceRuleManager;
import org.slf4j.Logger;
import net.tank.gloom.entity.*;
import net.tank.gloom.entity.client.*;
import net.tank.gloom.entity.custom.*;
import net.tank.gloom.worldgen.biome.surface.ModSurfaceRule;
// The value here should match an entry in the META-INF/mods.toml file
@Mod(GloomMod.MODID)
public class GloomMod
{
    public static final String MODID = "gloom";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GloomMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        ModBlocks.register(modEventBus);
        ModOreBlocks.register(modEventBus);
        ModPlantBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlockItems.register(modEventBus);
        ModFoodItems.register(modEventBus);
        ModMobDropItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSpawnEggItems.register(modEventBus);
        ModTerrablender.registerBiomes();
        //Register the Deferred Register to the mod event bus so tabs get registered
        ModCreativeTab.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        event.enqueueWork(() -> {
             SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRule.makeRules());
        });
    } 

    // Add the example block item to the building blocks tab
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
