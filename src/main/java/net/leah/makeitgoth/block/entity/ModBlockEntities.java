package net.leah.makeitgoth.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.leah.makeitgoth.MakeItGoth;
import net.leah.makeitgoth.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<FogThingyBlockEntity> FOG_THINGY_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MakeItGoth.MOD_ID, "fog_thingy_block_entity"),
                    BlockEntityType.Builder.create(FogThingyBlockEntity::new,
                            ModBlocks.FOG_THINGY_BLOCK).build());

    public static final BlockEntityType<BeerBrewingStandBlockEntity> BEER_BREWING_STAND_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MakeItGoth.MOD_ID,"beer_brewing_stand_block_entity"),
                    BlockEntityType.Builder.create(BeerBrewingStandBlockEntity::new,
                            ModBlocks.BeerBrewingStandBlock).build());

    public static void registerBlockEntities() {
        MakeItGoth.LOGGER.info("Registering Block Entities for " + MakeItGoth.MOD_ID);
    }
}