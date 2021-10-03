package com.rafael.rafaelcraft.entity;


import com.rafael.rafaelcraft.RafaelCraft;
import com.rafael.rafaelcraft.entity.model.EnderBeastEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EnderBeastEntityRenderer extends MobRenderer<EnderBeastEntity, EnderBeastEntityModel<EnderBeastEntity>>
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(RafaelCraft.MOD_ID, "textures/entity/ender_beast/ender_beast.png");

    public EnderBeastEntityRenderer(EntityRendererManager manager)
    {
        super(manager, new EnderBeastEntityModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(EnderBeastEntity entity)
    {
        return null;
    }
}
