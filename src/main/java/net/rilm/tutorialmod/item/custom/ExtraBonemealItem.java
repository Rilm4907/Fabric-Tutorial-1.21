package net.rilm.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ExtraBonemealItem extends Item {

    private static final List<Block> SUPER_BONEMEAL_LIST = List.of(
            Blocks.SUGAR_CANE
    );

    public ExtraBonemealItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        BlockPos pos = context.getBlockPos();
        BlockPos aboveBlockPos = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
        if (!world.isClient()) {
            for (int x = 0; x <= 2; x++) {
                if (SUPER_BONEMEAL_LIST.contains(clickedBlock)) {
                    if (aboveBlockPos.getY() == world.getTopY()) {
                        break;
                    } else if (world.getBlockState(aboveBlockPos).isAir()) {
                        Block aboveBlock = world.getBlockState(aboveBlockPos).getBlock();
                        world.setBlockState(aboveBlockPos, clickedBlock.getDefaultState());
                        context.getStack().decrement(1);
                        world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS);
                        ((ServerWorld) world).spawnParticles(
                                ParticleTypes.HAPPY_VILLAGER,
                                aboveBlockPos.getX() + 0.5, aboveBlockPos.getY() + 0.5, aboveBlockPos.getZ() + 0.5,
                                10,
                                0.5, 0.5, 0.5,
                                0
                        );
                        break;
                    } else {
                        aboveBlockPos = new BlockPos(aboveBlockPos.getX(), aboveBlockPos.getY() + 1, aboveBlockPos.getZ());
                    }
                }
              else {
                  break;
              }
            }
        }
        return  ActionResult.SUCCESS;
    }
}
