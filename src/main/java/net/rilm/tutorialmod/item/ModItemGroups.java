package net.rilm.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rilm.tutorialmod.TutorialMod;
import net.rilm.tutorialmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);

                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.STARLIGHT_ASHES);

                    })
                    .build());

    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);

                    })
                    .build());

    public static final ItemGroup WEIRD_RED_THINGS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "weird_red_things"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.WEIRD_RED_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.weird_red_things"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.WEIRD_RED_BLOCK);
                        entries.add(ModBlocks.GLITTERING_WEIRD_RED_BLOCK);

                        entries.add(ModBlocks.WEIRD_RED_TRADER_BLOCK);

                        entries.add(ModItems.WEIRD_RED_BLOB);
                        entries.add(ModItems.WEIRD_RED_FERTILIZER);
                        entries.add(ModItems.WEIRD_RED_POTION);

                    })
                    .build());

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
