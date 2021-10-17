package com.rafael.rafaelcraft.event;

import com.rafael.rafaelcraft.RafaelCraft;
import com.rafael.rafaelcraft.entity.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RafaelCraft.MOD_ID)
public class ModEntityEvents
{
    @SubscribeEvent
    public static void onBiomeLoad(final BiomeLoadingEvent event)
    {
        if(event.getName() == null)
        {
            return;
        }
        MobSpawnInfoBuilder spawns = event.getSpawns();

        if(event.getName().toString().equals(Biomes.END_HIGHLANDS.getLocation().toString()))
        {
            spawns.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(ModEntityTypes.ENDER_BEAST.get(), 1, 0, 1));
        }

    }

}
