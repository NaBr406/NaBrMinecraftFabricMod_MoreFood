package com.nabr.morefood.entity.modlivingentity.angerqzc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AngerQZCEntity extends HostileEntity {

    private BlockPos homePos;
    private static final double HOME_RADIUS = 8.0D;

    public AngerQZCEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAngerQZCAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 100.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.5D)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 5.0D)
                .add(EntityAttributes.ARMOR, 4.0D)
                .add(EntityAttributes.ATTACK_DAMAGE, 20.0D)
                .add(EntityAttributes.FOLLOW_RANGE, 50.0D);
    }

        @Override
        protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));

        this.targetSelector.add(0, new RevengeGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

         @Override
         public void tick() {
            super.tick();

        if (this.getWorld().isClient()) {
            return;
        }

        if (this.homePos == null) {
            this.homePos = this.getBlockPos().toImmutable();
        }

        if (this.getTarget() == null && this.homePos != null && this.age % 20 == 0) {
            double distSq = this.squaredDistanceTo(
                    this.homePos.getX() + 0.5,
                    this.homePos.getY(),
                    this.homePos.getZ() + 0.5
            );

            if (distSq > HOME_RADIUS * HOME_RADIUS) {
                this.getNavigation().startMovingTo(
                        this.homePos.getX() + 0.5,
                        this.homePos.getY(),
                        this.homePos.getZ() + 0.5,
                        1.0D
                );
            }
        }
    }
}