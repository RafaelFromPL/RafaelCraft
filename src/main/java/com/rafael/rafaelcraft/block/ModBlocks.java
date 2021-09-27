package com.rafael.rafaelcraft.block;

import java.util.function.Supplier;

import com.rafael.rafaelcraft.RafaelCraft;

import com.rafael.rafaelcraft.block.custom.NetheriteFurnaceBlock;
import com.rafael.rafaelcraft.item.ModItemGroup;
import com.rafael.rafaelcraft.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks
{
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RafaelCraft.MOD_ID);

    public static final RegistryObject<Block> ENDERITE_ORE = registerBlock("enderite_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool()
                    .hardnessAndResistance(40f, 1200f)), false);

    public static final RegistryObject<Block> ENDERITE_BLOCK = registerBlock("enderite_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool()
                    .hardnessAndResistance(50f, 1200f).sound(SoundType.NETHERITE)), true);

    public static final RegistryObject<Block> NETHERITE_FURNACE = registerBlock("netherite_furnace",
            () -> new NetheriteFurnaceBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool()
                    .hardnessAndResistance(30f, 1200f).sound(SoundType.NETHERITE)), true);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean immuneToFire)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        if(immuneToFire)
        {
            registerBlockItemWithFireImmunity(name, toReturn);
        }
        else
        {
            registerBlockItem(name, toReturn);
        }

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP)));
    }

    private static <T extends Block> void registerBlockItemWithFireImmunity(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.RAFAELCRAFT_GROUP).isImmuneToFire()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
