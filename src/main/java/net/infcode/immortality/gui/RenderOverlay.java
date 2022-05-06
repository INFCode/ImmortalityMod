/**
 * This file is imported from <a href="https://github.com/KosmX/RPG-Hud">https://github.com/KosmX/RPG-Hud</a>
 * and is subject to some modifications and simplifications to suit in this project. The original
 * code is under CC0 license, which can be found in ALTERNATE_LICENSE under the project directory.
 */

package net.infcode.immortality.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.infcode.immortality.gui.elements.HudElementType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

/**
 * This is originally from <a href="https://github.com/KosmX/RPG-Hud">https://github.com/KosmX/RPG-Hud</a>,
 * simplified for project use.
 */
@Environment(EnvType.CLIENT)
public class RenderOverlay implements HudRenderCallback {

    private final Hud hud;
    private final MinecraftClient mc;

    public RenderOverlay() {
        this.hud = new Hud(MinecraftClient.getInstance(), "default", "Default Hud");
        this.mc = MinecraftClient.getInstance();
        HudRenderCallback.EVENT.register(this);
    }

    /**
     * Draw the specified HudElement of the HudElementType from the active Hud
     *
     * @param type the HudElementType to be rendered
     * @param partialTicks the partialTicks to be used for animations
     */
    private void drawElement(HudElementType type, MatrixStack ms, float partialTicks) {

        if (this.hud.checkElementConditions(type)) {
            if (!preventElementRenderType(type)) {
                bind(DrawableHelper.GUI_ICONS_TEXTURE);
                ms.push();
                RenderSystem.enableBlend();
                this.hud.drawElement(type, this.mc.inGameHud, ms, partialTicks, partialTicks, this.mc.getWindow().getScaledWidth(),
                    this.mc.getWindow().getScaledHeight());
                ms.pop();
            }

        }
    }

    /**
     * Checks if the HudElementType has a setting to prevent it's rendering and if
     * it is activated
     */
    private boolean preventElementRenderType(HudElementType type) {
        return false;
    }

    public static boolean shouldRenderVanilla(HudElementType type) {
        return isVanillaElement(type) || forceRenderTypeVanilla(type);
    }

    /**
     * Checks if the HudElementType has a setting to force the vanilla hud element
     * to be rendered and if it is activated
     */
    public static boolean forceRenderTypeVanilla(HudElementType type) {
        return false;
    }

    private void bind(Identifier res) {
        mc.getTextureManager().bindTexture(res);
    }

    public static boolean isVanillaElement(HudElementType type) {
        return false;
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        this.drawElement(HudElementType.DEBUG, matrixStack, tickDelta);
    }
}
