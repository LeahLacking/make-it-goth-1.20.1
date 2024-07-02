package net.leah.makeitgoth.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.item.custom.BleedItem;
import net.leah.makeitgoth.item.custom.ChipItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static net.leah.makeitgoth.MakeItGoth.id;

public class ModItems {
    public static final Item STEEL_INGOT = registerItem("steel_ingot",
            // This is how you add food components to an item
            new Item(new Item.Settings().food(ModFoodComponents.STEEL_INGOT)));
    public static final Item WHEEL_SAW = registerItem("wheel_saw", new ChipItem(
            ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(ChipItem.createAttributeModifiers(ToolMaterials.NETHERITE, 4, 3f))));
    public static final Item RIFLE_HALBERD = registerItem("rifle_halberd",
            new BleedItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(BleedItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -3f))));
    public static final Item RUSTED_TWINBLADES = registerItem("rusted_twinblades",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2))));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, id(name), item);
    }

    public static void registerModItems() {
        MakeItGoth.LOGGER.info("Registering ModItems for" + MakeItGoth.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToIngredientItemGroup);

    }
}


