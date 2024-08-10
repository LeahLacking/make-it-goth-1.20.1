package net.leah.makeitgoth.screen;

import net.leah.makeitgoth.MakeItGoth;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<BeerBrewingStandScreenHandler> BEER_BREWING_STAND_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER,Identifier.of(MakeItGoth.MOD_ID,"beer_brewing_stand_screen_handler"),
                    new ScreenHandlerType<>(BeerBrewingStandScreenHandler::new,FeatureFlags.VANILLA_FEATURES));


}
