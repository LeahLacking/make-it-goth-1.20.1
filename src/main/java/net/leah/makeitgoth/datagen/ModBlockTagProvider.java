package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.leah.makeitgoth.data.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.leah.makeitgoth.block.ModBlocks.*;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(
                        GOTHSTONE_BRICKS,
                        GOTHSTONE_BRICK_STAIRS,
                        GOTHSTONE_BRICK_SLAB,
                        GOTHSTONE_BRICK_WALL,
                        GOTHSTONE,
                        GOTHSTONE_STAIRS,
                        GOTHSTONE_SLAB,
                        GOTHSTONE_WALL
                );


        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);
        //all blocks mineable by axe


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
        //all blocks needing a iron tool

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
        //all blocks needing a diamond tool


        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(
                        GOTHSTONE_BRICKS,
                        GOTHSTONE_BRICK_STAIRS,
                        GOTHSTONE_BRICK_SLAB,
                        GOTHSTONE_BRICK_WALL,
                        GOTHSTONE,
                        GOTHSTONE_STAIRS,
                        GOTHSTONE_SLAB,
                        GOTHSTONE_WALL
                );


        addRotwoodTags();
        addGothstoneTags();
    }


    private void addRotwoodTags() {
        // (ender) time for wood fun
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ROTWOOD_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ROTWOOD_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ROTWOOD_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ROTWOOD_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ROTWOOD_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ROTWOOD_STAIRS);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ROTWOOD_PLANKS);

        //logs
        getOrCreateTagBuilder(ModTags.ROTWOOD_LOGS)
                .add(ROTWOOD_LOG, STRIPPED_ROTWOOD_LOG, ROTWOOD_WOOD, STRIPPED_ROTWOOD_WOOD);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .forceAddTag(ModTags.ROTWOOD_LOGS);

    }

    private void addGothstoneTags() {
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(GOTHSTONE_BRICK_WALL, GOTHSTONE_WALL);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(GOTHSTONE_BRICK_STAIRS, GOTHSTONE_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(GOTHSTONE_BRICK_SLAB, GOTHSTONE_SLAB);
    }
}

