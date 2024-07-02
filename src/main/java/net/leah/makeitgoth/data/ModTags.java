package net.leah.makeitgoth.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import static net.leah.makeitgoth.MakeItGoth.id;

public class ModTags {

    public static final TagKey<Block> ROTWOOD_LOGS = blockTag("rotwood_logs");
    public static final TagKey<Item> ROTWOOD_LOGS_ITEM = itemTag("rotwood_logs");





    public static TagKey<Block> blockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, id(name));
    }

    public static TagKey<Item> itemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, id(name));
    }
}
