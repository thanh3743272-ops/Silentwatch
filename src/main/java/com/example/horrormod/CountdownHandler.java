package com.example.horrormod;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CountdownHandler {

    // 3 Minecraft days = 3 * 24000 ticks = 72000 ticks (~60 real-life minutes)
    private static final long COUNTDOWN_TICKS = 3L * 24000L;

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (event.world.isRemote) return;
        if (!(event.world instanceof ServerWorld)) return;

        ServerWorld world = (ServerWorld) event.world;

        // Only count using the overworld's clock so the timer isn't
        // advanced multiple times per tick across different dimensions.
        if (!world.getDimensionKey().equals(World.OVERWORLD)) return;

        DimensionSavedDataManager storage = world.getSavedData();
        CountdownData data = storage.getOrCreate(CountdownData::new, CountdownData.getDataName());

        if (data.isTriggered()) return;

        data.incrementTicks();

        if (data.getTicksElapsed() >= COUNTDOWN_TICKS) {
            data.setTriggered(true);
            triggerHorrorEvent(world);
        }
    }

    private void triggerHorrorEvent(ServerWorld world) {
        StringTextComponent message = new StringTextComponent("YOU ARE NO LONGER SAFE");
        message.mergeStyle(TextFormatting.RED, TextFormatting.BOLD);

        for (ServerPlayerEntity player : world.getServer().getPlayerList().getPlayers()) {
            player.sendMessage(message, player.getUniqueID());
            player.playSound(ModSounds.HORROR_STING, SoundCategory.MASTER, 1.0F, 1.0F);
        }
    }
}
