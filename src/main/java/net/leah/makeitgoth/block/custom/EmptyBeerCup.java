package net.leah.makeitgoth.block.custom;

import com.mojang.serialization.MapCodec;
import net.leah.makeitgoth.utils.Helper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;


public class EmptyBeerCup extends HorizontalFacingBlock {
    MapCodec<EmptyBeerCup> CODEC = EmptyBeerCup.createCodec(EmptyBeerCup::new);
    // The Base Cup Shape
    VoxelShape CUP_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 8.0, 11.0);
    VoxelShape FULL_SHAPE = VoxelShapes.union(
            CUP_SHAPE,
            // The Handle Shape
            Block.createCuboidShape(3.0, 1.0, 7.999, 5.0, 7.0, 8.001)
    );
    VoxelShape NORTH_SHAPE = FULL_SHAPE;
    VoxelShape EAST_SHAPE = Helper.rotateVoxelShape(1, FULL_SHAPE);
    VoxelShape SOUTH_SHAPE = Helper.rotateVoxelShape(2, FULL_SHAPE);
    VoxelShape WEST_SHAPE = Helper.rotateVoxelShape(3, FULL_SHAPE);
    VoxelShape COLLISION_SHAPE = CUP_SHAPE;

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
            default -> FULL_SHAPE;
        };
    }
}
