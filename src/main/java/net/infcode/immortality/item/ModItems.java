package net.infcode.immortality.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.infcode.immortality.ImmortalityMod;
import net.infcode.immortality.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item ALCHEMY_FRUIT = registerItem("alchemy_fruit",
        new AliasedBlockItem(ModBlocks.ALCHEMY_BUSH,
            new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item JADE = registerItem("jade",
        new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ImmortalityMod.MODID, name), item);
    }

    public static void registerModItems() {
        ImmortalityMod.LOGGER.info("Registering mod items for " + ImmortalityMod.MODID + "...");
    }
}
