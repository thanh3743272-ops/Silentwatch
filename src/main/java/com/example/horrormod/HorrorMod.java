package com.example.horrormod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(HorrorMod.MODID)
public class HorrorMod {

    public static final String MODID = "horrormod";

    public HorrorMod() {
        // Register the tick / countdown handler on the Forge event bus
        MinecraftForge.EVENT_BUS.register(new CountdownHandler());
    }
}
