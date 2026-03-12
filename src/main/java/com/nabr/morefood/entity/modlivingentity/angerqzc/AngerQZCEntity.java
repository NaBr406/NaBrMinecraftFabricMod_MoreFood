package com.nabr.morefood.entity.modlivingentity.angerqzc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class AngerQZCEntity extends HostileEntity {
    public AngerQZCEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createAngerQZCAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 100.0D)//最大生命
                .add(EntityAttributes.MOVEMENT_SPEED, 0.5D)//移动速度
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 5.0D)//击退抗性
                .add(EntityAttributes.ARMOR, 4.0D)//护甲
                .add(EntityAttributes.ATTACK_DAMAGE , 20.0)//伤害
                .add(EntityAttributes.FOLLOW_RANGE, 50.0D);//追踪半径
    }
    protected  void initGoals() {
        this.goalSelector.add(0 , new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }
}
