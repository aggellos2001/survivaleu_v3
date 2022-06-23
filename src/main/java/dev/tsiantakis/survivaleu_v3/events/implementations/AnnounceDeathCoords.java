package dev.tsiantakis.survivaleu_v3.events.implementations;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class AnnounceDeathCoords {

    public static void announceCoords(PlayerDeathEvent event) {
        var player = (Player) event.getEntity();
        var location = player.getLocation();
        var x = location.getX();
        var y = location.getY();
        var z = location.getZ();
        var message = Component.text(
                String.format("You died at x:%.3f y:%.3f z:%.3f!", x, y, z))
                .color(NamedTextColor.GOLD);
        player.sendMessage(message);
    }
}
