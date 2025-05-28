package net.rilm.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3)
            .saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f).build();

    public static final FoodComponent WEIRD_RED_POTION = new FoodComponent.Builder()
            .alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 9), 1f).build();

    public static final FoodComponent WEIRD_RED_BLOB = new FoodComponent.Builder()
            .alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20), 0.25f).build();
}
