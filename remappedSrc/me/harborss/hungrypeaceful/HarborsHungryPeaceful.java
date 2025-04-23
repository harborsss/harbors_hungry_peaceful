package me.harborss.hungrypeaceful;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HarborsHungryPeaceful implements ModInitializer {
	public static final String MOD_ID = "harbors-hungry-peaceful";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("HARBOR'S HUNGRY PEACEFUL initialized successfully.");
	}
}