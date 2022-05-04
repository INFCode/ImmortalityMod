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

package net.infcode.immortality.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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
public abstract class Hud {

	/** Hud key for registering */
	private final String hudKey;

	/** Hud name for display in settings */
	private final String hudName;

	protected Map<HudElementType, HudElement> elements = new HashMap<>();

	/** Minecraft instance */
	protected MinecraftClient mc;

	public int chatOffset = 0;
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

	/** get the key (String) of this HUD */
	public String getHudKey() {
		return this.hudKey;
	}

	/** get the name of this HUD */
	public String getHudName() {
		return this.hudName;
	}

    protected abstract HudElement setElementDebug();
	/**
	 * Draws an element of the HudElementType type on the screen
	 * 
	 * @param type
	 *            The type of the Element
	 * @param gui
	 *            The gui to draw on
	 * @param zLevel
	 *            The zLevel to draw at
	 * @param partialTicks
	 *            The partialTicks for animations
	 */
	public void drawElement(HudElementType type, DrawableHelper gui, MatrixStack ms, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
		this.elements.get(type).draw(gui, ms, zLevel, partialTicks, scaledWidth, scaledHeight);
	}

	/**
	 * Checks whether the element of the specified type should be rendered
	 * 
	 * @param type
	 *            The HudElementType to get checked
	 * @return true if it should be rendered, false if not
	 */
	public boolean checkElementConditions(HudElementType type) {
		return this.elements.get(type).checkConditions();
	}
	
	public boolean isVanillaElement(HudElementType type) {
	    return this.elements.get(type) == null;
	}
}
