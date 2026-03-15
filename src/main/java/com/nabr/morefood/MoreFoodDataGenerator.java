package com.nabr.morefood;

import com.nabr.morefood.datagenertor.*;
import com.nabr.morefood.datagenertor.structures.angerqzchome.QZCHomeWorldgenBootstrap;
import com.nabr.morefood.datagenertor.structures.ModBiomeTagProvider;
import com.nabr.morefood.datagenertor.structures.appletree.AppleTreeWorldgenBootstrap;
import com.nabr.morefood.datagenertor.structures.ModWorldgenProvider;
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
		registryBuilder.addRegistry(RegistryKeys.TEMPLATE_POOL, AppleTreeWorldgenBootstrap::bootstrapPools);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE, AppleTreeWorldgenBootstrap::bootstrapStructures);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE_SET, AppleTreeWorldgenBootstrap::bootstrapStructureSets);

		registryBuilder.addRegistry(RegistryKeys.TEMPLATE_POOL, QZCHomeWorldgenBootstrap::bootstrapPools);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE, QZCHomeWorldgenBootstrap::bootstrapStructures);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE_SET, QZCHomeWorldgenBootstrap::bootstrapStructureSets);
	}
}
