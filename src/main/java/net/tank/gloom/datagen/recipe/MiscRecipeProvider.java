package net.tank.gloom.datagen.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tank.gloom.block.ModBlocks;
import net.tank.gloom.block.ModPlantBlocks;
import net.tank.gloom.item.ModItems;
import net.tank.gloom.tag.ModTags;
import java.util.function.Consumer;

public class MiscRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public MiscRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    protected void buildRecipes(Consumer<FinishedRecipe> writer) {

    }

}
