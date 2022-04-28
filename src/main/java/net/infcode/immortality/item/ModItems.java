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

package net.infcode.immortality.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.infcode.immortality.ImmortalityMod;
import net.infcode.immortality.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings({"unused"})
public class ModItems {
    public static final Item ALCHEMY_FRUIT = registerItem("alchemy_fruit",
        new AliasedBlockItem(ModBlocks.ALCHEMY_BUSH,
            new FabricItemSettings().group(ModItemGroups.IMMORTALITY_GROUP).food(
                new FoodComponent.Builder().hunger(2).alwaysEdible().build())));

    public static final Item JADE = registerItem("jade",
        new Item(new FabricItemSettings().group(ModItemGroups.IMMORTALITY_GROUP)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ImmortalityMod.MODID, name), item);
    }

    public static void registerModItems() {
        ImmortalityMod.LOGGER.info("Registering mod items for " + ImmortalityMod.MODID + "...");
    }
}
