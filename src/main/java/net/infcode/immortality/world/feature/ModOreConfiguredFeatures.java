/*
 * This file is part of ImmortalityMod, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022 infcode
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
