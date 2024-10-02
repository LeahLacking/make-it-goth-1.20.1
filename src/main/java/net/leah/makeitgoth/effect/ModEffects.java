package net.leah.makeitgoth.effect;

import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.effect.custom.BleedEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

import static net.leah.makeitgoth.MakeItGoth.id;

public class ModEffects {

    public final static RegistryEntry.Reference<StatusEffect> BLEED = registerModEffect("bleed",
            new BleedEffect(StatusEffectCategory.HARMFUL, 4718584)
    );

    public static RegistryEntry.Reference<StatusEffect> registerModEffect(String name, StatusEffect entry) {
        return Registry.registerReference(Registries.STATUS_EFFECT, id(name), entry);
    }

    public static void registerModEffects() {
        MakeItGoth.printDev("Registering ModEffects for" + MakeItGoth.MOD_ID);
    }
}
