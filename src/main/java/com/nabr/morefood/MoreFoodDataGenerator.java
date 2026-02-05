package com.nabr.morefood;

import com.nabr.morefood.datagenertor.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoreFoodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModModelGenerator::new);
		pack.addProvider(ModLootTableGenerator::new);
		pack.addProvider(ModItemTagsGenerator::new);
		pack.addProvider(ModBlockLootTableProvider::new);
	}
}
