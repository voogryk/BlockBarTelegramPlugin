package org.blockbar.blockbartelegramplugin;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Bot {
    private static Bot instance;
    private TelegramBot bot;
    private BlockBarTelegramPlugin plugin;
    private List<String> chatIds;
    private Bot() {}

    public static Bot getInstance() {
        if (instance == null) {
            instance = new Bot();
        }
        return instance;
    }

    public void init(BlockBarTelegramPlugin plugin) {
        this.plugin = plugin;
        FileConfiguration config = plugin.getConfig();
        this.bot = new TelegramBot(config.getString("bot.token"));
        this.chatIds = config.getStringList("bot.channels");
    }

    public void sendMessage(String msgKey) {
        String msg = this.plugin.getConfig().getString(msgKey);
        this.chatIds.forEach(chatId -> {
            SendMessage request = new SendMessage(chatId, msg);
            this.bot.execute(request);
        });
    }
}