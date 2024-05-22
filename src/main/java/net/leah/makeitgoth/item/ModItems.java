package net.leah.makeitgoth.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.item.custom.BleedItem;
import net.leah.makeitgoth.item.custom.ChipItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
 public static final Item STEEL_INGOTS = registerItem("steel_ingots",
    new Item(new FabricItemSettings()));
    public static final Item WHEEL_SAW = registerItem("wheel_saw",new ChipItem(
            ToolMaterials.NETHERITE, 4 , 3f,new Item.Settings()));

    public static final Item RIFLE_HALBERD = registerItem("rifle_halberd",
            new BleedItem(ToolMaterials.DIAMOND, 4, -3f, new Item.Settings()));




    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {


    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MakeItGoth.MOD_ID, name), item);
    }
    public static void registerModItems() {
        MakeItGoth.LOGGER.info("Registering ModItems for" + MakeItGoth.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToIngredientItemGroup);

    }
}


