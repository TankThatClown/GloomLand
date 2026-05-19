package net.tank.gloom.datagen.loot;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntries;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.block.ModBlocks;
import net.tank.gloom.block.ModOreBlocks;
import net.tank.gloom.block.ModPlantBlocks;
import net.tank.gloom.block.custom.GloomBushBlock;
import net.tank.gloom.item.ModBlockItems;
import net.tank.gloom.item.ModFoodItems;
import net.tank.gloom.item.ModItems;
import net.tank.gloom.tag.ModTags;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;
record ItemWithChance(Item item, float chance) {}

public class ModBlockLootTables extends BlockLootSubProvider{
    public static final LootItemCondition.Builder HASPICKAXE = MatchTool.toolMatches(
            ItemPredicate.Builder.item().of(
            ModTags.PICKAXETAG));
    public static final LootItemCondition.Builder HASGROWN = LootItemBlockStatePropertyCondition
            .hasBlockStateProperties(ModPlantBlocks.SHADOWBERRY_BUSH.get())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GloomBushBlock.AGE, 1));
    LootItemCondition.Builder SILKTOUCHANDGROWN = HASGROWN.and(HAS_SILK_TOUCH);

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

   @Override
    protected void generate() {


       //ModBlocks
        this.dropSelf(ModBlocks.GLOOMSTONE.get());
        this.add(ModBlocks.GLOOM_GRASS.get(), block ->createSingleSilkTouchDrop(ModBlocks.GLOOM_GRASS.get(), Items.DIRT));
        this.add(ModBlocks.MUCK_BLOCK.get(), block ->createSingleIfDrop(ModBlockItems.MUCK_BLOCK.get(),HASPICKAXE));
        // Mod Ore
       this.add(ModOreBlocks.GLOOM_IRON_ORE.get(),block -> createMultiOreDrops(ModOreBlocks.GLOOM_IRON_ORE.get(), Items.IRON_INGOT,2.0f,4.0f));
       this.add(ModOreBlocks.GLOOM_GOLD_ORE.get(),block -> createMultiOreDrops(ModOreBlocks.GLOOM_GOLD_ORE.get(),Items.GOLD_INGOT,2.0f,4.0f));
       this.dropSelf(ModOreBlocks.SHADOWSTEEL_ORE.get());
       this.dropSelf(ModOreBlocks.DEEPSLATE_SHADOWSTEEL_ORE.get());
        //Plant Block
       this.dropSelf(ModPlantBlocks.GLOWSHROOM.get());
       this.dropSelf(ModPlantBlocks.GLOWSHROOM_SPORE.get());
       this.dropSelf(ModPlantBlocks.GLOWSHROOM_STALK.get());
       this.dropSelf(ModPlantBlocks.DUSK_LILY.get());
       this.add(ModPlantBlocks.SHADOWBERRY_BUSH.get(),block ->
                       createIfElseDrop(
                               ModBlockItems.SHADOWBERRY_BUSH.get(),
                               SILKTOUCHANDGROWN,
                               ModBlockItems.BARE_SHADOWBERRY_BUSH.get()
                       ));
       ItemWithChance[] itemChanceArray = {
               new ItemWithChance(ModBlockItems.GLOWSHROOM_CAP.get(),0.1F),
               new ItemWithChance(ModFoodItems.GLOWSHROOM.get(),0.1F)
       };
       this.add(ModPlantBlocks.GLOWSHROOM_CAP.get(), block->
                    createSilkTouchElseAlternativeDrop(
                            ModBlockItems.GLOWSHROOM_CAP.get(),
                            buildAlternativeArray(itemChanceArray)
                    )
               );


   }
    protected LootTable.Builder createSingleSilkTouchDrop(Block block, Item item) {
        return createSilkTouchDispatchTable(block,LootItem.lootTableItem(item));
    }
   protected static LootTable.Builder createIfElseDrop(Item primaryItem, LootItemCondition.Builder conditionBuilder,Item alternativeBlockItem) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(primaryItem)
                                        .when(conditionBuilder)
                                        .otherwise(LootItem.lootTableItem(alternativeBlockItem))
                                )
                );
    }
    protected static LootTable.Builder createSingleIfDrop(Item item, LootItemCondition.Builder conditionBuilder) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(item)
                                .when(conditionBuilder)
                        )
                );
    }
    protected LootTable.Builder createMultiOreDrops(Block block, Item item,float min, float max) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    protected LootTable.Builder createSilkTouchElseAlternativeDrop(Item mainItem, LootPoolEntryContainer.Builder[] alternativeList)
    {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(mainItem)
                                .when(HAS_SILK_TOUCH)
                                .otherwise(
                                        AlternativesEntry.alternatives(
                                                alternativeList
                                        )
                                )
                        )
                );
    }
    protected LootPoolEntryContainer.Builder[] buildAlternativeArray(ItemWithChance[]arr){
        LootPoolEntryContainer.Builder[] alternativeList =Arrays.stream(arr).map(alt ->
                LootItem.lootTableItem(alt.item())
                .when(LootItemRandomChanceCondition.randomChance(alt.chance())))
                .toArray(LootPoolEntryContainer.Builder[]::new);
        return alternativeList;
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
