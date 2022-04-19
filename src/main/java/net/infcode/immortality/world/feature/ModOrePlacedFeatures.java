package net.infcode.immortality.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModOrePlacedFeatures {
    public static final RegistryEntry<PlacedFeature> ORE_JADE = PlacedFeatures.register("ore_jade",
        ModOreConfiguredFeatures.ORE_JADE, modifiersWithCount(2,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-32), YOffset.fixed(32))));
    public static final RegistryEntry<PlacedFeature> ORE_JADE_BURIED = PlacedFeatures.register(
        "ore_jade_buried", ModOreConfiguredFeatures.ORE_JADE_BURIED, modifiersWithCount(4,
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));

    /* Directly copied from OrePlacedFeatures#modifiers */
    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    /* Directly copied from OrePlacedFeatures#modifiersWithCount */
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    /* Directly copied from OrePlacedFeatures#modifiersWithRarity */
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
