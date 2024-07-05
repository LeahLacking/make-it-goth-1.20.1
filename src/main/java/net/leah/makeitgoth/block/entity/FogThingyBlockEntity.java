package net.leah.makeitgoth.block.entity;

import net.leah.makeitgoth.block.ModBlocks;
import net.leah.makeitgoth.block.custom.FogThingy;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class FogThingyBlockEntity extends BlockEntity {
    public FogThingyBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FOG_THINGY_BLOCK_ENTITY, pos, state);
    }


    public static void clientTick(World world, BlockPos pos, BlockState state, FogThingy fogThingy) {
        Random random = world.random;
        int i;
        if (random.nextFloat() < 0.11F) {
            for(i = 0; i < random.nextInt(2) + 2; ++i) {
                FogThingy.spawnSmokeParticle(world, pos, false, false);
            }
        }
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
