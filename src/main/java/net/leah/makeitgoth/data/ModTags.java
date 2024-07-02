package net.leah.makeitgoth.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import static net.leah.makeitgoth.MakeItGoth.id;

public interface ModTags {

    TagKey<Block> ROTWOOD_LOGS = blockTag("rotwood_logs");
    TagKey<Item> ROTWOOD_LOGS_ITEM = itemTag("rotwood_logs");

    static TagKey<Block> blockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, id(name));
    }

    static TagKey<Item> itemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, id(name));
    }
}
