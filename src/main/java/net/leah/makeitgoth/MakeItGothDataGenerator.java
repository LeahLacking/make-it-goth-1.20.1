package net.leah.makeitgoth;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.leah.makeitgoth.datagen.*;
import net.leah.makeitgoth.datagen.tag.ModBlockTagProvider;
import net.leah.makeitgoth.datagen.tag.ModItemTagProvider;
import net.leah.makeitgoth.datagen.worldgen.ModDynamicRegProvider;
import net.leah.makeitgoth.datagen.worldgen.ModFeatureCreator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

import java.util.concurrent.atomic.AtomicReference;

public class MakeItGothDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModEnLangProvider::new);
        pack.addProvider(ModDynamicRegProvider::new);
        pack.addProvider(ModRecipesProvider::new);
        pack.addProvider(ModBlockLootTablesProvider::new);

        ModBlockTagProvider blockTags=  pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(((output, reg) -> new ModItemTagProvider(output, reg, blockTags)));

    }

    @Override
    public void buildRegistry(RegistryBuilder builder) {
        builder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModFeatureCreator::bootstrapConfigured);
        builder.addRegistry(RegistryKeys.PLACED_FEATURE, ModFeatureCreator::bootstrapPlaced);
    }
}
