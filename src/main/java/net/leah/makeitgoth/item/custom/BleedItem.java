package net.leah.makeitgoth.item.custom;

import net.leah.makeitgoth.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class BleedItem extends AxeItem {
    public BleedItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //bleeding
        target.addStatusEffect(new StatusEffectInstance(ModEffects.BLEED,200,1));
        return super.postHit(stack, target, attacker);
    }
}
