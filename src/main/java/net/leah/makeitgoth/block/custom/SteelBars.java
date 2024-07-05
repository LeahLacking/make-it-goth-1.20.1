package net.leah.makeitgoth.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class SteelBars extends PaneBlock {
    public static BooleanProperty SPIKES = BooleanProperty.of("spikes");



    public SteelBars(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(NORTH, false)
                .with(EAST, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(WATERLOGGED, false)
                .with(SPIKES, false)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(SPIKES);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState superState = super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        if (superState == null) return null;

        if (Direction.UP == direction) {
            boolean spikes = superState.get(SPIKES);
            boolean isSteelBars = neighborState.getBlock() instanceof SteelBars;
            if (spikes && isSteelBars) {
                superState = superState.with(SPIKES, false);
            } else if (!isSteelBars) {
                superState = superState.with(SPIKES, true);
            }
        }

        return superState;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState superSate = super.getPlacementState(ctx);
        if (superSate == null) return null;

        WorldAccess world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        BlockState aboveBlock = world.getBlockState(pos.up());


        return superSate.with(SPIKES, !(aboveBlock.getBlock() instanceof SteelBars));


    }

}
