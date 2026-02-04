package com.nabr.morefood.mixin;

import com.nabr.morefood.item.ItemMain;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class LightningAppleMixin {
    @Inject(at = @At("RETURN"), method = "finishUsing")
    private void LinghtningEatFinish(ItemStack stack, World world, LivingEntity user , CallbackInfoReturnable<ItemStack> cir){
        if(!world.isClient && stack.isOf(ItemMain.LIGHTNING_APPLE)){
            if(user instanceof PlayerEntity player){
                String UserName = player.getName().getString();
                Text eatFinishText = Text.literal(UserName+"吃掉了闪电苹果 电闪雷鸣");
                player.sendMessage(eatFinishText,false);
            }
        }
    }
}
