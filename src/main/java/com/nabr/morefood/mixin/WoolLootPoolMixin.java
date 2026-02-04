package com.nabr.morefood.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(SheepEntity.class)
public abstract class WoolLootPoolMixin {

   @Shadow public abstract DyeColor getColor();

    //@Inject(method = "dropLoot", at = @At("TAIL"), cancellable = true)
    private void woolLootPool(DamageSource source, boolean causedByPlayer, CallbackInfo ci) {
        DyeColor color = this.getColor();
    }
}
