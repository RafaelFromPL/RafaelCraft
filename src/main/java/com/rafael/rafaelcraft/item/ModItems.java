package com.rafael.rafaelcraft.item;

import com.rafael.rafaelcraft.RafaelCraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RafaelCraft.MOD_ID);

    public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap",
            () -> new Item(new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));

    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot",
    () -> new Item(new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));

    //atak -1
    //szybkość -4

    public static final RegistryObject<Item> ENDERITE_SWORD = ITEMS.register("enderite_sword",
            () -> new SwordItem(ModItemTier.ENDERITE_INGOT, 8, -2.4f,
                new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire())
            {
                public boolean hitEntity(ItemStack stack, LivingEntity hitEntity, LivingEntity attackingEntity)
                {
                    hitEntity.addPotionEffect(new EffectInstance(Effects.WITHER, 100, 2));
                    return true;
                }
            }
    );

    public static final RegistryObject<Item> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe",
            () -> new PickaxeItem(ModItemTier.ENDERITE_INGOT, 6, -2.8f,
                    new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));

    public static final RegistryObject<Item> ENDERITE_AXE = ITEMS.register("enderite_axe",
            () -> new AxeItem(ModItemTier.ENDERITE_INGOT, 10, -3f,
                    new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));

    public static final RegistryObject<Item> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel",
            () -> new ShovelItem(ModItemTier.ENDERITE_INGOT, 6.5f, -3f,
                    new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));

    public static final RegistryObject<Item> ENDERITE_HOE = ITEMS.register("enderite_hoe",
            () -> new HoeItem(ModItemTier.ENDERITE_INGOT, 0, 0f,
                    new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));


    public static final RegistryObject<Item> ENDERITE_HELMET = ITEMS.register("enderite_helmet",
            () -> new ModArmorItem(ModArmorMaterial.ENDERITE_INGOT, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));

    public static final RegistryObject<Item> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate",
            () -> new ArmorItem(ModArmorMaterial.ENDERITE_INGOT, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));

    public static final RegistryObject<Item> ENDERITE_LEGGINS = ITEMS.register("enderite_leggins",
            () -> new ArmorItem(ModArmorMaterial.ENDERITE_INGOT, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));

    public static final RegistryObject<Item> ENDERITE_BOOTS = ITEMS.register("enderite_boots",
            () -> new ArmorItem(ModArmorMaterial.ENDERITE_INGOT, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));








    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }


}
