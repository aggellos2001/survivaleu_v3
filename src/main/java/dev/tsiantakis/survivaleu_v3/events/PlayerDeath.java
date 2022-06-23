package dev.tsiantakis.survivaleu_v3.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import dev.tsiantakis.survivaleu_v3.events.implementations.AnnounceDeathCoords;

public class PlayerDeath implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) {
        AnnounceDeathCoords.announceCoords(event);
    }
}
