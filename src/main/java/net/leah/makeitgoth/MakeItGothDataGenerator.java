package net.leah.makeitgoth;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.leah.makeitgoth.datagen.ModBlockTagProvider;
import net.leah.makeitgoth.datagen.ModItemTagProvider;
import net.leah.makeitgoth.datagen.ModModelProvider;

import java.util.concurrent.atomic.AtomicReference;

public class MakeItGothDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);

        // this looks complicated, but is here for laziness’s sake
        AtomicReference<ModBlockTagProvider> blockTags = new AtomicReference<>();
        pack.addProvider(((output, reg) -> {
            blockTags.set(new ModBlockTagProvider(output, reg));
            return blockTags.get();
        }));
        pack.addProvider(((output, reg) -> new ModItemTagProvider(output, reg, blockTags.get())));

    }
}
