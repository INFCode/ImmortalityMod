package net.infcode.immortality.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.infcode.immortality.world.feature.ModOrePlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModWorldGen {
    public static void setWorldGen() {
        generateOres();
    }

    private static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_JADE.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_JADE_BURIED.getKey().get());
    }
}
