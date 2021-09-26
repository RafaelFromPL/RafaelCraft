package com.rafael.rafaelcraft.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup
{
    
    public static final ItemGroup RAFAELCRAFT_GROUP = new ItemGroup("rafaelCraftTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.ENDERITE_INGOT.get());
        }
    };

}
