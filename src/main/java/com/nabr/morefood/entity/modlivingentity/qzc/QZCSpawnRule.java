package com.nabr.morefood.entity.modlivingentity.qzc;

import com.nabr.morefood.MoreFood;
import com.nabr.morefood.entity.modlivingentity.EntityMain;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;



public class QZCSpawnRule {
    public static void QZCSpawnRule() {
        SpawnRestriction.register(EntityMain.QZC,
                SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MobEntity::canMobSpawn);

        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER,
                EntityMain.QZC,
                5,
                2,
                4
        );
        MoreFood.LOGGER.info("QZC SpawnRule Succeed");
    }
}
