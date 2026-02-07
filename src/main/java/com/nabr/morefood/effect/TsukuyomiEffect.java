package com.nabr.morefood.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

import java.util.List;

public class TsukuyomiEffect extends StatusEffect {
    public TsukuyomiEffect() {
        super(StatusEffectCategory.BENEFICIAL, // 药水效果是有益的还是有害的
                0x4B0082);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        Box box = entity.getBoundingBox().expand(5.0);
        List<LivingEntity> targets = world.getEntitiesByClass(LivingEntity.class , box , e -> e != entity);

        for (LivingEntity target : targets) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5*20, 2));
        }

        return true;
    }
}

