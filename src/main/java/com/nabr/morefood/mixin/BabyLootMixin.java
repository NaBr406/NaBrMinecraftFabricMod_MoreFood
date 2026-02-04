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
                cir.setReturnValue(true); // 强制返回 true，让逻辑继续走下去读 JSON
    }
}