package cn.playerjoinmessage;

import cn.playerjoinmessage.listener.PlayerEventMessage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerJoinMessage extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerEventMessage(this),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public String manualColorTranslate(String message) {
        return message.replace('&', '§'); // 手动将 & 替换为 §
    }
}
