package com.nabr.morefood.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PassiveEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class BabyLootMixin {

    @Shadow public abstract boolean isBaby();

    @Inject(method = "shouldDropLoot", at = @At("HEAD"), cancellable = true)
    private void BabyLoot(CallbackInfoReturnable<Boolean> cir) {
        // 关键：我们只需要对“被动生物”（猪、牛、羊等）放行
        // 使用 (Object)this 强转是 Mixin 的标准操作
                cir.setReturnValue(true); // 强制返回 true，让逻辑继续走下去读 JSON
    }
}