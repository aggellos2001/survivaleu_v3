package dev.tsiantakis.survivaleu_v3.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import dev.tsiantakis.survivaleu_v3.events.implementations.ShoutCooldown;
import io.papermc.paper.event.player.AsyncChatEvent;

public class AsyncChat implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onChat(AsyncChatEvent event) {
        ShoutCooldown.shoutCooldown(event);
    }
}