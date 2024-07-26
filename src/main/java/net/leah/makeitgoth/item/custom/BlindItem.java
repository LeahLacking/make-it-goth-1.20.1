package net.leah.makeitgoth.item.custom;

import net.leah.makeitgoth.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BlindItem extends SwordItem {
    public BlindItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //blinding
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 150, 1));
        return super.postHit(stack, target, attacker);
    }
}
