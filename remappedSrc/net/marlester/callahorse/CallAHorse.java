package net.marlester.everythingasahat;

import net.fabricmc.api.ModInitializer;
import net.marlester.everythingasahat.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CallAHorse implements ModInitializer {
	public static final String MOD_ID = "callahorse";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

	}
}
