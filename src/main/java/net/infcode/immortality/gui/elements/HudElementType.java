/**
 * This file is imported from <a href="https://github.com/KosmX/RPG-Hud">https://github.com/KosmX/RPG-Hud</a>
 * and is subject to some modifications and simplifications to suit in this project. The original
 * code is under CC0 license, which can be found in ALTERNATE_LICENSE.txt under the project directory.
 */

package net.infcode.immortality.gui.elements;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resource.language.I18n;

/**
 * This is originally from <a href="https://github.com/KosmX/RPG-Hud">https://github.com/KosmX/RPG-Hud</a>,
 * simplified for project use.
 */
@Environment(EnvType.CLIENT)
public enum HudElementType {
    TIME("gui.hud.immortality.time"),
    DEBUG("gui.hud.immortality.debug");

    private final String displayName;

    HudElementType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return I18n.translate(this.displayName);
    }
}
