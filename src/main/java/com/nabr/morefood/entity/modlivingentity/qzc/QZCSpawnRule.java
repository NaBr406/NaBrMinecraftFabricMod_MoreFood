package com.nabr.morefood.entity.modlivingentity.qzc;

import com.nabr.morefood.entity.modlivingentity.EntityMain;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class QZCSpawnRule {
    public static void QZCSpawnRule(LivingEntity player) {
        QZCEntity qzc = new QZCEntity(EntityMain.QZC , player.getWorld());
        if(player.age % 20 == 0){

        }
    }
}
