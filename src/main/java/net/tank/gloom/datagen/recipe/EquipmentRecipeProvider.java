package net.tank.gloom.datagen.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tank.gloom.block.ModPlantBlocks;
import net.tank.gloom.item.ModEquipmentItems;
import net.tank.gloom.item.ModItems;

import java.util.function.Consumer;

public class EquipmentRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public EquipmentRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {

    }
}
