package net.rilm.tutorialmod.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rilm.tutorialmod.TutorialMod;
import net.rilm.tutorialmod.item.custom.ChiselItem;
import net.rilm.tutorialmod.item.custom.ExtraBonemealItem;
import net.rilm.tutorialmod.item.custom.WeirdRedPotionItem;

import java.util.List;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item WEIRD_RED_BLOB = registerItem("weird_red_blob", new Item(new Item.Settings().food(ModFoodComponents.WEIRD_RED_BLOB)));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item WEIRD_RED_FERTILIZER = registerItem("weird_red_fertilizer", new ExtraBonemealItem(new Item.Settings()));

    public static final Item WEIRD_RED_POTION = registerItem("weird_red_potion", new WeirdRedPotionItem(new Item.Settings().
            food(ModFoodComponents.WEIRD_RED_POTION)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mods Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);

        });
    }
}
