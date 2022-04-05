package net.infcode.immortality;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.infcode.immortality.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class ImmortalityClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ImmortalityMod.LOGGER.info("Registering rendering settings for " + ImmortalityMod.MODID +
                                       "...");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALCHEMY_BUSH, RenderLayer.getCutout());
    }
}
