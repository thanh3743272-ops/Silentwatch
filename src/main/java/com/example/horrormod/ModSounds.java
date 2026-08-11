package com.example.horrormod;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HorrorMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSounds {

    public static SoundEvent HORROR_STING;

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        ResourceLocation id = new ResourceLocation(HorrorMod.MODID, "horror_sting");
        HORROR_STING = new SoundEvent(id).setRegistryName(id);
        event.getRegistry().register(HORROR_STING);
    }
}
