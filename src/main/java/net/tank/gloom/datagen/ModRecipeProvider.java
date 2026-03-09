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
}
