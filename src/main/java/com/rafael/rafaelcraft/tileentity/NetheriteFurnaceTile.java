package com.rafael.rafaelcraft.tileentity;

import com.rafael.rafaelcraft.block.ModBlocks;
import com.rafael.rafaelcraft.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NetheriteFurnaceTile extends TileEntity
{

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
                    case 1: return stack.getItem() == Items.LAVA_BUCKET;
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

        }

        return super.getCapability(cap, side);
    }

    public void Smelt()
    {
        boolean hasOreInFirstSlot = this.itemHandler.getStackInSlot(0).getCount() > 0
                && this.itemHandler.getStackInSlot(0).getItem() == ModBlocks.ENDERITE_ORE.get().asItem();
        boolean hasLavaInSecondSlot = this.itemHandler.getStackInSlot(1).getCount() > 0
                && this.itemHandler.getStackInSlot(0).getItem() == Items.LAVA_BUCKET;

        if(hasOreInFirstSlot && hasLavaInSecondSlot)
        {
            this.itemHandler.getStackInSlot(0).shrink(1);
            this.itemHandler.getStackInSlot(1).shrink(1);

            this.itemHandler.insertItem(2, new ItemStack(ModItems.ENDERITE_SCRAP.get()), false);
        }
    }

}
