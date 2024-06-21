package net.leah.makeitgoth.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup makeitgoth_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MakeItGoth.MOD_ID, "makeitgoth"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.makeitgoth"))
                    .icon(() -> new ItemStack(ModBlocks.GOTHSTONE_BRICKS)).entries((displayContext, entries) -> {

                        entries.add(ModItems.WHEEL_SAW);
                        entries.add(ModItems.RIFLE_HALBERD);
                        entries.add(ModItems.STEEL_INGOTS);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.STEEL_GRATE);
                        entries.add(ModBlocks.STEEL_BARS);
                        entries.add(ModBlocks.GOTHSTONE_BRICKS);
                        entries.add(ModBlocks.GOTHSTONE_STAIRS);
                        entries.add(ModBlocks.GOTHSTONE_SLAB);
                        entries.add(ModBlocks.GOTHSTONE_WALL);
                        entries.add(ModBlocks.ROTWOOD_BUTTON);
                        entries.add(ModBlocks.ROTWOOD_LOG);
                        entries.add(ModBlocks.ROTWOOD_STAIRS);
                        entries.add(ModBlocks.ROTWOOD_SLAB);
                        entries.add(ModBlocks.ROTWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.ROTWOOD_FENCE);
                        entries.add(ModBlocks.ROTWOOD_FENCE_GATE);

                       
                    }).build());

    public static void registerItemGroups() {
        MakeItGoth.LOGGER.info("Registering ItemGroups for "+MakeItGoth.MOD_ID);
    }
}
