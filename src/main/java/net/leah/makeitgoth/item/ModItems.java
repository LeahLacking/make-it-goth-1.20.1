package net.leah.makeitgoth.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.block.ModBlocks;
import net.leah.makeitgoth.item.custom.BleedItem;
import net.leah.makeitgoth.item.custom.BlindItem;
import net.leah.makeitgoth.item.custom.ChipItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;

import static net.leah.makeitgoth.MakeItGoth.id;

public class ModItems {
    public static ArrayList<Item> creativeTabItems = new ArrayList<>();
    

    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            // This is how you add food components to an item
            new Item(new Item.Settings().food(ModFoodComponents.STEEL_INGOT)));

    public static final Item PUMPKIN_RUM_ITEM = registerItem("pumpkin_rum_item",
            // This is how you add food components to an item
            new BlockItem(ModBlocks.PUMPKIN_RUM, new Item.Settings().food(ModFoodComponents.STEEL_INGOT)));
    public static final Item WHEEL_SAW = registerItem("wheel_saw", new ChipItem(
            ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(ChipItem.createAttributeModifiers(ToolMaterials.NETHERITE, 4, -3f))));

    public static final Item RUSTED_SCYTHE = registerItem("rusted_scythe", new BlindItem(
            ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2.5f, -2.1f))));
    public static final Item RIFLE_HALBERD = registerItem("rifle_halberd",
            new BleedItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(BleedItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2.5f, -3f))));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {

    }

    public static Item registerItem(String name, Item item) {
        Item regItem = Registry.register(Registries.ITEM, id(name), item);
        creativeTabItems.add(regItem);
        return regItem;
    }

    public static void registerModItems() {
        MakeItGoth.LOGGER.info("Registering ModItems for" + MakeItGoth.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToIngredientItemGroup);
    }

}


