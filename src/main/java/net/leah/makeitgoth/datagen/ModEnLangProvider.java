package net.leah.makeitgoth.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.leah.makeitgoth.effect.ModEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static net.leah.makeitgoth.MakeItGoth.MOD_ID;

public class ModEnLangProvider extends FabricLanguageProvider {
    public ModEnLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder builder) {
        // This automagically gets all the mods items and makes translations for them
        Registries.ITEM.stream().filter(item -> Objects.equals(getId(item).getNamespace(), MOD_ID))
                .forEach(item -> builder.add(item.getTranslationKey(), getLang(getId(item))));

        builder.add("itemgroup.makeitgoth", "Make It Goth");
        builder.add(ModEffects.BLEED.value(), "Bleed");
    }

    public static Identifier getId(Item item) {
        return Registries.ITEM.getId(item);
    }

    public static String getLang(Identifier id) {
        return WordUtils.capitalize(id.getPath().replaceAll("_", " "));
    }
}
