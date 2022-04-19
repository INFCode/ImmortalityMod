package net.infcode.immortality.world.feature;

import net.infcode.immortality.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;


public class ModOreConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> JADE_ORES =
        overworldOreConfig(ModBlocks.JADE_ORE, ModBlocks.DEEPSLATE_JADE_ORE);

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_JADE =
        ConfiguredFeatures.register("ore_jade", Feature.ORE, new OreFeatureConfig(JADE_ORES, 7));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_JADE_BURIED =
        ConfiguredFeatures.register("ore_jade_buried", Feature.ORE, new OreFeatureConfig(JADE_ORES,
            7, 1.0f));

    private static List<OreFeatureConfig.Target> overworldOreConfig(Block normalOre, Block deepslateOre) {
        return List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                normalOre.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                deepslateOre.getDefaultState()));
    }
}
