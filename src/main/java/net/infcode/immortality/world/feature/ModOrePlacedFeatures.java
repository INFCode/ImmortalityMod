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

import net.infcode.immortality.mixin.OrePlacedFeaturesInvoker;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModOrePlacedFeatures {
    public static final RegistryEntry<PlacedFeature> ORE_JADE = PlacedFeatures.register("ore_jade",
        ModOreConfiguredFeatures.ORE_JADE, OrePlacedFeaturesInvoker.invokeModifiersWithCount(2,
            HeightRangePlacementModifier.trapezoid(YOffset.fixed(-32), YOffset.fixed(32))));
    public static final RegistryEntry<PlacedFeature> ORE_JADE_BURIED = PlacedFeatures.register(
        "ore_jade_buried", ModOreConfiguredFeatures.ORE_JADE_BURIED, OrePlacedFeaturesInvoker.invokeModifiersWithCount(4,
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));
}
