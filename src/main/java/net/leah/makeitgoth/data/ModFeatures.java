package net.leah.makeitgoth.data;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

import static net.leah.makeitgoth.MakeItGoth.id;

public interface ModFeatures {

    RegistryKey<ConfiguredFeature<?, ?>> GOTHSTONE_ORE_CONFIGURED = createConfigured("gothstone_ore");
    RegistryKey<PlacedFeature> GOTHSTONE_ORE = createPlaced("gothstone_ore");

    static RegistryKey<ConfiguredFeature<?, ?>> createConfigured(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, id(name));
    }

    static RegistryKey<PlacedFeature> createPlaced(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, id(name));
    }
}
