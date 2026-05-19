package net.tank.gloom.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tank.gloom.block.ModBlocks;
import net.tank.gloom.block.ModPlantBlocks;
import net.tank.gloom.datagen.recipe.CookingRecipeProvider;
import net.tank.gloom.datagen.recipe.EquipmentRecipeProvider;
import net.tank.gloom.datagen.recipe.MiscRecipeProvider;
import net.tank.gloom.item.ModEquipmentItems;
import net.tank.gloom.item.ModItems;
import net.tank.gloom.tag.ModTags;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        new EquipmentRecipeProvider().register(writer);
        new MiscRecipeProvider().register(writer);
        new CookingRecipeProvider().register(writer);
    }
}
