package net.tank.gloom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModBlocks{
    public static final String MODID = "gloom";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> GLOOM_STONE = BLOCKS.register("gloom_stone", 
    () -> new Block(BlockBehaviour.Properties.of()
        .mapColor(MapColor.STONE)
        .strength(2.5f,7.0f)
        .sound(SoundType.STONE)
        .requiresCorrectToolForDrops()
    ));
     public static final RegistryObject<Block> GLOOM_DIRT = BLOCKS.register("gloom_dirt", 
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

     public static final RegistryObject<Block> GLOOM_GRASS = BLOCKS.register("gloom_grass", 
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
    public static final RegistryObject<Block> GLOWSHROOM = BLOCKS.register("glowshroom",
    ()-> new GloomPlant(BlockBehaviour.Properties.of()
    .instabreak()
    .mapColor(MapColor.COLOR_BLUE)
    .sound(SoundType.CROP)
    .noCollission()
    .lightLevel(state->16)));

    public static final RegistryObject<Block> GlOWSHROOM_CAP= BLOCKS.register("glowshroom_cap",
    ()-> new Block(BlockBehaviour.Properties.of()
    .mapColor(MapColor.COLOR_LIGHT_BLUE)
    .sound(SoundType.GRASS)
    .strength(0.2f,0.0f)
    .lightLevel(state->16)
    ));

    public static final RegistryObject<Block> GLOWSHROOM_STALK= BLOCKS.register("glowshroom_stalk",
    ()-> new Block(BlockBehaviour.Properties.of()
    .mapColor(MapColor.COLOR_GRAY)
    .sound(SoundType.WOOD)
    .strength(1.0f,2.0f)
    .lightLevel(state->16)
    ));

    static{
            GloomMod.transparentBlock.add(GLOWSHROOM);
    }
    public static class GloomPlant extends BushBlock{
        public GloomPlant(Properties properties) {
            super(properties);
        }

        public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = world.getBlockState(belowPos);
        return belowState.is(GLOOM_DIRT.get()) || belowState.is(GLOOM_GRASS.get());
        } 
    }  
}