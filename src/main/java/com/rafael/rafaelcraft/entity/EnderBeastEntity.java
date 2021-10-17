package com.rafael.rafaelcraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EnderBeastEntity extends RavagerEntity
{

    public EnderBeastEntity(EntityType<? extends RavagerEntity> p_i48576_1_, World p_i48576_2_)
    {
        super(p_i48576_1_, p_i48576_2_);
    }

    public static AttributeModifierMap.MutableAttribute setAttributes()
    {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 150)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.1f)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 20f)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1);
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();

        //this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 30));
        //this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1));
        //this.goalSelector.addGoal(50, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity p_70693_1_)
    {
        return 10;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_ENDERMAN_DEATH;
    }

    @Override
    protected float getSpeedFactor()
    {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_ENDERMAN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_ENDERMAN_HURT;
    }
}
