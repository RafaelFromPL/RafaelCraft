package com.rafael.rafaelcraft.container;

import com.rafael.rafaelcraft.RafaelCraft;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers
{
    public static DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, RafaelCraft.MOD_ID);

    public static final RegistryObject<ContainerType<NetheriteFurnaceContainer>> NETHERITE_FURNACE_CONTAINER = CONTAINERS.register("netherite_furnace_container",
            () -> IForgeContainerType.create(((windowId, inv, data) ->
            {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new NetheriteFurnaceContainer(windowId, world, pos, inv, inv.player);
            })));

    public static void register(IEventBus eventBus)
    {
        CONTAINERS.register(eventBus);
    }
}
