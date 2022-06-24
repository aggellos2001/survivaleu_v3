package dev.tsiantakis.survivaleu_v3.events.implementations;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import dev.tsiantakis.survivaleu_v3.SurvivalEU;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class ShoutCooldown {

    public static void shoutCooldown(AsyncChatEvent event) {
        var player = event.getPlayer();
        if (player.hasPermission("survivaleu.shoutbypass"))
            return;
        var audience = event.viewers();
        boolean isShout = false;
        for (var audienceMember : audience) {
            if (audienceMember instanceof Player) {
                var audiencePlayer = (Player) audienceMember;
                if (!player.getWorld().getEnvironment().equals(audiencePlayer.getWorld().getEnvironment())) {
                    isShout = true;
                    break;
                }
                if (player.getLocation().distance(audiencePlayer.getLocation()) >= 200) {
                    isShout = true;
                    break;
                }
            }
        }
        if (isShout) {
            if (player.hasMetadata("shoutCooldown")) {
                var lastTime = player.getMetadata("shoutCooldown").get(0).asLong();
                if (System.currentTimeMillis() - lastTime < 30000) {
                    event.setCancelled(true);
                    var waitMessage = Component.text(String.format("Wait for %d seconds before shouting again!",
                            (30000 - (System.currentTimeMillis() - lastTime)) / 1000)).color(NamedTextColor.GOLD);
                    player.sendMessage(waitMessage);
                    return;
                }
            }
            player.setMetadata("shoutCooldown",
                    new FixedMetadataValue(SurvivalEU.getInstance(), System.currentTimeMillis()));
        }
    }
}
