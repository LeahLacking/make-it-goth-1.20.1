package net.leah.makeitgoth.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.leah.makeitgoth.MakeItGoth;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler {

    public static void registerScreenHandlers() {
        MakeItGoth.LOGGER.info("Registering Screen Handlers for " + MakeItGoth.MOD_ID);
    }
}
