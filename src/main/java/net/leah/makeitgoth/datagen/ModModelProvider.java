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
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) { //generates the Block models and textures

        BlockStateModelGenerator.BlockTexturePool rotwoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROTWOOD_PLANKS);

    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOTHSTONE_BRICKS);
        blockStateModelGenerator.registerLog(ModBlocks.ROTWOOD_LOG).log(ModBlocks.ROTWOOD_LOG).wood(ModBlocks.ROTWOOD_WOOD);

        rotwoodPool.stairs(ModBlocks.ROTWOOD_STAIRS);
        rotwoodPool.slab(ModBlocks.ROTWOOD_SLAB);
        rotwoodPool.fence(ModBlocks.ROTWOOD_FENCE);
        rotwoodPool.fenceGate(ModBlocks.ROTWOOD_FENCE_GATE);
        rotwoodPool.pressurePlate(ModBlocks.ROTWOOD_PRESSURE_PLATE);
        rotwoodPool.button(ModBlocks.ROTWOOD_BUTTON);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) { //generates the item models
      //  itemModelGenerator.register(ModItems.ESTROGEN_WAFFLE, Models.GENERATED);





    }
}

