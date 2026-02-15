package com.nabr.morefood.entity.modlivingentity;

import com.nabr.morefood.entity.modlivingentity.qzc.QZCEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class EntityMain implements ModInitializer {
    public static final EntityType<QZCEntity> QZC = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("more_food", "qzc"),
            EntityType.Builder.create(QZCEntity::new, SpawnGroup.MONSTER)
                    .dimensions(2.0f, 2.0f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of("more_food", "qzc")))
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(QZC, QZCEntity.createAttributes());
    }
}
