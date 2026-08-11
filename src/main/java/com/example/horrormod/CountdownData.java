package com.example.horrormod;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

/**
 * Persistent data saved with the world that tracks how many ticks
 * have passed since the world was created, and whether the horror
 * event has already fired.
 */
public class CountdownData extends WorldSavedData {

    private static final String DATA_NAME = HorrorMod.MODID + "_countdown";

    private long ticksElapsed = 0L;
    private boolean triggered = false;

    public CountdownData() {
        super(DATA_NAME);
    }

    public static String getDataName() {
        return DATA_NAME;
    }

    public long getTicksElapsed() {
        return ticksElapsed;
    }

    public void incrementTicks() {
        this.ticksElapsed++;
        this.markDirty();
    }

    public boolean isTriggered() {
        return triggered;
    }

    public void setTriggered(boolean triggered) {
        this.triggered = triggered;
        this.markDirty();
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.ticksElapsed = nbt.getLong("ticksElapsed");
        this.triggered = nbt.getBoolean("triggered");
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putLong("ticksElapsed", ticksElapsed);
        nbt.putBoolean("triggered", triggered);
        return nbt;
    }
}
