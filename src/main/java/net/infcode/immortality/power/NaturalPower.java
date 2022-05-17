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

package net.infcode.immortality.power;

import net.minecraft.nbt.NbtCompound;

public class NaturalPower implements IPowerComponent {
    private int amount;
    private PowerTypes type;

    public NaturalPower(int amount, PowerTypes type) {
        this.amount = amount;
        this.type = type;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public PowerTypes getType() {
        return type;
    }

    @Override
    public NaturalPower setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public NaturalPower setType(PowerTypes type) {
        this.type = type;
        return this;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.amount = tag.getInt("amount");
        this.type = PowerTypes.valueOf(tag.getString("type"));
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("amount", this.amount);
        tag.putString("type", this.type.name());
    }
}
