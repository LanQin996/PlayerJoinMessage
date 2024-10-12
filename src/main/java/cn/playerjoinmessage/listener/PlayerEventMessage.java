package cn.playerjoinmessage.listener;

import cn.playerjoinmessage.PlayerJoinMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerEventMessage implements Listener {
    private final PlayerJoinMessage main;

    public PlayerEventMessage(PlayerJoinMessage plugin) {
        this.main = plugin;
    }

    @EventHandler
    public void CancelJoinMessage(PlayerJoinEvent e) {
        e.setJoinMessage(null);

        Player player = e.getPlayer();
        List<String> joinMessages;

        if (!player.hasPlayedBefore()) {
            joinMessages = main.getConfig().getStringList("PlayerJoinMessage.FirstJoinPlayer.joinmessage");
        } else {
            joinMessages = main.getConfig().getStringList("PlayerJoinMessage.Default.joinmessage");
        }

        for (String message : joinMessages) {
            String colormessage = main.manualColorTranslate(message);
            Bukkit.broadcastMessage(colormessage.replace("%player_name%", player.getName()));

        }
    }

}