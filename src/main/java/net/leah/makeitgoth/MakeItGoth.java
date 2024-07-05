package net.leah.makeitgoth;

import net.fabricmc.api.ModInitializer;

import net.leah.makeitgoth.block.ModBlocks;
import net.leah.makeitgoth.block.entity.ModBlockEntities;
import net.leah.makeitgoth.effect.ModEffects;
import net.leah.makeitgoth.item.ModItemGroups;
import net.leah.makeitgoth.item.ModItems;
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
		ModBlockEntities.registerBlockEntities();
		ModEffects.registerModEffects();

		LOGGER.info("Hello Fabric world!");
	}
}