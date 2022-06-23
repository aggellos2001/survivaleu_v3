package dev.tsiantakis.survivaleu_v3;

import org.bukkit.plugin.java.JavaPlugin;

import dev.tsiantakis.survivaleu_v3.events.AsyncChat;
import dev.tsiantakis.survivaleu_v3.events.PlayerDeath;

public class SurvivalEU extends JavaPlugin {

    public static SurvivalEU getInstance() {
        return JavaPlugin.getPlugin(SurvivalEU.class);
    }

    @Override
    public void onEnable() {
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new AsyncChat(), this);
    }

}