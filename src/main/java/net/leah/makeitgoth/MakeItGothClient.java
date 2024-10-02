package net.leah.makeitgoth;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.leah.makeitgoth.screen.BeerBrewingScreen;
import net.leah.makeitgoth.screen.ModScreenHandlers;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

import java.util.stream.Stream;

import static net.leah.makeitgoth.block.ModBlocks.*;

public class MakeItGothClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Stream.of(STEEL_GRATE, STEEL_BARS, EMPTY_BEER_CUP, PUMPKIN_RUM, BEER)
                .forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));

        HandledScreens.register(ModScreenHandlers.BEER_BREWING_STAND_SCREEN_HANDLER, BeerBrewingScreen::new);
    }
}
