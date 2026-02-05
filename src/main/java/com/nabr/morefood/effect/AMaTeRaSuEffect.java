package com.nabr.morefood.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

import java.util.List;

public class AMaTeRaSuEffect extends StatusEffect {
	public AMaTeRaSuEffect() {
        super(StatusEffectCategory.BENEFICIAL, // 药水效果是有益的还是有害的
                0xFFFFE0);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(StatusEffects.DARKNESS)){
            entity.removeStatusEffect(StatusEffects.DARKNESS);
        }
        Box box = entity.getBoundingBox().expand(5.0);
        List<LivingEntity> targets = world.getEntitiesByClass(LivingEntity.class , box , e -> e != entity);

        for (LivingEntity target : targets) {
            target.setOnFireFor(5);
        }
        return true;
    }
}
