package com.nabr.morefood.mixin;

import com.nabr.morefood.item.ItemMain;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class AppleResultMixin {
    @Inject(at = @At("HEAD"), method = "finishUsing")
    private void LinghtningEatFinish(ItemStack stack, World world, LivingEntity user , CallbackInfoReturnable<ItemStack> cir){
        if(!world.isClient && stack.isOf(ItemMain.LIGHTNING_APPLE)){
            if(user instanceof PlayerEntity player){
                BlockPos frontOfPlayer = player.getBlockPos().offset(player.getHorizontalFacing(), 10);
                // 创建并生成闪电
                LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                //ZombieEntity zombie = new ZombieEntity(EntityType.ZOMBIE,world);
                //zombie.setPosition(player.getPos());
                lightningBolt.setPosition(frontOfPlayer.toCenterPos());
                world.spawnEntity(lightningBolt);
                String UserName = player.getName().getString();
                Text eatFinishText = Text.literal("哪在打雷");
                player.sendMessage(eatFinishText,false);
            }
        }
        if(!world.isClient && stack.isOf(ItemMain.INFINITE_APPLE)){
            if(user instanceof PlayerEntity player){
                ItemStack drop = new ItemStack(ItemMain.INFINITE_APPLE , 1);
                player.getInventory().insertStack(drop);
                Text eatFinishText = Text.literal("我又出来了");
                player.sendMessage(eatFinishText,false);
            }
        }
    }
}
