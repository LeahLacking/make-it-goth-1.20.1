package net.leah.makeitgoth.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;


public class ChipItem extends SwordItem {
        public ChipItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
            super(toolMaterial, attackDamage, attackSpeed, settings);
        }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //chip Damage(did not add a damage type just ignores armor)
        float Damage;
        Damage=(target.getHealth()-(((float) target.getArmor() /1f)*1f/*percentage of armor to ignore*/)*this.getAttackDamage());
        target.setHealth(target.getHealth()-Damage);/*There is probably a better way of doing this but I'm lazy*/
        return super.postHit(stack, target, attacker);
    }
}



