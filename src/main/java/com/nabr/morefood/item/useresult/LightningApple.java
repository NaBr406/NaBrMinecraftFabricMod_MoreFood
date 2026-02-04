package com.nabr.morefood.item.useresult;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightningApple extends Item {

    public LightningApple(Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        // 1. 首先调用父类方法，处理正常的食物效果（如恢复饥饿值）
        ItemStack returnStack = super.finishUsing(stack, world, user);

        // 2. 在服务端执行自定义逻辑
        if (!world.isClient) {
            // 确保使用者是玩家（LivingEntity 可能是其他生物）
            if (user instanceof PlayerEntity player) {
                // 获取玩家前方 10 格的位置
                BlockPos frontOfPlayer = player.getBlockPos().offset(player.getHorizontalFacing(), 10);

                // 创建并生成闪电
                LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                //ZombieEntity zombie = new ZombieEntity(EntityType.ZOMBIE,world);
                //zombie.setPosition(player.getPos());
                lightningBolt.setPosition(frontOfPlayer.toCenterPos());
                world.spawnEntity(lightningBolt);
                //world.spawnEntity(zombie);
            }
        }

        // 3. 返回处理后的物品堆
        return returnStack;
    }
}
