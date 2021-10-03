package com.rafael.rafaelcraft.entity;

import com.rafael.rafaelcraft.RafaelCraft;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, RafaelCraft.MOD_ID);

    public static RegistryObject<EntityType<EnderBeastEntity>> ENDER_BEAST = ENTITY_TYPES.register("ender_beast",
            () -> EntityType.Builder.create(EnderBeastEntity::new, EntityClassification.MONSTER).size(1f, 1f)
                    .build(new ResourceLocation(RafaelCraft.MOD_ID, "ender_beast").toString()));
}
