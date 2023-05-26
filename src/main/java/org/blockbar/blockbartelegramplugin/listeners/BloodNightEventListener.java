package org.blockbar.blockbartelegramplugin.listeners;

import org.blockbar.blockbartelegramplugin.Bot;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import de.eldoria.bloodnight.events.BloodNightBeginEvent;

public class BloodNightEventListener implements Listener {
    @EventHandler
    public void onBloodNightBegin(BloodNightBeginEvent event) {
        Bukkit.getLogger().info("OK. NOW IT IS WORKING");
        Bot bot = Bot.getInstance();
        bot.sendMessage("messages.bloodnight");
    }
}
