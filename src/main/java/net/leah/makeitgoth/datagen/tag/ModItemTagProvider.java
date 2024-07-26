package net.leah.makeitgoth.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.leah.makeitgoth.data.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, FabricTagProvider.BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
//        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR);
        //Tag for trimmable armor

//        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS);
        //Tag so that creepers drop siad music disc

        copyBlockTags();
    }

    private void copyBlockTags() {
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
//        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
//        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);

        copy(ModTags.ROTWOOD_LOGS, ModTags.ROTWOOD_LOGS_ITEM);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.FENCES, ItemTags.FENCES);
        copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
    }

}
