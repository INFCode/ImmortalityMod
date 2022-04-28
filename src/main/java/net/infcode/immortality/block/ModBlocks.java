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

package net.infcode.immortality.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.infcode.immortality.ImmortalityMod;
import net.infcode.immortality.item.ModItemGroups;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

@SuppressWarnings({"unused"})
public class ModBlocks {
    public static final Block ALCHEMY_BUSH = registerBlock("alchemy_bush",
        new AlchemyBushBlock(FabricBlockSettings.copy(Blocks.SWEET_BERRY_BUSH).nonOpaque()));

    public static final Block JADE_ORE = registerBlockWithItem("jade_ore",
        new OreBlock(AbstractBlock.Settings.of(Material.STONE).requiresTool()
            .strength(3.0f, 3.0f), UniformIntProvider.create(0, 2)),
        ModItemGroups.IMMORTALITY_GROUP);

    public static final Block DEEPSLATE_JADE_ORE = registerBlockWithItem("deepslate_jade_ore",
        new OreBlock(AbstractBlock.Settings.copy(JADE_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
            .strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(0, 2)),
        ModItemGroups.IMMORTALITY_GROUP);

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(ImmortalityMod.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(ImmortalityMod.MODID, name),
            new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static Block registerBlockWithItem(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return registerBlock(name, block);
    }

    public static void registerModBlocks() {
        ImmortalityMod.LOGGER.info("Registering mod blocks for " + ImmortalityMod.MODID + "...");
    }
}
