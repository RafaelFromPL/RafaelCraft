package com.rafael.rafaelcraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EnderBeastEntity extends MobEntity
{

    public EnderBeastEntity(EntityType<? extends MobEntity> p_i48576_1_, World p_i48576_2_)
    {
        super(p_i48576_1_, p_i48576_2_);
    }

    public static AttributeModifierMap.MutableAttribute setAttributes()
    {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 100)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3f)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 10f);
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();

        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8));
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
}
