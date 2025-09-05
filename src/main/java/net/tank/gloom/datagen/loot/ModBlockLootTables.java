package net.tank.gloom.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.block.ModBlocks;
import net.tank.gloom.block.ModOreBlocks;
import net.tank.gloom.block.ModPlantBlocks;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLootSubProvider{
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.GLOOM_DIRT.get());
        this.dropSelf(ModPlantBlocks.GLOWSHROOM.get());
        this.dropSelf(ModPlantBlocks.GLOWSHROOM_STALK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Stream.of(
                        ModBlocks.BLOCKS.getEntries().stream(),
                        ModOreBlocks.ORE_BLOCKS.getEntries().stream(),
                        ModPlantBlocks.PLANT_BLOCKS.getEntries().stream()
                )
                .flatMap(s -> s.map(RegistryObject::get))::iterator;
    }
}
