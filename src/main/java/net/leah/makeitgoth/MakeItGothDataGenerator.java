package net.leah.makeitgoth;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.leah.makeitgoth.datagen.*;
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

        // this looks complicated, but is here for laziness’s sake
        // I like I have no idea how to make this look better
        AtomicReference<ModBlockTagProvider> blockTags = new AtomicReference<>();
        pack.addProvider(((output, reg) -> {
            blockTags.set(new ModBlockTagProvider(output, reg));
            return blockTags.get();
        }));
        pack.addProvider(((output, reg) -> new ModItemTagProvider(output, reg, blockTags.get())));

    }

    @Override
    public void buildRegistry(RegistryBuilder builder) {
        builder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModFeatureCreator::bootstrapConfigured);
        builder.addRegistry(RegistryKeys.PLACED_FEATURE, ModFeatureCreator::bootstrapPlaced);
    }
}
