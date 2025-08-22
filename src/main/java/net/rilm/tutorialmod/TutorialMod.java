package net.rilm.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.world.GameMode;
import net.rilm.tutorialmod.block.ModBlocks;
import net.rilm.tutorialmod.component.ModDataComponentTypes;
import net.rilm.tutorialmod.effect.ModEffects;
import net.rilm.tutorialmod.enchantment.ModEnchantmentEffects;
import net.rilm.tutorialmod.enchantment.ModEnchantments;
import net.rilm.tutorialmod.item.ModItemGroups;
import net.rilm.tutorialmod.item.ModItems;
import net.rilm.tutorialmod.potion.ModPotions;
import net.rilm.tutorialmod.sound.ModSounds;
import net.rilm.tutorialmod.util.HammerUsageEvent;
import net.rilm.tutorialmod.util.ModTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	int count1 = 0;

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponents();
		ModSounds.registerSounds();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModEnchantmentEffects.registerEnchantmentEffects();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
			if (entity instanceof SheepEntity sheepEntity && !world.isClient) {
				if (playerEntity.getMainHandStack().getItem() == Items.END_ROD && sheepEntity.getColor() == DyeColor.GREEN) {
					playerEntity.sendMessage(Text.literal("BLUE IS BETTER"));
					if (playerEntity instanceof ServerPlayerEntity serverPlayer &&
							(serverPlayer.interactionManager.getGameMode() == GameMode.SURVIVAL || serverPlayer.interactionManager.getGameMode() == GameMode.ADVENTURE)) {
						playerEntity.getMainHandStack().decrement(1);
					}
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20, 255));
				}

				return ActionResult.PASS;
				
			}

			return ActionResult.PASS;
		});
		UseEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
			if (entity instanceof SheepEntity sheepEntity && !world.isClient) {
				if (playerEntity.getMainHandStack().getItem() == Items.GREEN_DYE && sheepEntity.getColor() != DyeColor.GREEN) {
					count1++;
					if (count1 == 2) {
						playerEntity.sendMessage(Text.literal("You're a bad person. You know that, right?"));
						count1 = 0;
					}
				}
			}

			return ActionResult.PASS;
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});
	}
}