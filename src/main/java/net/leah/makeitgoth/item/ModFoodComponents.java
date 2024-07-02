package net.leah.makeitgoth.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    // how to food component
    public static final FoodComponent STEEL_INGOT = (new FoodComponent.Builder()) // You need to surround this with '()' because java is stupid
            .nutrition(3) // Nutrition is the amount of hunger restored
            .saturationModifier(0.25f) // Saturation modifier gives saturation to player, just copy vanilla for this one tbh. (I looked at the mc code and it's complicated)
            .statusEffect( // Adds a status effect to the player that easts it
                    new StatusEffectInstance( // The status effect instance. This is the thing you can see in ur inventory since you can have more than one of the same potion effect active at a time, minecraft has like a list of instances stored per entity
                            // also it hold how long the effect lasts & its amplifier
                            StatusEffects.INSTANT_HEALTH, // The effect type
                            300, // The duration of the effect
                            0 // The amplifier of the effect, if not specified, it is 0 which in game is 1 (yes i know it's silly)
                    ),
                    1 //  The change of getting this effect 1 is every time, 0 is never, 0.5 is half the time, etc
            )
            // you can have as many status effects as you want u just need to add more `.statusEffect(...)`
//            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600), 0.3F) // uncomment this to add hunger for  0.3 chance
            .build(); // This finalizes the component and has to be last

    // if you ever want to steel from vanilla, The food components are stored in
    // net.minecraft.component.type.FoodComponents || FoodComponents.class
}
