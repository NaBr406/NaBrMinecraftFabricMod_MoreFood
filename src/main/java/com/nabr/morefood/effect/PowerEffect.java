package com.nabr.morefood.effect;

import net.minecraft.block.Portal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import javax.print.attribute.standard.Severity;

public class PowerEffect extends StatusEffect {
    public PowerEffect() {
        super(StatusEffectCategory.BENEFICIAL,
                0xFFFACD);
    }
    public boolean canApplyUpdateEffect(int type, int subtype){
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity , int amplifier) {
       if (entity instanceof ServerPlayerEntity player) {
           player.getAbilities().allowFlying = true;
           player.sendAbilitiesUpdate();
       }
        return true;
    }
}
