package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.recipe.book.RecipeCategory.BUILDING_BLOCKS;


public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    public void generate(RecipeExporter exporter) {
        //  Apple is the result item in all recipes

        // Shaped Example
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, Items.APPLE, 8)
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .input('x', Items.STONE_BRICKS)
                // this is here, so you get the little advancement thingy when you pick up items
                .criterion(hasItem(Items.STONE_BRICKS), conditionsFromItem(Items.STONE_BRICKS))
                .offerTo(exporter);

        // Shapeless Example
        ShapelessRecipeJsonBuilder.create(BUILDING_BLOCKS, Items.APPLE, 8)
                .input(Items.DIAMOND)
                // this is here, so you get the little advancement thingy when you pick up items
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);


        // Smelting Example
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Items.ACACIA_BUTTON), BUILDING_BLOCKS, Items.APPLE, .1f, 200)
                .criterion(hasItem(Items.ACACIA_BUTTON), conditionsFromItem(Items.ACACIA_BUTTON))
                .offerTo(exporter, convertBetween(Items.APPLE, Items.ACACIA_BUTTON));

        // Blasting Example (as you see the faster time is set manually)
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Items.ACACIA_BUTTON), BUILDING_BLOCKS, Items.APPLE, .1f, 100)
                .criterion(hasItem(Items.ACACIA_BUTTON), conditionsFromItem(Items.ACACIA_BUTTON))
                .offerTo(exporter, convertBetween(Items.APPLE, Items.ACACIA_BUTTON));


    }
}
