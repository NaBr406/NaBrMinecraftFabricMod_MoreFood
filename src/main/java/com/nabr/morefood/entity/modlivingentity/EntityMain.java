package com.nabr.morefood.entity.modlivingentity;

import com.nabr.morefood.entity.modlivingentity.angerqzc.AngerQZCEntity;
import com.nabr.morefood.entity.modlivingentity.qzc.QZCEntity;
import com.nabr.morefood.entity.modlivingentity.qzc.QZCSpawnRule;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class EntityMain implements ModInitializer {

    public static final EntityType<QZCEntity> QZC = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("more_food", "qzc"),
            EntityType.Builder.create(QZCEntity::new, SpawnGroup.MONSTER)
                    .dimensions(2.0f, 2.0f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of("more_food", "qzc")))
    );

    public static final EntityType<AngerQZCEntity> ANGER_QZC = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("more_food", "anger_qzc"),
            EntityType.Builder.create(AngerQZCEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.9f, 1.6f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of("more_food", "anger_qzc")))
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(QZC, QZCEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ANGER_QZC, AngerQZCEntity.createAngerQZCAttributes());
        QZCSpawnRule.QZCSpawnRule();
    }
}