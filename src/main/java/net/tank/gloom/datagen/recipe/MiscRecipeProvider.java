package net.tank.gloom.datagen.recipe;

import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tank.gloom.block.ModBlocks;
import net.tank.gloom.block.ModPlantBlocks;
import net.tank.gloom.item.ModItems;
import net.tank.gloom.tag.ModTags;
import java.util.function.Consumer;


public class MiscRecipeProvider {


    public void register(Consumer<FinishedRecipe> writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLOWING_STICK.get(), 8)
                .pattern("X")
                .pattern("X")
                .define('X', ModPlantBlocks.GLOWSHROOM_STALK.get())
                .unlockedBy(getHasName(ModPlantBlocks.GLOWSHROOM_STALK.get()), has(ModPlantBlocks.GLOWSHROOM_STALK.get()))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MINER_WISH.get(),2)
                .pattern("CCC")
                .pattern("III")
                .pattern("GGG")
                .define('C', Items.COAL_BLOCK)
                .define('I', Items.IRON_BLOCK)
                .define('G', Items.GOLD_BLOCK)
                .unlockedBy(getHasName(Items.GOLD_BLOCK), has(Items.GOLD_BLOCK))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MUCK_BOMB.get())
                .pattern(" M ")
                .pattern("STS")
                .pattern("SMS")
                .define('S', ModTags.STONE_REPLACEABLES)
                .define('T', Items.TNT)
                .define('M', ModBlocks.MUCK_BLOCK.get())
                .unlockedBy(getHasName(Items.TNT), has(Items.TNT))
                .save(writer);

    }
    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(new ItemLike[]{pItemLike}).build());
    }
    protected static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... pPredicates) {
        return new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, pPredicates);
    }
    protected static String getHasName(ItemLike pItemLike) {
        return "has_" + getItemName(pItemLike);
    }
    protected static String getItemName(ItemLike pItemLike) {
        return BuiltInRegistries.ITEM.getKey(pItemLike.asItem()).getPath();
    }
}
