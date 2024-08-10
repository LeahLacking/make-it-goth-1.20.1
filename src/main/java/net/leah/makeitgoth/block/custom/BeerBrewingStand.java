package net.leah.makeitgoth.block.custom;

import com.mojang.serialization.MapCodec;
import net.leah.makeitgoth.block.entity.BeerBrewingStandBlockEntity;
import net.leah.makeitgoth.block.entity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BeerBrewingStand extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<BeerBrewingStand> CODEC = createCodec(BeerBrewingStand::new);
    public BeerBrewingStand(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BeerBrewingStandBlockEntity(pos,state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BeerBrewingStandBlockEntity) {
                ItemScatterer.spawn(world, pos, (BeerBrewingStandBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BeerBrewingStandBlockEntity) {
                player.openHandledScreen((BeerBrewingStandBlockEntity)blockEntity);
            }

            return ActionResult.CONSUME;
        }
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? null : validateTicker(type, ModBlockEntities.BEER_BREWING_STAND_BLOCK_ENTITY, BeerBrewingStandBlockEntity::tick);
    }
}
