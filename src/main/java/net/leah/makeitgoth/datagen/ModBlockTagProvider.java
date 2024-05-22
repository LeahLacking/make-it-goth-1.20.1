package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE);
                //all blocks mineable by a pickaxe




        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);
        //all blocks mineable by axe




        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
        //all blocks needing a iron tool

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
        //all blocks needing a diamond tool


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);
                //all blocks needing a stone tool





        getOrCreateTagBuilder(BlockTags.FENCES);
        //Tag for fences


        getOrCreateTagBuilder(BlockTags.FENCE_GATES);
        //Tag for fence gates

        getOrCreateTagBuilder(BlockTags.WALLS);
                // Tag for walls



    }
}

