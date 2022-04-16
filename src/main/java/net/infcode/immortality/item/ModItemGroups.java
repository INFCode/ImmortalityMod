package net.infcode.immortality.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public final class ModItemGroups {
    public static final ItemGroup IMMORTALITY_GROUP =
        FabricItemGroupBuilder.build(new Identifier("immortallity", "items"),
            () -> new ItemStack(ModItems.ALCHEMY_FRUIT));
}
