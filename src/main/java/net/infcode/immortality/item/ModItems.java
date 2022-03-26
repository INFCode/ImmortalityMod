package net.infcode.immortality.item;

import net.infcode.immortality.ImmortalityMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ImmortalityMod.MODID, name), item);
    }

    public static void registerModItems() {
        ImmortalityMod.LOGGER.info("Registering mod items for " + ImmortalityMod.MODID + "...");
    }
}
