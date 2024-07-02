package net.leah.makeitgoth;

import net.fabricmc.api.ModInitializer;

import net.leah.makeitgoth.block.ModBlocks;
import net.leah.makeitgoth.effect.ModEffects;
import net.leah.makeitgoth.item.ModItemGroups;
import net.leah.makeitgoth.item.ModItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MakeItGoth implements ModInitializer {
	public static final String MOD_ID = "makeitgoth";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlock();
		ModEffects.registerModEffects();

		LOGGER.info("Hello Fabric world!");
	}

	//When ever you need and Identifier us this, for example when registering a block:
	// Registry.register(Registries.BLOCK, id(name), block)
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}