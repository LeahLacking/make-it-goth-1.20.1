package net.leah.makeitgoth.utils;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public interface Helper {
    /**
     * rotates the voxel shape by 90 degrees * times variable (clockwise I think) and returns the result
     *
     * @param times how many times to rotate by 90 degrees
     * @param shape the shape to rotate by 90 degrees
     * @return the rotated shape
     */
    static VoxelShape rotateVoxelShape(int times, VoxelShape shape) {
        VoxelShape[] shapes = new VoxelShape[]{shape, VoxelShapes.empty()};
        for (int i = 0; i < times; i++) {
            shapes[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) ->
                    shapes[1] = VoxelShapes.union(shapes[1], VoxelShapes.cuboid(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX))
            );
            shapes[0] = shapes[1];
            shapes[1] = VoxelShapes.empty();
        }
        return shapes[0];
    }
}
