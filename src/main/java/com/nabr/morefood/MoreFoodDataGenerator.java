package com.nabr.morefood;

import com.nabr.morefood.datagenertor.modLootTableGenerator;
import com.nabr.morefood.datagenertor.modModelGenerator;
import com.nabr.morefood.datagenertor.modRecipeGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoreFoodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(modRecipeGenerator::new);
		pack.addProvider(modModelGenerator::new);
		pack.addProvider(modLootTableGenerator::new);
	}
}
