package net.leah.makeitgoth.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;


public class ChipItem extends SwordItem {
    public ChipItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //chip Damage(did not add a damage type just ignores armor)
        float Damage = (target.getHealth() - (((float) target.getArmor() / 2f) * 25f/*percentage of armor to ignore*/) * stack.getDamage());
        target.setHealth(target.getHealth() - Damage);/*There is probably a better way of doing this but I'm lazy*/
        // yes there is a better way if doing this, a lot better way called target.damage(..)
        // just add a damage type
        // if you need a reference ThShipPost mod adds a custom damage type
        return super.postHit(stack, target, attacker);
    }
}
