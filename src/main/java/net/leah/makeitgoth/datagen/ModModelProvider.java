package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leah.makeitgoth.block.ModBlocks;
import net.leah.makeitgoth.block.custom.SteelBars;
import net.leah.makeitgoth.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

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
        gen.registerLog(ModBlocks.STRIPPED_ROTWOOD_LOG).log(ModBlocks.STRIPPED_ROTWOOD_LOG).wood(ModBlocks.STRIPPED_ROTWOOD_WOOD);

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

        registerBars(gen, ModBlocks.TEST_BARS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) { //generates the item models
        //  itemModelGenerator.register(ModItems.ESTROGEN_WAFFLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
    }

    private void registerBars(BlockStateModelGenerator gen, Block block) {
        Identifier postEnds = ModelIds.getBlockSubModelId(block, "_post_ends");
        gen.blockStateCollector.accept(
                makeModels(block,
                        makeModels(block, MultipartBlockStateSupplier.create(block).with(BlockStateVariant.create().put(VariantSettings.MODEL, postEnds)), false),
                        true
                ));

        gen.registerItemModel(block);
    }

    private MultipartBlockStateSupplier makeModels(Block block, MultipartBlockStateSupplier state, Boolean spikes) {
        var str = spikes ? "_spikes" : "";
        Identifier post = ModelIds.getBlockSubModelId(block, "_post" + str);
        Identifier cap = ModelIds.getBlockSubModelId(block, "_cap" + str);
        Identifier capAlt = ModelIds.getBlockSubModelId(block, "_cap_alt" + str);
        Identifier side = ModelIds.getBlockSubModelId(block, "_side" + str);
        Identifier sideAlt = ModelIds.getBlockSubModelId(block, "_side_alt" + str);

        return state.with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, post))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, true).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, cap))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, false).set(Properties.EAST, true).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, cap).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, true).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, capAlt))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, capAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, side))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, side).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90));
    }
}

