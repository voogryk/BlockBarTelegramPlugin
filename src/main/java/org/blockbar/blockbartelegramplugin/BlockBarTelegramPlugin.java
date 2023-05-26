package org.blockbar.blockbartelegramplugin;

import org.blockbar.blockbartelegramplugin.listeners.BloodNightEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockBarTelegramPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BloodNightEventListener(), this);
        saveDefaultConfig();
        getLogger().info("BlockBar Telegram Plugin Start Successfully");
        Bot bot = Bot.getInstance();
        bot.init(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
