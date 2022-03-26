package net.infcode.immortality.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.infcode.immortality.ImmortalityMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(ImmortalityMod.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(ImmortalityMod.MODID, name),
            new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        ImmortalityMod.LOGGER.info("Registering mod blocks for " + ImmortalityMod.MODID + "...");
    }
}
