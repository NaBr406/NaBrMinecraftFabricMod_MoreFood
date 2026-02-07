package com.nabr.morefood.mixin;

import com.nabr.morefood.MoreFood;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class EffectMixin {
    @Inject(at = @At("HEAD"), method = "tick")
    private void onTick(CallbackInfo ci) {
        // 只有在服务端处理逻辑，避免客户端预测冲突
        LivingEntity entity = (LivingEntity)(Object)this;
        if (entity.getWorld().isClient) return;

        // 只有拥有特定效果时才触发
        boolean hasRequirement = entity.hasStatusEffect(MoreFood.TSUKUYOMI) ||
                entity.hasStatusEffect(MoreFood.AMATERASU);

        if (hasRequirement) {
            // 2. 性能优化：检查是否已经有效果，且持续时间是否快到了（比如少于 5 秒/100 tick）
            // 这样每 5 秒才会执行一次 addStatusEffect，而不是每秒 20 次
            StatusEffectInstance current = entity.getStatusEffect(MoreFood.TRUEAMATERASUPOWER);
            if (current == null || current.getDuration() < 100) {
                entity.addStatusEffect(new StatusEffectInstance(MoreFood.TRUEAMATERASUPOWER, 200, 0, true, false));
            }
        }
    }
}