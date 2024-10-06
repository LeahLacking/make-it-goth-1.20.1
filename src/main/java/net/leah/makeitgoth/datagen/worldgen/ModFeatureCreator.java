package net.leah.makeitgoth.datagen.worldgen;

import net.leah.makeitgoth.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

import static net.leah.makeitgoth.data.ModFeatures.GOTHSTONE_ORE;
import static net.leah.makeitgoth.data.ModFeatures.GOTHSTONE_ORE_CONFIGURED;

public class ModFeatureCreator {
    public static void bootstrapConfigured(Registerable<ConfiguredFeature<?, ?>> context) {
        context.register(GOTHSTONE_ORE_CONFIGURED, new ConfiguredFeature<>(
                Feature.ORE,
                new OreFeatureConfig(
                        new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD),
                        ModBlocks.GOTHSTONE.getDefaultState(),
                        64
                )));
    }

    public static void bootstrapPlaced(Registerable<PlacedFeature> context) {
        var configuredReg = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        var gothstone = configuredReg.getOrThrow(GOTHSTONE_ORE_CONFIGURED);
        context.register(GOTHSTONE_ORE, new PlacedFeature(
                gothstone,
                List.of(
                        CountPlacementModifier.of(2),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(0)),
                        BiomePlacementModifier.of()
                )));
    }
}
