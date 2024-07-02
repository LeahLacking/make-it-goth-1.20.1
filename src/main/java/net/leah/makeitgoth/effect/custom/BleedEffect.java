package net.leah.makeitgoth.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BleedEffect extends StatusEffect {
    public BleedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        entity.damage(entity.getDamageSources().magic(), amplifier);
        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 30 == 0;
    }
}
