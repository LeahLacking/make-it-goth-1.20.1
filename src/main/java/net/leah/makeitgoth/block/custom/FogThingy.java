package net.leah.makeitgoth.block.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.leah.makeitgoth.block.entity.FogThingyBlockEntity;
import net.leah.makeitgoth.block.entity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static java.util.stream.IntStream.range;

//I have no fucking clue what I did here, I'll redo this later, same thing with the block entity
public class FogThingy extends BlockWithEntity {

    public static final MapCodec<FogThingy> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(Codec.BOOL.fieldOf("spawn_particles").forGetter((block) -> {
            return block.emitsParticles;
        }), Codec.intRange(0, 50).fieldOf("smoke_radius").forGetter((block) -> {
            return block.smokeradius;
        }), createSettingsCodec()).apply(instance, FogThingy::new);
    });


    private final boolean emitsParticles;
    public int smokeradius;

    public FogThingy(boolean emitsParticles,int smokeradius, Settings settings) {
        super(settings);
        this.emitsParticles = emitsParticles;
        this.smokeradius = smokeradius;
    }

    public MapCodec<FogThingy> getCodec() {
        return CODEC;
    }

    public static void spawnSmokeParticle(World world, BlockPos pos, int smokeradius) {
        Random random = world.getRandom();
        BlockPos smokepos;
        int x1 = pos.getX()-smokeradius;
        int x2 = pos.getX()+smokeradius;
        int z1  = pos.getZ()-smokeradius;
        int z2 = pos.getZ()+smokeradius;
        int[] x = range(x1,x2+1).toArray();
        int[] z = range(z1,z2+1).toArray();


        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < z.length; j++) {
                world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x[i], pos.getY()+0.25, z[j], 0, 0.000007, 0);
                world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x[j], pos.getY()+0.25, z[i], 0, 0.000007, 0);
                //world.addParticle(ParticleTypes.SMOKE, x[i]-smokeradius, pos.getY(), z[j], 0, 0.07, 0);
               // world.addParticle(ParticleTypes.SMOKE, x[j], pos.getY(), z[i]-smokeradius, 0, 0.07, 0);
            }

        }

        //world.addImportantParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, true, (double)pos.getX() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1), 0.0, 0.07, 0.0);

    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }


    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FogThingyBlockEntity(pos, state);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState blockState, BlockEntityType<T> blockEntityType)
    {
        return level.isClient()
                ? createTickerHelper(blockEntityType, FogThingyBlockEntity::tick)
                : null;
    }

    protected static <E extends BlockEntity, A extends BlockEntity>BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> a, BlockEntityTicker<? super E> c) {
        return a == ModBlockEntities.FOG_THINGY_BLOCK_ENTITY ? (BlockEntityTicker<A>)c : null;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (this.smokeradius<50){
            this.smokeradius=this.smokeradius+5;
        }else
            this.smokeradius=5;
        return super.onUse(state, world, pos, player, hit);
    }
}