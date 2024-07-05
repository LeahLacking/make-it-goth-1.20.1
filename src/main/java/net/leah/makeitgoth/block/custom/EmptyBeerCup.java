package net.leah.makeitgoth.block.custom;

import com.mojang.serialization.MapCodec;
import net.leah.makeitgoth.utils.Helper;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;


public class EmptyBeerCup extends HorizontalFacingBlock {
    MapCodec<EmptyBeerCup> CODEC = EmptyBeerCup.createCodec(EmptyBeerCup::new);
    VoxelShape BASE_SHAPE = VoxelShapes.union(LecternBlock.BOTTOM_SHAPE, LecternBlock.MIDDLE_SHAPE); // this is just stole from the lectern
    VoxelShape NORTH_SHAPE = BASE_SHAPE;
    VoxelShape SOUTH_SHAPE = Helper.rotateVoxelShape(1, BASE_SHAPE);
    VoxelShape EAST_SHAPE = Helper.rotateVoxelShape(2, BASE_SHAPE);
    VoxelShape WEST_SHAPE = Helper.rotateVoxelShape(3, BASE_SHAPE);
    VoxelShape COLLISION_SHAPE = BASE_SHAPE; // you might want to not be the base shape idk

    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public EmptyBeerCup(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> BASE_SHAPE;
        };
    }
}
