package net.tank.gloom.datagen.recipe;

import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tank.gloom.block.ModPlantBlocks;
import net.tank.gloom.item.ModEquipmentItems;
import net.tank.gloom.item.ModItems;

import java.util.function.Consumer;

public class EquipmentRecipeProvider {


    public void register(Consumer<FinishedRecipe> writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModEquipmentItems.SHADOWSTEEL_SWORD.get())
                .pattern("S")
                .pattern("S")
                .pattern("G")
                .define('S', ModItems.SHADOWSTEEL_INGOT.get())
                .define('G',ModItems.GLOWING_STICK.get())
                .unlockedBy(getHasName(ModItems.SHADOWSTEEL_INGOT.get()), has(ModItems.SHADOWSTEEL_INGOT.get()))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModEquipmentItems.SHADOWSTEEL_AXE.get())
                .pattern("SS")
                .pattern("SG")
                .pattern(" G")
                .define('S', ModItems.SHADOWSTEEL_INGOT.get())
                .define('G',ModItems.GLOWING_STICK.get())
                .unlockedBy(getHasName(ModItems.SHADOWSTEEL_INGOT.get()), has(ModItems.SHADOWSTEEL_INGOT.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModEquipmentItems.SHADOWSTEEL_PICKAXE.get())
                .pattern("SSS")
                .pattern(" G ")
                .pattern(" G ")
                .define('S', ModItems.SHADOWSTEEL_INGOT.get())
                .define('G',ModItems.GLOWING_STICK.get())
                .unlockedBy(getHasName(ModItems.SHADOWSTEEL_INGOT.get()), has(ModItems.SHADOWSTEEL_INGOT.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModEquipmentItems.SHADOWSTEEL_SHOVEL.get())
                .pattern("S")
                .pattern("G")
                .pattern("G")
                .define('S', ModItems.SHADOWSTEEL_INGOT.get())
                .define('G',ModItems.GLOWING_STICK.get())
                .unlockedBy(getHasName(ModItems.SHADOWSTEEL_INGOT.get()), has(ModItems.SHADOWSTEEL_INGOT.get()))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModEquipmentItems.SHADOWSTEEL_HOE.get())
                .pattern("SS")
                .pattern(" G")
                .pattern(" G")
                .define('S', ModItems.SHADOWSTEEL_INGOT.get())
                .define('G',ModItems.GLOWING_STICK.get())
                .unlockedBy(getHasName(ModItems.SHADOWSTEEL_INGOT.get()), has(ModItems.SHADOWSTEEL_INGOT.get()))
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
