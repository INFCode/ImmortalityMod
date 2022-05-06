/**
 * This file is imported from <a href="https://github.com/KosmX/RPG-Hud">https://github.com/KosmX/RPG-Hud</a>
 * and is subject to some modifications and simplifications to suit in this project. The original
 * code is under CC0 license, which can be found in ALTERNATE_LICENSE under the project directory.
 */

package net.infcode.immortality.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.infcode.immortality.gui.elements.HudElement;
import net.infcode.immortality.gui.elements.HudElementDebug;
import net.infcode.immortality.gui.elements.HudElementType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.util.HashMap;
import java.util.Map;

/**
 * This is originally from <a href="https://github.com/KosmX/RPG-Hud">https://github.com/KosmX/RPG-Hud</a>,
 * simplified for project use.
 */

@Environment(EnvType.CLIENT)
public class Hud {

    /**
     * Hud key for registering
     */
    private final String hudKey;

    /**
     * Hud name for display in settings
     */
    private final String hudName;

    protected Map<HudElementType, HudElement> elements = new HashMap<>();

    /**
     * Minecraft instance
     */
    protected MinecraftClient mc;

    public Hud(MinecraftClient mc, String hudKey, String hudName) {
        this.mc = mc;
        this.hudKey = hudKey;
        this.hudName = hudName;
        this.setElements();
    }

    /**
     * Function to register all elements to this HUD.<br>
     * Has to be run in order for this HUD to function properly
     */
    public void setElements() {
        this.elements.put(HudElementType.DEBUG, setElementDebug());
    }

    /**
     * get the key (String) of this HUD
     */
    public String getHudKey() {
        return this.hudKey;
    }

    /**
     * get the name of this HUD
     */
    public String getHudName() {
        return this.hudName;
    }

    protected HudElement setElementDebug() {
        return new HudElementDebug();
    }

    /**
     * Draws an element of the HudElementType type on the screen
     *
     * @param type The type of the Element
     * @param gui The gui to draw on
     * @param zLevel The zLevel to draw at
     * @param partialTicks The partialTicks for animations
     */
    public void drawElement(HudElementType type, DrawableHelper gui, MatrixStack ms, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        this.elements.get(type).draw(gui, ms, zLevel, partialTicks, scaledWidth, scaledHeight);
    }

    /**
     * Checks whether the element of the specified type should be rendered
     *
     * @param type The HudElementType to get checked
     * @return true if it should be rendered, false if not
     */
    public boolean checkElementConditions(HudElementType type) {
        return this.elements.get(type).checkConditions();
    }

    public boolean isVanillaElement(HudElementType type) {
        return this.elements.get(type) == null;
    }
}
