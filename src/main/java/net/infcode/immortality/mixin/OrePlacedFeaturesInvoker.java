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

package net.infcode.immortality.mixin;

import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(OrePlacedFeatures.class)
public interface OrePlacedFeaturesInvoker {
    @Invoker("modifiers")
    static List<PlacementModifier> invokeModifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        throw new AssertionError("Invoker of OrePlacedFeatures#modifiers fails.");
    }

    @Invoker("modifiersWithCount")
    static List<PlacementModifier> invokeModifiersWithCount(int count, PlacementModifier heightModifier) {
        throw new AssertionError("Invoker of OrePlacedFeatures#modifiersWithCount fails.");
    }

    @Invoker("modifiersWithRarity")
    static List<PlacementModifier> invokeModifiersWithRarity(int chance, PlacementModifier heightModifier) {
        throw new AssertionError("Invoker of OrePlacedFeatures#modifiersWithRarity fails.");
    }
}
