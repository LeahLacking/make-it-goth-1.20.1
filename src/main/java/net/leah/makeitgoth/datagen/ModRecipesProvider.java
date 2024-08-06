package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.leah.makeitgoth.block.ModBlocks;
import net.leah.makeitgoth.item.ModItems;
import net.minecraft.block.Blocks;
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
       //gothstone
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.GOTHSTONE, 8)
                .pattern("   ")
                .pattern(" ts")
                .pattern(" st")
                .input('s', Blocks.COBBLESTONE)
                .input('t', Blocks.TUFF)
                .criterion(hasItem(ModBlocks.GOTHSTONE), conditionsFromItem(ModBlocks.GOTHSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.GOTHSTONE_STAIRS, 6)
                .pattern("  x")
                .pattern(" xx")
                .pattern("xxx")
                .input('x', ModBlocks.GOTHSTONE)
                .criterion(hasItem(ModBlocks.GOTHSTONE), conditionsFromItem(ModBlocks.GOTHSTONE))
          .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.GOTHSTONE_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("xxx")
                .input('x', ModBlocks.GOTHSTONE)
                .criterion(hasItem(ModBlocks.GOTHSTONE), conditionsFromItem(ModBlocks.GOTHSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.GOTHSTONE_WALL, 6)
                .pattern("   ")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', ModBlocks.GOTHSTONE)
                .criterion(hasItem(ModBlocks.GOTHSTONE), conditionsFromItem(ModBlocks.GOTHSTONE))
                .offerTo(exporter);
        
        
        
        //Gothstone Bricks
        
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.GOTHSTONE_BRICKS, 4)
                .pattern("  ")
                .pattern("xx")
                .pattern("xx")
                .input('x', ModBlocks.GOTHSTONE)
                .criterion(hasItem(ModBlocks.GOTHSTONE), conditionsFromItem(ModBlocks.GOTHSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.GOTHSTONE_BRICK_STAIRS, 6)
                .pattern("  x")
                .pattern(" xx")
                .pattern("xxx")
                .input('x', ModBlocks.GOTHSTONE_BRICKS)
                .criterion(hasItem(ModBlocks.GOTHSTONE_BRICKS), conditionsFromItem(ModBlocks.GOTHSTONE_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.GOTHSTONE_BRICK_SLAB, 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("xxx")
                .input('x', ModBlocks.GOTHSTONE_BRICKS)
                .criterion(hasItem(ModBlocks.GOTHSTONE_BRICKS), conditionsFromItem(ModBlocks.GOTHSTONE_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.GOTHSTONE_BRICK_WALL, 6)
                .pattern("   ")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', ModBlocks.GOTHSTONE_BRICKS)
                .criterion(hasItem(ModBlocks.GOTHSTONE_BRICKS), conditionsFromItem(ModBlocks.GOTHSTONE_BRICKS))
                .offerTo(exporter);


        //Steel Shit
        
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK, 1)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', ModItems.STEEL_INGOT)
                // this is here, so you get the little advancement thingy when you pick up items
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.STEEL_GRATE, 6)
                .pattern("  ")
                .pattern("xx")
                .pattern("xx")
                .input('x', ModItems.STEEL_INGOT)
                // this is here, so you get the little advancement thingy when you pick up items
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.TEST_BARS, 8)
                .pattern("   ")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', ModItems.STEEL_INGOT)
                // this is here, so you get the little advancement thingy when you pick up items
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter);


       //Rotwood

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.ROTWOOD_LOG, 6)
                .pattern("xxx")
                .pattern("xrx")
                .pattern("xxx")
                .input('r', Items.OAK_LOG)
                .input('x', Items.ROTTEN_FLESH)
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter);

         ShapelessRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.ROTWOOD_PLANKS, 4)
                .input(ModBlocks.ROTWOOD_LOG)

                .criterion(hasItem(ModBlocks.ROTWOOD_LOG), conditionsFromItem(ModBlocks.ROTWOOD_LOG))
                 .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.ROTWOOD_STAIRS, 6)
                .pattern("  x")
                .pattern(" xx")
                .pattern("xxx")
                .input('x', ModBlocks.ROTWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.ROTWOOD_PLANKS), conditionsFromItem(ModBlocks.ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.ROTWOOD_SLAB, 6)
                .pattern("   ")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', ModBlocks.ROTWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.ROTWOOD_PLANKS), conditionsFromItem(ModBlocks.ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.ROTWOOD_FENCE, 6)
                .pattern("   ")
                .pattern("xsx")
                .pattern("xsx")
                .input('x', ModBlocks.ROTWOOD_PLANKS)
                .input('s', Items.STICK)
                .criterion(hasItem(ModBlocks.ROTWOOD_PLANKS), conditionsFromItem(ModBlocks.ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.ROTWOOD_FENCE_GATE, 3)
                .pattern("   ")
                .pattern("sxs")
                .pattern("sxs")
                .input('x', ModBlocks.ROTWOOD_PLANKS)
                .input('s', Items.STICK)
                .criterion(hasItem(ModBlocks.ROTWOOD_PLANKS), conditionsFromItem(ModBlocks.ROTWOOD_PLANKS))
               .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.ROTWOOD_PRESSURE_PLATE, 2)
                .pattern("   ")
                .pattern("   ")
                .pattern(" xx")
                .input('x', ModBlocks.ROTWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.ROTWOOD_PLANKS), conditionsFromItem(ModBlocks.ROTWOOD_PLANKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.ROTWOOD_BUTTON, 1)
                .pattern("   ")
                .pattern("   ")
                .pattern("  x")
                .input('x', ModBlocks.ROTWOOD_PLANKS)
                .criterion(hasItem(ModBlocks.ROTWOOD_PLANKS), conditionsFromItem(ModBlocks.ROTWOOD_PLANKS))
                .offerTo(exporter);


        //Weapons

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModItems.RUSTED_SCYTHE, 1)
                .pattern("scx")
                .pattern(" x ")
                .pattern("xzs")
                .input('x', Items.STICK)
                .input('c', Items.IRON_INGOT)
                .input('s', ModItems.STEEL_INGOT)
                .input('z', Items.ANCIENT_DEBRIS)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModItems.WHEEL_SAW, 1)
                .pattern("sxs")
                .pattern("xcx")
                .pattern("sxs")
                .input('x', Items.STICK)
                .input('c', Items.SPRUCE_PLANKS)
                .input('s', ModItems.STEEL_INGOT)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModItems.RIFLE_HALBERD, 1)
                .pattern(" cs")
                .pattern("fc ")
                .pattern("ssf")
                .input('c', Items.STICK)
                .input('s', ModItems.STEEL_INGOT)
                .input('f', Items.COAL_BLOCK)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
               .offerTo(exporter);


        //Brewing

        ShapedRecipeJsonBuilder.create(BUILDING_BLOCKS, ModBlocks.EMPTY_BEER_CUP, 4)
                .pattern("   ")
                .pattern("cxc")
                .pattern(" c ")
                .input('x', Items.SPRUCE_PLANKS)
                .input('c', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .offerTo(exporter);



        //Steel Ingots
        
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.STEEL_INGOT), BUILDING_BLOCKS, ModItems.STEEL_INGOT, .1f, 200)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, convertBetween(Items.IRON_INGOT, ModItems.STEEL_INGOT));

        // Blasting Example (as you see the faster time is set manually)
       /* CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(ModItems.STEEL_INGOT), BUILDING_BLOCKS, ModItems.STEEL_INGOT, .1f, 100)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, convertBetween(ModItems.STEEL_INGOT, Items.IRON_INGOT)); */

    }
}
