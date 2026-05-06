package com.nabr.morefood.mixin;


import com.nabr.morefood.entity.modlivingentity.angerqzc.AngerQZCEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class AngerQZCActionMixin {
    @Inject(at = @At("HEAD"), method = "tryAttack")
    public void angerQZCAction(ServerWorld world , Entity target , CallbackInfoReturnable<Boolean> cir) {
        if((Object)this instanceof AngerQZCEntity && target instanceof LivingEntity) {
            LivingEntity tar = (LivingEntity)target;
            //血量低于最大生命值1/2直接斩杀
            if(tar.getHealth() <= tar.getMaxHealth()/2) {
                tar.isDead();
            }
        }
    }
}
