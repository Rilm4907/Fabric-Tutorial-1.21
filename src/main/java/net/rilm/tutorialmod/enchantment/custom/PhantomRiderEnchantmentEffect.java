package net.rilm.tutorialmod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record PhantomRiderEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<PhantomRiderEnchantmentEffect> CODEC = MapCodec.unit(PhantomRiderEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (!(user instanceof PhantomEntity || user.getVehicle() instanceof PhantomEntity)) {
            PhantomEntity phantom = (PhantomEntity) EntityType.PHANTOM.create(world);
            if (phantom != null) {
                phantom.setPersistent();
                phantom.setPosition(user.getPos());
                phantom.setAngles(user.getYaw(), user.getPitch());
                phantom.setVelocity(user.getVelocity());
                world.spawnNewEntityAndPassengers(phantom);
                boolean riding = user.startRiding(phantom, true);
                if (!riding) {
                    phantom.discard();
                    user.discard();
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
