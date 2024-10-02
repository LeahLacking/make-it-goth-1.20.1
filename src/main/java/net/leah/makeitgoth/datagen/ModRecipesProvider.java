package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.leah.makeitgoth.block.ModBlocks.*;
import static net.leah.makeitgoth.item.ModItems.*;
import static net.minecraft.recipe.book.RecipeCategory.BUILDING_BLOCKS;


public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    public void generate(RecipeExporter exporter) {
        gothstoneRecipes(exporter);
        steelRecipes(exporter);
        rotwoodRecipes(exporter);

        //Weapons
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, RUSTED_SCYTHE, 1)
                .pattern("scx")
                .pattern(" x ")
                .pattern("xzs")
                .input('x', Items.STICK)
                .input('c', Items.IRON_INGOT)
                .input('s', STEEL_INGOT)
                .input('z', Items.ANCIENT_DEBRIS)
                .criterion(hasItem(STEEL_INGOT), conditionsFromItem(STEEL_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, WHEEL_SAW, 1)
                .pattern("sxs")
                .pattern("xcx")
                .pattern("sxs")
                .input('x', Items.STICK)
                .input('c', Items.SPRUCE_PLANKS)
                .input('s', STEEL_INGOT)
                .criterion(hasItem(STEEL_INGOT), conditionsFromItem(STEEL_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, RIFLE_HALBERD, 1)
                .pattern(" cs")
                .pattern("fc ")
                .pattern("ssf")
                .input('c', Items.STICK)
                .input('s', STEEL_INGOT)
                .input('f', Items.COAL_BLOCK)
                .criterion(hasItem(STEEL_INGOT), conditionsFromItem(STEEL_INGOT))
                .offerTo(exporter);

        //Brewing
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, EMPTY_BEER_CUP, 4)
                .pattern("cxc")
                .pattern(" c ")
                .input('x', Items.SPRUCE_PLANKS)
                .input('c', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .offerTo(exporter);
    }

    void gothstoneRecipes(RecipeExporter exporter) {
        // Gothstone
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, GOTHSTONE, 4)
                .pattern("td")
                .pattern("dt")
                .input('d', Blocks.COBBLED_DEEPSLATE)
                .input('t', Blocks.TUFF)
                .criterion(hasItem(GOTHSTONE), conditionsFromItem(GOTHSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, GOTHSTONE_STAIRS, 4)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .input('x', GOTHSTONE)
                .criterion(hasItem(GOTHSTONE), conditionsFromItem(GOTHSTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_STAIRS, GOTHSTONE);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, GOTHSTONE_SLAB, 6)
                .pattern("xxx")
                .input('x', GOTHSTONE)
                .criterion(hasItem(GOTHSTONE), conditionsFromItem(GOTHSTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_SLAB, GOTHSTONE, 2);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, GOTHSTONE_WALL, 6)
                .pattern("xxx")
                .pattern("xxx")
                .input('x', GOTHSTONE)
                .criterion(hasItem(GOTHSTONE), conditionsFromItem(GOTHSTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_WALL, GOTHSTONE);


        //Gothstone Bricks

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, GOTHSTONE_BRICKS, 4)
                .pattern("xx")
                .pattern("xx")
                .input('x', GOTHSTONE)
                .criterion(hasItem(GOTHSTONE), conditionsFromItem(GOTHSTONE))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_BRICKS, GOTHSTONE);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, GOTHSTONE_BRICK_STAIRS, 6)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .input('x', GOTHSTONE_BRICKS)
                .criterion(hasItem(GOTHSTONE_BRICKS), conditionsFromItem(GOTHSTONE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_BRICK_STAIRS, GOTHSTONE);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_BRICK_STAIRS, GOTHSTONE_BRICKS);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, GOTHSTONE_BRICK_SLAB, 6)
                .pattern("xxx")
                .input('x', GOTHSTONE_BRICKS)
                .criterion(hasItem(GOTHSTONE_BRICKS), conditionsFromItem(GOTHSTONE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_BRICK_SLAB, GOTHSTONE, 2);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_BRICK_SLAB, GOTHSTONE_BRICKS, 2);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, GOTHSTONE_BRICK_WALL, 6)
                .pattern("xxx")
                .pattern("xxx")
                .input('x', GOTHSTONE_BRICKS)
                .criterion(hasItem(GOTHSTONE_BRICKS), conditionsFromItem(GOTHSTONE_BRICKS))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_BRICK_WALL, GOTHSTONE);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, GOTHSTONE_BRICK_WALL, GOTHSTONE_BRICKS);
    }

    void steelRecipes(RecipeExporter exporter) {
        // Steel Ingots
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Items.IRON_INGOT), BUILDING_BLOCKS, STEEL_INGOT, .1f, 200)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, getSmeltingItemPath(STEEL_INGOT));
        // Blasting Example (as you see the faster time is set manually)
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Items.IRON_INGOT), BUILDING_BLOCKS, STEEL_INGOT, .1f, 100)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, getBlastingItemPath(STEEL_INGOT));

        // Steel Blocks
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, STEEL_GRATE, 4)
                .pattern(" x ")
                .pattern("x x")
                .pattern(" x ")
                .input('x', STEEL_BLOCK)
                .criterion(hasItem(STEEL_INGOT), conditionsFromItem(STEEL_INGOT))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, BUILDING_BLOCKS, STEEL_GRATE, STEEL_INGOT, 4);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, STEEL_BARS, 16)
                .pattern("xxx")
                .pattern("xxx")
                .input('x', STEEL_INGOT)
                .criterion(hasItem(STEEL_INGOT), conditionsFromItem(STEEL_INGOT))
                .offerTo(exporter);
    }

    private void rotwoodRecipes(RecipeExporter exporter) {
        //Rotwood
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ROTWOOD_LOG, 6)
                .pattern("xxx")
                .pattern("xrx")
                .pattern("xxx")
                .input('r', Items.OAK_LOG)
                .input('x', Items.ROTTEN_FLESH)
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(BUILDING_BLOCKS, ROTWOOD_PLANKS, 4)
                .input(ROTWOOD_LOG)
                .criterion(hasItem(ROTWOOD_LOG), conditionsFromItem(ROTWOOD_LOG))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ROTWOOD_STAIRS, 4)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .input('x', ROTWOOD_PLANKS)
                .criterion(hasItem(ROTWOOD_PLANKS), conditionsFromItem(ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ROTWOOD_SLAB, 6)
                .pattern("xxx")
                .input('x', ROTWOOD_PLANKS)
                .criterion(hasItem(ROTWOOD_PLANKS), conditionsFromItem(ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ROTWOOD_FENCE, 3)
                .pattern("xsx")
                .pattern("xsx")
                .input('x', ROTWOOD_PLANKS)
                .input('s', Items.STICK)
                .criterion(hasItem(ROTWOOD_PLANKS), conditionsFromItem(ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ROTWOOD_FENCE_GATE)
                .pattern("sxs")
                .pattern("sxs")
                .input('x', ROTWOOD_PLANKS)
                .input('s', Items.STICK)
                .criterion(hasItem(ROTWOOD_PLANKS), conditionsFromItem(ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ROTWOOD_PRESSURE_PLATE)
                .pattern("xx")
                .input('x', ROTWOOD_PLANKS)
                .criterion(hasItem(ROTWOOD_PLANKS), conditionsFromItem(ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(BUILDING_BLOCKS, ROTWOOD_BUTTON)
                .input(ROTWOOD_PLANKS)
                .criterion(hasItem(ROTWOOD_PLANKS), conditionsFromItem(ROTWOOD_PLANKS))
                .offerTo(exporter);
    }

}
