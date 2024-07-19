package net.leah.makeitgoth.block.entity;

import net.leah.makeitgoth.block.custom.FogThingy;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FogThingyBlockEntity extends BlockEntity {

    private int number;


    public FogThingyBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FOG_THINGY_BLOCK_ENTITY, pos, state);
    }



    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        // Save the current value of the number to the nbt
        nbt.putInt("number", number);

        super.writeNbt(nbt, wrapper);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
        super.readNbt(nbt, wrapper);

        number = nbt.getInt("number");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, FogThingyBlockEntity blockEntity)
    {
        Random random = world.random;
        int i;
        if (random.nextFloat() < 0.11F) {
            for(i = 0; i < random.nextInt(2) + 2; ++i) {
                FogThingy.spawnSmokeParticle(world, blockPos,5);
            }
        }
    }
}
