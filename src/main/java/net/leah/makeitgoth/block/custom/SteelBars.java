package net.leah.makeitgoth.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.enums.Thickness;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class SteelBars extends Block {
    public static BooleanProperty BOTTOM = Properties.BOTTOM;
    public SteelBars(Settings settings) {
        super(settings);

        this.setDefaultState(this.stateManager.getDefaultState().with(BOTTOM, false));

    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BOTTOM});
    }
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        //if ((Boolean) state.get(WATERLOGGED)) {
          //  world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
       // }
        return state;
    }

    @Nullable

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState furryParent = super.getPlacementState(ctx);
        if (furryParent == null) {
            return null;
        }
        WorldAccess worldAccess = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        BlockState subbyWubbyBottom = worldAccess.getBlockState(pos.up());
        boolean isItSubbyWubbyBottom = false;
        if (subbyWubbyBottom.getBlock() instanceof SteelBars) {
            isItSubbyWubbyBottom = true;
        }

        return furryParent.with(BOTTOM, isItSubbyWubbyBottom);
    }
}
