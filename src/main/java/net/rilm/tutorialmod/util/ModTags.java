package net.rilm.tutorialmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.rilm.tutorialmod.TutorialMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> TRANSFORMABLE_BLOCKS = createTag("transformable_blocks");
        public static final TagKey<Block> SUPERBONEMEALABLE_BLOCKS = createTag("superbonemealable_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        }
    }
}
