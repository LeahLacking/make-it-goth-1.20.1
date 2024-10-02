package net.leah.makeitgoth.datagen;

import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.leah.makeitgoth.block.ModBlocks;
import net.leah.makeitgoth.block.custom.SteelBars;
import net.leah.makeitgoth.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static net.minecraft.data.client.BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) { //generates the Block models and textures

        gen.excludeFromSimpleItemModelGeneration(ModBlocks.PUMPKIN_RUM);


        registerFacingBlock(gen, ModBlocks.EMPTY_BEER_CUP);
        registerFacingBlock(gen, ModBlocks.PUMPKIN_RUM);

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


        registerDoubleBars(gen, ModBlocks.STEEL_BARS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) { //generates the item models
        //  itemModelGenerator.register(ModItems.ESTROGEN_WAFFLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
    }

    static void registerFacingBlock(BlockStateModelGenerator gen, Block block) {
        gen.blockStateCollector.accept(VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block))).coordinate(createNorthDefaultHorizontalRotationStates()));
    }

    @SuppressWarnings("SameParameterValue")
    private void registerDoubleBars(BlockStateModelGenerator gen, Block block) {
        gen.blockStateCollector.accept(
                makeModels(gen.modelCollector, block,
                        makeModels(gen.modelCollector, block, MultipartBlockStateSupplier.create(block), false),
                        true
                ));

        gen.registerItemModel(block, "_spikes");
    }

    private MultipartBlockStateSupplier makeModels(BiConsumer<Identifier, Supplier<JsonElement>> modelCollector, Block block, MultipartBlockStateSupplier state, Boolean spikes) {
        var str = spikes ? "_spikes" : "";
        var textureId = model(block).withSuffixedPath(str);
        var texture = TextureMap.texture(textureId)
                .put(TextureKey.PARTICLE, textureId)
                .put(BARS, textureId)
                .put(TextureKey.EDGE, model(block));
        Identifier postEnds = BARS_POST_ENDS.upload(block, "_post_ends" + str, texture, modelCollector);
        Identifier post = BARS_POST.upload(block, "_post" + str, texture, modelCollector);
        Identifier cap = BARS_CAP.upload(block, "_cap" + str, texture, modelCollector);
        Identifier capAlt = BARS_CAP_ALT.upload(block, "_cap_alt" + str, texture, modelCollector);
        Identifier side = BARS_SIDE.upload(block, "_side" + str, texture, modelCollector);
        Identifier sideAlt = BARS_SIDE_ALT.upload(block, "_side_alt" + str, texture, modelCollector);

        return state.with(When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, post))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, true).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, cap))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, false).set(Properties.EAST, true).set(Properties.SOUTH, false).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, cap).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, true).set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, capAlt))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, capAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, side))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, side).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt))
                .with(When.create().set(SteelBars.SPIKES, spikes).set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, sideAlt).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(BlockStateVariant.create().put(VariantSettings.MODEL, postEnds));
    }

    static TextureKey BARS = TextureKey.of("bars");
    static Model BARS_POST_ENDS = barsModel("iron_bars_post_ends");
    static Model BARS_POST = barsModel("iron_bars_post");
    static Model BARS_CAP = barsModel("iron_bars_cap");
    static Model BARS_CAP_ALT = barsModel("iron_bars_cap_alt");
    static Model BARS_SIDE = barsModel("iron_bars_side");
    static Model BARS_SIDE_ALT = barsModel("iron_bars_side_alt");

    static Identifier model(Block block) {
        return ModelIds.getBlockModelId(block);
    }

    static Model barsModel(String parent) {
        return new Model(Optional.of(Identifier.ofVanilla("block/" + parent)), Optional.empty(), TextureKey.PARTICLE, BARS, TextureKey.EDGE);
    }
}


