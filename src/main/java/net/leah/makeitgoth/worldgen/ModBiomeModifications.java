package net.leah.makeitgoth.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.world.gen.GenerationStep;

import static net.leah.makeitgoth.MakeItGoth.id;
import static net.leah.makeitgoth.data.ModFeatures.GOTHSTONE_ORE;

public interface ModBiomeModifications {
    static void init() {
        BiomeModifications.create(id("add_gothstone_ore")).add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.foundInOverworld(),
                (context) -> context.getGenerationSettings().addFeature(GenerationStep.Feature.UNDERGROUND_ORES, GOTHSTONE_ORE)
        );
    }
}
