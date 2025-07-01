package net.rilm.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.rilm.tutorialmod.TutorialMod;
import net.rilm.tutorialmod.block.ModBlocks;
import net.rilm.tutorialmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
                ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_PINK_GARNET)
                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet_from_magic_block"));

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLAB, ModItems.PINK_GARNET);
        createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_BUTTON)
                .input(ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_PRESSURE_PLATE)
                .pattern("XX")
                .input('X', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_WALL, ModItems.PINK_GARNET);
        createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModItems.PINK_GARNET))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);



        List<ItemConvertible> WEIRD_RED_BLOCK_SMELTABLE = List.of(ModBlocks.GLITTERING_WEIRD_RED_BLOCK);
        offerSmelting(recipeExporter, WEIRD_RED_BLOCK_SMELTABLE, RecipeCategory.MISC, ModBlocks.WEIRD_RED_BLOCK, 0.3f, 200, "weird_red_block");
        offerBlasting(recipeExporter, WEIRD_RED_BLOCK_SMELTABLE, RecipeCategory.MISC, ModBlocks.WEIRD_RED_BLOCK, 0.3f, 200, "weird_red_block");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GLITTERING_WEIRD_RED_BLOCK)
                .pattern("WR")
                .pattern("RW")
                .input('W', ModItems.WEIRD_RED_BLOB)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(ModItems.WEIRD_RED_BLOB), conditionsFromItem(ModItems.WEIRD_RED_BLOB))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GLITTERING_WEIRD_RED_BLOCK, 4)
                .pattern("RW")
                .pattern("WR")
                .input('W', ModItems.WEIRD_RED_BLOB)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(ModItems.WEIRD_RED_BLOB), conditionsFromItem(ModItems.WEIRD_RED_BLOB))
                .offerTo(recipeExporter, "glittering_weird_red_block_reversed");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WEIRD_RED_BLOCK)
                .pattern("##")
                .pattern("##")
                .input('#', ModItems.WEIRD_RED_BLOB)
                .criterion(hasItem(ModItems.WEIRD_RED_BLOB), conditionsFromItem(ModItems.WEIRD_RED_BLOB))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WEIRD_RED_POTION)
                .pattern("RRR")
                .pattern("RWR")
                .pattern("RRR")
                .input('R', ModItems.WEIRD_RED_BLOB)
                .input('W', Items.WATER_BUCKET)
                .criterion(hasItem(ModItems.WEIRD_RED_BLOB), conditionsFromItem(ModItems.WEIRD_RED_BLOB))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WEIRD_RED_TRADER_BLOCK)
                .pattern("DRD")
                .pattern("RER")
                .pattern("DRD")
                .input('R', ModItems.WEIRD_RED_BLOB)
                .input('D', Items.DIAMOND)
                .input('E', Items.ENDER_PEARL)
                .criterion(hasItem(ModItems.WEIRD_RED_BLOB), conditionsFromItem(ModItems.WEIRD_RED_BLOB))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WEIRD_RED_FERTILIZER)
                .input(ModItems.WEIRD_RED_BLOB, 2)
                .input(Items.BONE_MEAL, 2)
                .criterion(hasItem(ModItems.WEIRD_RED_BLOB), conditionsFromItem(ModItems.WEIRD_RED_BLOB))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WEIRD_RED_BLOB, 4)
                .input(ModBlocks.WEIRD_RED_BLOCK)
                .criterion(hasItem(ModBlocks.WEIRD_RED_BLOCK), conditionsFromItem(ModBlocks.WEIRD_RED_BLOCK))
                .offerTo(recipeExporter);

    }
}
