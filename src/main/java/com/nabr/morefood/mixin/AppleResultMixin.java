package com.nabr.morefood.mixin;

import com.nabr.morefood.item.ItemMain;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashSet;
import java.util.Set;

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
        if(!world.isClient && stack.isOf(ItemMain.INFINITE_APPLE ) && !user.isInCreativeMode()){
            if(user instanceof PlayerEntity player){
                ItemStack returnStack = new ItemStack(ItemMain.INFINITE_APPLE, 1);
                if (!player.getInventory().insertStack(returnStack)) {
                    // 背包满了，掉落在玩家位置
                    player.dropItem(returnStack, false);
                }
                Text eatFinishText = Text.literal("我又出来了");
                player.sendMessage(eatFinishText,false);
            }
        }
        if(!world.isClient && stack.isOf(ItemMain.REDSTONE_APPLE )){
            if(user instanceof PlayerEntity player){
                Text eatFinishText = Text.literal("阿玛特拉斯");
                player.sendMessage(eatFinishText,false);
            }
        }
        if(!world.isClient && stack.isOf(ItemMain.ENDER_APPLE )){
            if(user instanceof PlayerEntity player){
                MinecraftServer server = player.getServer();
                ServerWorld getEndId = server.getWorld(World.END);
                double destX = 100.5;
                double destY = 49.0;
                double destZ = 0.5;

                // 3. 设置旋转角度 (通常朝向西，即 yaw = 90)
                float yaw = 90.0f;
                float pitch = 0.0f;

                // 4. 设置标志位 (使用空集表示所有坐标均为绝对坐标)
                Set<PositionFlag> flags = new HashSet<>();
                user.teleport(getEndId , destX , destY ,destZ , flags , yaw , pitch , true);
                Text eatFinishText = Text.literal("这是哪");
                player.sendMessage(eatFinishText,false);
            }
        }
    }
}
