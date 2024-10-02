package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.leah.makeitgoth.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTablesProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
       //gothstone
        addDrop(ModBlocks.GOTHSTONE);
        addDrop(ModBlocks.GOTHSTONE_STAIRS);
        addDrop(ModBlocks.GOTHSTONE_SLAB);
        addDrop(ModBlocks.GOTHSTONE_WALL);
        //gothstone bricks
        addDrop(ModBlocks.GOTHSTONE_BRICKS);
        addDrop(ModBlocks.GOTHSTONE_BRICK_SLAB);
        addDrop(ModBlocks.GOTHSTONE_BRICK_STAIRS);
        addDrop(ModBlocks.GOTHSTONE_BRICK_BUTTON);
        addDrop(ModBlocks.GOTHSTONE_BRICK_WALL);
        //steel
        addDrop(ModBlocks.STEEL_BLOCK);
        addDrop(ModBlocks.STEEL_GRATE);
        addDrop(ModBlocks.STEEL_BARS);
        //rotwood
        addDrop(ModBlocks.ROTWOOD_LOG);
        addDrop(ModBlocks.ROTWOOD_PLANKS);
        addDrop(ModBlocks.ROTWOOD_STAIRS);
        addDrop(ModBlocks.ROTWOOD_SLAB);
        addDrop(ModBlocks.ROTWOOD_PRESSURE_PLATE);
        addDrop(ModBlocks.ROTWOOD_BUTTON);
        addDrop(ModBlocks.ROTWOOD_FENCE);
        addDrop(ModBlocks.ROTWOOD_FENCE_GATE);
        //brews
        addDrop(ModBlocks.EMPTY_BEER_CUP);










    }
}
