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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.tank.gloom.GloomMod;
public class ModBlocks{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GloomMod.MODID);
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

    public static final RegistryObject<Block> MUCK_BLOCK = BLOCKS.register("muck_block", 
    () -> new EffectBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_GREEN)
                .strength(3.0f,8.0f)
                .sound(SoundType.MUD)
                .requiresCorrectToolForDrops()
    ,new MobEffectInstance(MobEffects.POISON, 100, 0)));

     public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
    
    
}