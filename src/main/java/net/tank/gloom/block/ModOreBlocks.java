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
public class ModOreBlocks {
        public static final DeferredRegister<Block> ORE_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GloomMod.MODID);
          public static final RegistryObject<Block> GLOOM_IRON_ORE = ORE_BLOCKS.register("gloom_iron_ore",
    ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final RegistryObject<Block> GLOOM_GOLD_ORE = ORE_BLOCKS.register("gloom_gold_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));

     public static void register(IEventBus eventBus){
        ORE_BLOCKS.register(eventBus);
    }
}
