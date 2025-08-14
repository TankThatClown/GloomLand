package net.tank.gloom.block;
import net.tank.gloom.block.grower.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.Blocks;
import net.tank.gloom.block.custom.*;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.GloomMod;
import net.tank.gloom.item.ModBlockItems;
import net.tank.gloom.item.ModFoodItems;

public class ModPlantBlocks {
     public static final DeferredRegister<Block> PLANT_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GloomMod.MODID);
      public static final RegistryObject<Block> GLOWSHROOM = PLANT_BLOCKS.register("glowshroom",
    ()-> new GloomPlant(BlockBehaviour.Properties.of()
    .instabreak()
    .mapColor(MapColor.COLOR_BLUE)
    .sound(SoundType.CROP)
    .noCollission()
    .lightLevel(state->16)));

    public static final RegistryObject<Block> GLOWSHROOM_CAP= PLANT_BLOCKS.register("glowshroom_cap",
    ()-> new Block(BlockBehaviour.Properties.of()
    .mapColor(MapColor.COLOR_LIGHT_BLUE)
    .sound(SoundType.GRASS)
    .strength(0.2f,0.0f)
    .lightLevel(state->16)
    ));

    public static final RegistryObject<Block> GLOWSHROOM_STALK= PLANT_BLOCKS.register("glowshroom_stalk",
    ()-> new Block(BlockBehaviour.Properties.of()
    .mapColor(MapColor.COLOR_GRAY)
    .sound(SoundType.WOOD)
    .strength(1.0f,2.0f)
    .lightLevel(state->16)
    ));

     public static final RegistryObject<Block> GLOWSHROOM_SPORE = PLANT_BLOCKS.register("glowshroom_spore",
    ()-> new GloomSapling(new GlowshroomGrower(),BlockBehaviour.Properties.of()
    .instabreak()
    .mapColor(MapColor.COLOR_BLUE)
    .sound(SoundType.CROP)
    .noCollission()
    .randomTicks()
    .lightLevel(state->16)));

     public static final RegistryObject<Block> DUSK_LILY = PLANT_BLOCKS.register("dusk_lily",
    ()-> new GloomPlant(BlockBehaviour.Properties.of()
    .instabreak()
    .mapColor(MapColor.COLOR_BLUE)
    .sound(SoundType.GRASS)
    .noCollission()
    .lightLevel(state->16)));

    public static final RegistryObject<Block> SHADOWBERRY_BUSH = PLANT_BLOCKS.register("shadowberry_bush",
            ()-> new GloomBushBlock(ModFoodItems.SHADOWBERRY,
                    BlockBehaviour.Properties.of()
                            .strength(0.2f,0.1f)
                            .noOcclusion()
                            .mapColor(MapColor.COLOR_LIGHT_GREEN)
                            .sound(SoundType.GRASS)
                            .randomTicks()
                    ));

     public static void register(IEventBus eventBus){
        PLANT_BLOCKS.register(eventBus);
    }

}
