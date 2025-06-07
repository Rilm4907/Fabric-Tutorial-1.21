package net.rilm.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraderBlock extends Block {

    public TraderBlock(Settings settings) {
        super(settings);
    }

    private static final int value = 2;

    private static final List<Item> ITEM_LIST = List.of(
            Items.DIRT,
            Items.COBBLESTONE,
            Items.COAL,
            Items.COPPER_INGOT,
            Items.IRON_INGOT,
            Items.GOLD_INGOT,
            Items.EMERALD,
            Items.DIAMOND
    );

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity Itemy) {
            Item DanyItem = Itemy.getStack().getItem();
            if (ITEM_LIST.contains(DanyItem)) {
                if (DanyItem != ITEM_LIST.getLast() && Itemy.getStack().getCount() >= value) {
                    ItemStack originalStack = Itemy.getStack();
                    int originalCount = originalStack.getCount();
                    int premenenych = (int)(originalCount / value);
                    int nepremenenych = originalCount % value;
                    ItemStack odtrzenyStack = originalStack.split(originalCount - nepremenenych);
                    Itemy.setStack(originalStack);
                    BlockPos pos2 = Itemy.getBlockPos();
                    ItemEntity odtrzeneItemy = new ItemEntity(world, pos2.getX(), pos2.getY(), pos2.getZ(),
                            new ItemStack(ITEM_LIST.get(ITEM_LIST.indexOf(DanyItem)+1), premenenych));
                    world.spawnEntity(odtrzeneItemy);
                }

            }

        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if (Screen.hasAltDown()) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.trader_block.alt_down.1"));
            tooltip.add(Text.translatable("tooltip.tutorialmod.trader_block.alt_down.2"));
        } else {
            tooltip.add(Text.translatable("tooltip.tutorialmod.trader_block"));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}
