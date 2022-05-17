/**
 * This file is imported from <a href="https://github.com/KosmX/RPG-Hud">https://github.com/KosmX/RPG-Hud</a>
 * and is subject to some modifications and simplifications to suit in this project. The original
 * code is under CC0 license, which can be found in ALTERNATE_LICENSE.txt under the project directory.
 */

package net.infcode.immortality.gui.elements;

import com.mojang.blaze3d.systems.RenderSystem;
import net.infcode.immortality.item.ModItems;
import net.infcode.immortality.power.IPowerComponent;
import net.infcode.immortality.power.PowerTypes;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public class HudElementDebug extends HudElement {
    public HudElementDebug() {
        super(HudElementType.DEBUG, 0, 0, 0, 0, true);
    }

    @Override
    public boolean checkConditions() {
        return super.checkConditions()
                   && !this.mc.options.debugEnabled
                   && this.mc.player.getInventory().contains(new ItemStack(ModItems.JADE));
    }

    @Override
    public void drawElement(DrawableHelper gui, MatrixStack ms, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        int powerColor = getPowerColor();
        String powerInfo = getPower() + '(' + getPowerTypeName() + ')';
        DrawableHelper.drawStringWithShadow(ms, this.mc.textRenderer, powerInfo, 4, 72, powerColor);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public String getPower() {
        return String.valueOf(IPowerComponent.getFrom(this.mc.player).getAmount());
    }

    public String getPowerTypeName() {
        return IPowerComponent.getFrom(this.mc.player).getType().getName();
    }

    public int getPowerColor() {
        PowerTypes type = IPowerComponent.getFrom(this.mc.player).getType();

        switch (type) {
            case NONE -> {
                return 0x606060;
            }
            case METAL -> {
                return 0xFFDD11;
            }
            case WOOD -> {
                return 0x009900;
            }
            case WATER -> {
                return 0x3399FF;
            }
            case FIRE -> {
                return 0xFF0000;
            }
            case EARTH -> {
                return 0x997722;
            }
        }
        return 0;
    }

}