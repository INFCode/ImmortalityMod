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
