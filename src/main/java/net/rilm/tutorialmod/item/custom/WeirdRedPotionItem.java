package net.rilm.tutorialmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class WeirdRedPotionItem extends Item {

    public WeirdRedPotionItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
