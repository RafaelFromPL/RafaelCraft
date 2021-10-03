package com.rafael.rafaelcraft.util;

import com.rafael.rafaelcraft.RafaelCraft;
import com.rafael.rafaelcraft.entity.EnderBeastEntityRenderer;
import com.rafael.rafaelcraft.entity.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RafaelCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENDER_BEAST.get(), EnderBeastEntityRenderer::new);
    }
}
