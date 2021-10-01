package com.rafael.rafaelcraft.tileentity;

import com.rafael.rafaelcraft.block.ModBlocks;
import com.rafael.rafaelcraft.block.custom.NetheriteFurnaceBlock;
import com.rafael.rafaelcraft.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class NetheriteFurnaceTile extends TileEntity implements ITickableTileEntity
{

    int Counter = 0;

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public NetheriteFurnaceTile(TileEntityType<?> tileEntityTypeIn)
    {
        super(tileEntityTypeIn);
    }

    public NetheriteFurnaceTile()
    {
        this(ModTileEntities.NETHERITE_FURNACE_TILE.get());
    }


    @Override
    public void read(BlockState state, CompoundNBT nbt)
    {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler()
    {
        return new ItemStackHandler(3)
        {
            @Override
            protected void onContentsChanged(int slot)
            {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack)
            {

                switch (slot)
                {
                    case 0: return stack.getItem() == ModBlocks.ENDERITE_ORE.get().asItem();
                    case 1: return stack.getItem() == Items.LAVA_BUCKET || stack.getItem() == Items.BUCKET;
                    case 2: return stack.getItem() == ModItems.ENDERITE_SCRAP.get();
                    default:
                        return false;
                }
            }


            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
            {

                if(!isItemValid(slot, stack))
                {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
    {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }

    public void Smelt()
    {
        boolean hasOreInFirstSlot = this.itemHandler.getStackInSlot(0).getCount() > 0
                && this.itemHandler.getStackInSlot(0).getItem() == ModBlocks.ENDERITE_ORE.get().asItem();
        boolean hasLavaInSecondSlot = this.itemHandler.getStackInSlot(1).getCount() > 0
                && this.itemHandler.getStackInSlot(1).getItem() == Items.LAVA_BUCKET;

        if(hasOreInFirstSlot && hasLavaInSecondSlot)
        {

            this.itemHandler.getStackInSlot(0).shrink(1);
            this.itemHandler.getStackInSlot(1).shrink(1);

            this.itemHandler.insertItem(1, new ItemStack(Items.BUCKET), false);
            this.itemHandler.insertItem(2, new ItemStack(ModItems.ENDERITE_SCRAP.get()), false);
        }
    }

    public boolean hasFuel()
    {
        boolean hasFuel = this.itemHandler.getStackInSlot(1).getCount() > 0
            && this.itemHandler.getStackInSlot(1).getItem() == Items.LAVA_BUCKET;

        return hasFuel;
    }

    Random random = new Random();
    int counter = 0;
    int randomizer;

    @Override
    public void tick()
    {

        counter++;
        if(counter > 200)
        {
            randomizer = random.nextInt(4);
            if(randomizer == 0)
            {
                if(!this.world.isRemote && this.world.isThundering()) {
                    EntityType.LIGHTNING_BOLT.spawn(((ServerWorld) this.world), null, null, pos, SpawnReason.TRIGGERED, true, true);
                }
                if(!this.world.isRemote()) {
                    Smelt();
                }
            }
            counter = 0;
        }

        this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(NetheriteFurnaceBlock.LIT, Boolean.valueOf(this.hasFuel())), 3);
    }
}
