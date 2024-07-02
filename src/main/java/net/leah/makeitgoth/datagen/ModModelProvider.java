package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leah.makeitgoth.item.ModItems;
import net.leah.makeitgoth.block.ModBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) { //generates the Block models and textures



        BlockStateModelGenerator.BlockTexturePool rotwoodPool = gen.registerCubeAllModelTexturePool(ModBlocks.ROTWOOD_PLANKS);
        BlockStateModelGenerator.BlockTexturePool gothstoneBrickPool = gen.registerCubeAllModelTexturePool(ModBlocks.GOTHSTONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool gothstonePool = gen.registerCubeAllModelTexturePool(ModBlocks.GOTHSTONE);

        gen.registerLog(ModBlocks.ROTWOOD_LOG).log(ModBlocks.ROTWOOD_LOG).wood(ModBlocks.ROTWOOD_WOOD);

        //rotwood datagen textures

        rotwoodPool.stairs(ModBlocks.ROTWOOD_STAIRS);
        rotwoodPool.slab(ModBlocks.ROTWOOD_SLAB);
        rotwoodPool.fence(ModBlocks.ROTWOOD_FENCE);
        rotwoodPool.fenceGate(ModBlocks.ROTWOOD_FENCE_GATE);
        rotwoodPool.pressurePlate(ModBlocks.ROTWOOD_PRESSURE_PLATE);
        rotwoodPool.button(ModBlocks.ROTWOOD_BUTTON);

        //gothstone datagen textures
        gothstoneBrickPool.stairs(ModBlocks.GOTHSTONE_BRICK_STAIRS);
        gothstoneBrickPool.slab(ModBlocks.GOTHSTONE_BRICK_SLAB);
        gothstoneBrickPool.wall(ModBlocks.GOTHSTONE_BRICK_WALL);
        gothstoneBrickPool.button(ModBlocks.GOTHSTONE_BRICK_BUTTON);

        gothstonePool.stairs(ModBlocks.GOTHSTONE_STAIRS);
        gothstonePool.slab(ModBlocks.GOTHSTONE_SLAB);
        gothstonePool.wall(ModBlocks.GOTHSTONE_WALL);
        gothstonePool.button(ModBlocks.GOTHSTONE_BUTTON);

        gen.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        gen.registerSimpleCubeAll(ModBlocks.STEEL_GRATE);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) { //generates the item models
        //  itemModelGenerator.register(ModItems.ESTROGEN_WAFFLE, Models.GENERATED);
          itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
    }
}

