package com.rafael.rafaelcraft.world.gen;

import com.rafael.rafaelcraft.world.structure.ModStructures;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;


public class ModStructureGeneration
{
    public static void generateStructures(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);


        if(((Set<?>) types).contains(BiomeDictionary.Type.PLAINS)) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(((Set<?>) types).contains(BiomeDictionary.Type.SNOWY)) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }
        if(((Set<?>) types).contains(BiomeDictionary.Type.FOREST)) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.TOWER.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }


        if (event.getName().equals(Biomes.END_HIGHLANDS.getLocation()))
        {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.ENDERITE_VEIN.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }


        if(((Set<?>) types).contains(BiomeDictionary.Type.PLAINS)) {
            List<Supplier<StructureFeature<?, ?>>> structures = event.getGeneration().getStructures();

            structures.add(() -> ModStructures.CASTLE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        }

    }
}
