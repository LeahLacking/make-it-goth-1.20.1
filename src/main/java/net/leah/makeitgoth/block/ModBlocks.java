package net.leah.makeitgoth.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.block.custom.EmptyBeerCup;
import net.leah.makeitgoth.block.custom.FogThingy;
import net.leah.makeitgoth.block.custom.SteelBars;
import net.leah.makeitgoth.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static net.leah.makeitgoth.MakeItGoth.id;

public class ModBlocks {



    public static final Block FOG_THINGY_BLOCK = registerBlock("fog_thingy_block",
            new FogThingy(true, 5, copySettings(Blocks.IRON_BLOCK)));


    public static final Block EMPTY_BEER_CUP = registerBlock("empty_beer_cup",
            new EmptyBeerCup(copySettings(Blocks.LANTERN).nonOpaque()));

    public static final Block PUMPKIN_RUM = registerBlock("pumpkin_rum",
            new EmptyBeerCup(copySettings(Blocks.LANTERN).nonOpaque()));


    //gothstone blocks
    public static final Block GOTHSTONE_BRICKS = registerBlock("gothstone_bricks",
            new Block(copySettings(Blocks.STONE_BRICKS)));

    public static final Block GOTHSTONE = registerBlock("gothstone",
            new Block(copySettings(Blocks.STONE_BRICKS)));

    // steel related blocks
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(copySettings(Blocks.IRON_BLOCK)));

    public static final Block STEEL_GRATE = registerBlock("steel_grate",
            new Block(copySettings(Blocks.IRON_BLOCK).nonOpaque()));

    public static final Block STEEL_BARS = registerBlock("steel_bars",
            new PaneBlock(copySettings(Blocks.IRON_BARS).nonOpaque()));

    // rotwood blocks
    public static final Block ROTWOOD_PLANKS = registerBlock("rotwood_planks",
            new Block(copySettings(Blocks.OAK_PLANKS)));

    public static final Block ROTWOOD_LOG = registerBlock("rotwood_log",
            new PillarBlock(copySettings(Blocks.OAK_LOG)));

    public static final Block ROTWOOD_WOOD = registerBlock("rotwood_wood",
            new PillarBlock(copySettings(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ROTWOOD_LOG = registerBlock("stripped_rotwood_log",
            new PillarBlock(copySettings(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_ROTWOOD_WOOD = registerBlock("stripped_rotwood_wood",
            new PillarBlock(copySettings(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block ROTWOOD_STAIRS = registerBlock("rotwood_stairs",
            new StairsBlock(ModBlocks.ROTWOOD_PLANKS.getDefaultState(), copySettings(Blocks.OAK_STAIRS)));

    public static final Block ROTWOOD_SLAB = registerBlock("rotwood_slab",
            new SlabBlock(copySettings(Blocks.OAK_SLAB)));

    public static final Block ROTWOOD_FENCE = registerBlock("rotwood_fence",
            new FenceBlock(copySettings(Blocks.OAK_FENCE)));

    public static final Block ROTWOOD_FENCE_GATE = registerBlock("rotwood_fence_gate",
            new FenceGateBlock(WoodType.OAK, copySettings(Blocks.OAK_FENCE_GATE)));

    public static final Block ROTWOOD_PRESSURE_PLATE = registerBlock("rotwood_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, copySettings(Blocks.OAK_PRESSURE_PLATE)));

    public static final Block ROTWOOD_BUTTON = registerBlock("rotwood_button",
            new ButtonBlock(BlockSetType.OAK, 10, copySettings(Blocks.OAK_BUTTON)));

    public static final Block GOTHSTONE_BRICK_STAIRS = registerBlock("gothstone_brick_stairs",
            new StairsBlock(ModBlocks.GOTHSTONE_BRICKS.getDefaultState(), copySettings(Blocks.STONE_STAIRS)));

    public static final Block GOTHSTONE_BRICK_SLAB = registerBlock("gothstone_brick_slab",
            new SlabBlock(copySettings(Blocks.STONE_SLAB)));

    public static final Block GOTHSTONE_BRICK_BUTTON = registerBlock("gothstone_brick_button",
            new ButtonBlock(BlockSetType.STONE, 10, copySettings(Blocks.STONE_BUTTON)));

    public static final Block GOTHSTONE_BRICK_WALL = registerBlock("gothstone_brick_wall",
            new WallBlock(copySettings(Blocks.STONE_BRICK_WALL)));

    public static final Block GOTHSTONE_STAIRS = registerBlock("gothstone_stairs",
            new StairsBlock(ModBlocks.GOTHSTONE_BRICKS.getDefaultState(),
                    copySettings(Blocks.STONE_STAIRS)));

    public static final Block GOTHSTONE_SLAB = registerBlock("gothstone_slab",
            new SlabBlock(copySettings(Blocks.STONE_SLAB)));

    public static final Block GOTHSTONE_BUTTON = registerBlock("gothstone_button",
            new ButtonBlock(BlockSetType.STONE, 10, copySettings(Blocks.STONE_BUTTON)));

    public static final Block GOTHSTONE_WALL = registerBlock("gothstone_wall",
            new WallBlock(copySettings(Blocks.STONE_BRICK_WALL)));
    public static final Block TEST_BARS = registerBlock("test_bars", new SteelBars(copySettings(STEEL_BARS)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, id(name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return ModItems.registerItem(name, new BlockItem(block, new Item.Settings()));
    }

    private static AbstractBlock.Settings copySettings(Block block) {
        return AbstractBlock.Settings.copy(block);
    }

    public static void registerModBlock() {
        MakeItGoth.LOGGER.info("Registering ModBlocks for " + MakeItGoth.MOD_ID);

        //this is how to do block stripping
        StrippableBlockRegistry.register(ROTWOOD_LOG, STRIPPED_ROTWOOD_LOG);
        StrippableBlockRegistry.register(ROTWOOD_WOOD, STRIPPED_ROTWOOD_WOOD);
    }
}




