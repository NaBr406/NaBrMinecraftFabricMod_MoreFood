package com.nabr.morefood;

import com.nabr.morefood.item.ItemGroup;
import com.nabr.morefood.item.ItemMain;
import com.nabr.morefood.item.ModBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreFood implements ModInitializer {
	public static final String MOD_ID = "more_food";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ItemMain.initialize();
		ItemGroup.initialize();
		ModBlocks.initialize();
	}
}