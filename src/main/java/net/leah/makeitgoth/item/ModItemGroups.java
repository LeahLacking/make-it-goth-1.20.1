package net.leah.makeitgoth.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import static net.leah.makeitgoth.MakeItGoth.id;

public class ModItemGroups {
    public static final ItemGroup MAKEITGOTH_GROUP = Registry.register(Registries.ITEM_GROUP,
            id("makeitgoth"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.makeitgoth"))
                    .icon(() -> new ItemStack(ModBlocks.GOTHSTONE_BRICKS)).entries((displayContext, entries) -> {
                       // entries.addAll(ModItems.creativeTabItems.stream().map(Item::getDefaultStack).toList());
                       entries.add(ModItems.WHEEL_SAW);
                        entries.add(ModItems.RIFLE_HALBERD);
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.STEEL_GRATE);
                        entries.add(ModBlocks.TEST_BARS);
                        entries.add(ModBlocks.GOTHSTONE);
                        entries.add(ModBlocks.GOTHSTONE_SLAB);
                        entries.add(ModBlocks.GOTHSTONE_STAIRS);
                        entries.add(ModBlocks.GOTHSTONE_WALL);
                        entries.add(ModBlocks.GOTHSTONE_BRICKS);
                        entries.add(ModBlocks.GOTHSTONE_BRICK_STAIRS);
                        entries.add(ModBlocks.GOTHSTONE_BRICK_SLAB);
                        entries.add(ModBlocks.GOTHSTONE_BRICK_WALL);
                        entries.add(ModBlocks.ROTWOOD_BUTTON);
                        entries.add(ModBlocks.ROTWOOD_PLANKS);
                        entries.add(ModBlocks.ROTWOOD_LOG);
                        entries.add(ModBlocks.ROTWOOD_STAIRS);
                        entries.add(ModBlocks.ROTWOOD_SLAB);
                        entries.add(ModBlocks.ROTWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.ROTWOOD_FENCE);
                        entries.add(ModBlocks.ROTWOOD_FENCE_GATE);
                        entries.add(ModBlocks.EMPTY_BEER_CUP);
                        entries.add(ModBlocks.PUMPKIN_RUM);

                    }).build());

    public static void registerItemGroups() {
        MakeItGoth.LOGGER.info("Registering ItemGroups for "+MakeItGoth.MOD_ID);
    }
}
