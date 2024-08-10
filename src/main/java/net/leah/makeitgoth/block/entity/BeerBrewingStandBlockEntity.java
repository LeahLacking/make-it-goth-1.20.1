package net.leah.makeitgoth.block.entity;

import net.leah.makeitgoth.block.ModBlocks;
import net.leah.makeitgoth.screen.BeerBrewingStandScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class BeerBrewingStandBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4,ItemStack.EMPTY);

    //this is more of a list to remember what the slots are
    //private final int INGREDIENT_ONE_SLOT = 0;
    //private final int INGREDIENT_TWO_SLOT = 1;
    //private final int INGREDIENT_THREE_SLOT = 2;
    //private final int OUTPUT_SLOT = 3;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int brewTime;

    public BeerBrewingStandBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BEER_BREWING_STAND_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> BeerBrewingStandBlockEntity.this.progress;
                    case 1 -> BeerBrewingStandBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> BeerBrewingStandBlockEntity.this.progress = value;
                    case 1 -> BeerBrewingStandBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }


    public static void tick(World world, BlockPos pos, BlockState state, BeerBrewingStandBlockEntity blockEntity) {

        boolean bl = canCraft(blockEntity.inventory);
        boolean bl2 = blockEntity.brewTime > 0;
        if (bl2) {
            blockEntity.brewTime= blockEntity.brewTime-1;
            blockEntity.increaseCraftProgress();
            //I know this is redundant, but then I need to make the arrow work negatively
            if (blockEntity.brewTime == 0){
                craft(world, pos, blockEntity.inventory);
            } else if (!bl) {
                blockEntity.brewTime = 0;
                blockEntity.resetProgress();
            }

            markDirty(world, pos, state);
        } else if (bl) {
            blockEntity.brewTime = 600;
            markDirty(world, pos, state);
        }

    }


    //Don't bully my code, it works and recipes feels like a lot of work
    //if it's stupid and it works, it's not stupid
    private static boolean canCraft(DefaultedList<ItemStack> slots) {
        ItemStack itemStack1 = slots.get(0);
        ItemStack itemStack2 = slots.get(1);
        ItemStack itemStack3 = slots.get(2);
        ItemStack itemStackout = slots.get(3);
        boolean bl;
        if (itemStackout.isEmpty() && itemStack1.isEmpty() && itemStack2.isEmpty() && itemStack3.isEmpty()) {
            bl=false;
        } else if (itemStackout.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) && itemStack1.isOf(Items.WATER_BUCKET) || itemStack2.isOf(Items.WHEAT) && itemStack3.isEmpty()) {
            bl=true;
        } else if (itemStackout.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) && itemStack1.isOf(Items.WHEAT) || itemStack2.isOf(Items.WATER_BUCKET) && itemStack3.isEmpty()) {
            bl=true;
        } else if (itemStackout.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) && itemStack1.isEmpty() || itemStack2.isOf(Items.WHEAT) && itemStack3.isOf(Items.WATER_BUCKET)) {
            bl=true;
        } else if (itemStackout.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) && itemStack1.isEmpty() || itemStack2.isOf(Items.WATER_BUCKET) && itemStack3.isOf(Items.WHEAT)) {
            bl = true;
        } else if (itemStackout.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) && itemStack1.isOf(Items.WATER_BUCKET) || itemStack2.isOf(Items.NETHER_WART) && itemStack3.isOf(Items.PUMPKIN)) {
            bl=true;
        } else if (itemStackout.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) && itemStack1.isOf(Items.NETHER_WART) || itemStack2.isOf(Items.WATER_BUCKET) && itemStack3.isOf(Items.PUMPKIN)) {
            bl=true;
        } else if (itemStackout.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) && itemStack1.isOf(Items.PUMPKIN) || itemStack2.isOf(Items.NETHER_WART) && itemStack3.isOf(Items.WATER_BUCKET)) {
            bl=true;
        } else bl = itemStackout.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) && itemStack1.isOf(Items.PUMPKIN) || itemStack2.isOf(Items.WATER_BUCKET) && itemStack3.isOf(Items.NETHER_WART);

        return bl;
    }

    private static void craft(World world, BlockPos pos, DefaultedList<ItemStack> slots) {


        for (int i = 0; i < 2; i++) {
            if (slots.get(i).isOf(Items.WATER_BUCKET)){
                slots.set(i,Items.BUCKET.getDefaultStack());
            }else {
                slots.get(i).decrement(1);
            }

        }

        slots.set(3, ModBlocks.PUMPKIN_RUM.asItem().getDefaultStack());
        world.syncWorldEvent(1035, pos, 0);
    }

    

    private void resetProgress() {
        this.progress=0;
    }



    private void increaseCraftProgress() {
        progress++;
    }


    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt,inventory,registryLookup);
        nbt.putInt("beer_brewing_stand.progress",progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt,inventory,registryLookup);
        progress = nbt.getInt("beer_brewing_stand.progress");

    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Beer Brewing Stand");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new BeerBrewingStandScreenHandler(syncId,playerInventory,this,this.propertyDelegate);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return this.isValid(slot, stack);
    }

    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return slot == 3 ? stack.isOf(ModBlocks.EMPTY_BEER_CUP.asItem()) : true;
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
