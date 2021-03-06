package com.rafael.rafaelcraft.util;

import com.rafael.rafaelcraft.RafaelCraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class RafaelCraftTags
{
    public static class Blocks
    {

        private static Tags.IOptionalNamedTag<Block> createTag(String name)
        {
            return BlockTags.createOptional(new ResourceLocation(RafaelCraft.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> createForgeTag(String name)
        {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }

    }

    public static class Items
    {

        private static Tags.IOptionalNamedTag<Item> createTag(String name)
        {
            return ItemTags.createOptional(new ResourceLocation(RafaelCraft.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name)
        {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }

    }

}
