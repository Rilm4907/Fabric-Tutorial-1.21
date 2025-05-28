package net.rilm.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.rilm.tutorialmod.TutorialMod;
import net.rilm.tutorialmod.block.custom.MagicBlock;
import net.rilm.tutorialmod.block.custom.TraderBlock;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block WEIRD_RED_BLOCK = registerBlock("weird_red_block",
            new Block(AbstractBlock.Settings.create().strength(0.5f)
                    .sounds(BlockSoundGroup.MUD)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block GLITTERING_WEIRD_RED_BLOCK = registerBlock("glittering_weird_red_block",
            new Block(AbstractBlock.Settings.create().strength(0.6f)
                    .sounds(BlockSoundGroup.PACKED_MUD)));

    public static final Block WEIRD_RED_TRADER_BLOCK = registerBlock("weird_red_trader_block",
            new TraderBlock(AbstractBlock.Settings.create().strength(5f)
                    .sounds(BlockSoundGroup.BASALT)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mods Blocks fo " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);

        });
    }

}
