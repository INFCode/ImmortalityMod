package net.infcode.immortality.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.infcode.immortality.ImmortalityMod;
import net.infcode.immortality.item.ModItemGroups;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
