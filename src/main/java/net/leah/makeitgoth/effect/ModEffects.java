package net.leah.makeitgoth.effect;

import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.effect.custom.BleedEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModEffects extends StatusEffects {

    public final static StatusEffect BLEED = registerModEffect("bleed",
            (new BleedEffect(StatusEffectCategory.HARMFUL, 4718584)));


    public static StatusEffect registerModEffect(String name, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(MakeItGoth.MOD_ID, name), entry);


    }

    public static void registerModEffects() {
        MakeItGoth.LOGGER.info("Registering ModEffects for" + MakeItGoth.MOD_ID);
    }
}
