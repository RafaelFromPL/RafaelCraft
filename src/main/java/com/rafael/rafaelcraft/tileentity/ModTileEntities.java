package com.rafael.rafaelcraft.tileentity;

import com.rafael.rafaelcraft.RafaelCraft;
import com.rafael.rafaelcraft.block.ModBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities
{
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RafaelCraft.MOD_ID);

    public static RegistryObject<TileEntityType<NetheriteFurnaceTile>> NETHERITE_FURNACE_TILE = TILE_ENTITIES.register("netherite_furnace_tile",
            () -> TileEntityType.Builder.create(NetheriteFurnaceTile::new, ModBlocks.NETHERITE_FURNACE.get()).build(null));


    public static void register(IEventBus eventBus)
    {
        TILE_ENTITIES.register(eventBus);
    }

}
