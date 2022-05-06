/**
 * This file is imported from <a href="https://github.com/KosmX/RPG-Hud">https://github.com/KosmX/RPG-Hud</a>
 * and is subject to some modifications and simplifications to suit in this project. The original
 * code is under CC0 license, which can be found in ALTERNATE_LICENSE under the project directory.
 */

package net.infcode.immortality.gui.elements;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class HudElementDebug extends HudElement {
    public HudElementDebug() {
        super(HudElementType.DEBUG, 0, 0, 0, 0, true);
    }

    @Override
    public boolean checkConditions() {
        return super.checkConditions()
                   && !this.mc.options.debugEnabled
                   && this.mc.player.getInventory().contains(new ItemStack(Items.CLOCK));
    }

    @Override
    public void drawElement(DrawableHelper gui, MatrixStack ms, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        int clockColor = getClockColor();
        DrawableHelper.drawStringWithShadow(ms, this.mc.textRenderer, getTime(), 4, 52, clockColor);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Returns the time of the minecraft world as a String
     */
    public String getTime() {
        long time = this.mc.player.world.getTimeOfDay();
        long day = this.mc.player.world.getTimeOfDay() / 24000L;
        long currentTime = time - (24000L * day);
        long currentHour = (currentTime / 1000L) + 6L;
        double currentTimeMin = currentTime - ((currentHour - 6L) * 1000L);
        currentTimeMin = currentTimeMin / (1000.0D / 60.0D);
        int currentMin = (int) currentTimeMin;
        if (currentHour > 24)
            currentHour -= 24L;
        return get24HourTimeForString(currentHour, currentMin);
    }

    /**
     * Formats the parameter time into the 24 hour format and returns it as a
     * String
     *
     * @param currentHour the hour
     * @param currentMin the minute
     */
    public static String get24HourTimeForString(long currentHour, long currentMin) {
        StringBuilder sb = new StringBuilder();
        if (currentHour == 24)
            currentHour = 0;
        if (currentHour < 10)
            sb.append("0");
        sb.append(currentHour);
        return sb + ":" + getMinuteForString(currentMin);
    }

    /**
     * Formats the parameter time into the 12 hour format and returns it as a
     * string
     *
     * @param currentHour the hour
     * @param currentMin the minute
     */
    public static String get12HourTimeForString(long currentHour, long currentMin) {
        StringBuilder sb = new StringBuilder();
        String period = "am";
        if (currentHour == 12) {
            period = "pm";
        }
        if (currentHour == 24) {
            currentHour = 12;
            period = "am";
        }
        if (currentHour > 12) {
            currentHour -= 12;
            period = "pm";
        }
        if (currentHour < 10)
            sb.append(0);
        sb.append(currentHour);
        return sb + ":" + getMinuteForString(currentMin) + " " + period;
    }

    /**
     * Transforms the minute into a two digit String
     *
     * @param currentMin the minute
     */
    public static String getMinuteForString(long currentMin) {
        StringBuilder sb = new StringBuilder();
        if (currentMin < 10)
            sb.append("0");
        sb.append(currentMin);
        return sb.toString();
    }

    public int getClockColor() {
        long time = this.mc.player.world.getTimeOfDay();
        long day = this.mc.player.world.getTimeOfDay() / 24000L;
        long currentTime = time - (24000L * day);
        if (currentTime < 1000)
            return 0xFFAF00;
        else if (currentTime < 6000)
            return 0xFFAF00;
        else if (currentTime < 11000)
            return 0xFFCF00;
        else if (currentTime < 12000)
            return 0xFFAF00;
        else if (currentTime < 13000)
            return 0xFFA200;
        else if (currentTime < 13500)
            return 0xE36E21;
        else if (currentTime < 18000)
            return 0x345D74;
        else if (currentTime < 21000)
            return 0x1F3847;
        else if (currentTime < 22250)
            return 0x345D74;
        else if (currentTime < 22500)
            return 0x775D74;
        else if (currentTime < 23000)
            return 0xE36E21;
        else
            return 0xFFA200;
    }

}