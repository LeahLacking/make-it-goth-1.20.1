package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.leah.makeitgoth.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GOTHSTONE_BRICKS)
                .add(ModBlocks.GOTHSTONE_BRICK_STAIRS)
                .add(ModBlocks.GOTHSTONE_BRICK_SLAB)
                .add(ModBlocks.GOTHSTONE_BRICK_WALL)
                .add(ModBlocks.GOTHSTONE)
                .add(ModBlocks.GOTHSTONE_STAIRS)
                .add(ModBlocks.GOTHSTONE_SLAB)
                .add(ModBlocks.GOTHSTONE_WALL);




        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);
        //all blocks mineable by axe




        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
        //all blocks needing a iron tool

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
        //all blocks needing a diamond tool


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.GOTHSTONE_BRICKS)
                .add(ModBlocks.GOTHSTONE_BRICK_STAIRS)
                .add(ModBlocks.GOTHSTONE_BRICK_SLAB)
                .add(ModBlocks.GOTHSTONE_BRICK_WALL)
                .add(ModBlocks.GOTHSTONE)
                .add(ModBlocks.GOTHSTONE_STAIRS)
                .add(ModBlocks.GOTHSTONE_SLAB)
                .add(ModBlocks.GOTHSTONE_WALL);




        getOrCreateTagBuilder(BlockTags.FENCES)
         .add(ModBlocks.ROTWOOD_FENCE);


        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
        .add(ModBlocks.ROTWOOD_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.GOTHSTONE_BRICK_WALL)
                .add(ModBlocks.GOTHSTONE_WALL);



    }
}

