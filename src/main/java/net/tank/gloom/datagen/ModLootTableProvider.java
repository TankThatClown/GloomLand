package net.tank.gloom.datagen;
import net.tank.gloom.datagen.loot.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.block.ModBlocks;
import net.tank.gloom.block.ModOreBlocks;
import net.tank.gloom.block.ModPlantBlocks;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

    public class ModLootTableProvider {
        public static LootTableProvider create(PackOutput output) {
            return new LootTableProvider(output, Set.of(), List.of(
                    new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
            ));
        }
    }