package com.nabr.morefood;

import com.nabr.morefood.datagenertor.*;
import com.nabr.morefood.structures.ModBiomeTagProvider;
import com.nabr.morefood.structures.ModStructures;
import com.nabr.morefood.structures.ModWorldgenBootstrap;
import com.nabr.morefood.structures.ModWorldgenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MoreFoodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModModelGenerator::new);
		pack.addProvider(ModLootTableGenerator::new);
		pack.addProvider(ModItemTagsGenerator::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModBiomeTagProvider::new);
		pack.addProvider(ModWorldgenProvider::new);
	}
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		// 注册 Bootstrap 数据构建方法
		registryBuilder.addRegistry(RegistryKeys.TEMPLATE_POOL, ModWorldgenBootstrap::bootstrapPools);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE, ModWorldgenBootstrap::bootstrapStructures);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE_SET, ModWorldgenBootstrap::bootstrapStructureSets);
	}
}
