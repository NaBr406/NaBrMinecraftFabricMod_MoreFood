package com.nabr.morefood.entity.modlivingentity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class QZCEntity extends PathAwareEntity {
    public QZCEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 20.0)      // 原 GENERIC_MAX_HEALTH
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25)  // 原 GENERIC_MOVEMENT_SPEED
                .add(EntityAttributes.ARMOR, 2.0)            // 护甲值
                .add(EntityAttributes.ATTACK_DAMAGE, 3.0);   // 攻击力
    }
    protected void initGoals() {
        // 优先级 0：最高优先级，游泳（防止淹死）
        this.goalSelector.add(0, new SwimGoal(this));

        // 优先级 1：近战攻击（如果发现目标，就冲过去打）
        // 1.0D 是移动速度倍率
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));

        // 优先级 2：随机游荡（没事干的时候到处走）
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0D));

        // 优先级 3：看着玩家（周围有玩家时会转头看）
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));

        // 优先级 4：随机看周围（发呆）
        this.goalSelector.add(4, new LookAroundGoal(this));

        // --- 仇恨目标选择器 (Target Selector) ---
        // 这一步很关键：如果没有目标选择器，它虽然有“攻击能力”，但不知道“该打谁”

        // 主动寻找目标：攻击玩家
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }
}
