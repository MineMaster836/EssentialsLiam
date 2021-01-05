package liam.essentialsliam.ModerationTools;

import liam.essentialsliam.EssentialsLiamMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class DisableChatListener implements Listener {
    EssentialsLiamMain plugin;
    public static Boolean gameChat;

    public DisableChatListener(EssentialsLiamMain plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void AsyncChatEvent(AsyncPlayerChatEvent e) {

        if (!gameChat && !e.getPlayer().isOp()) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "Sorry but the chat is currently disabled, " +
                    "if you believe this is a problem then please contact a server administrator.");
        }
    }
}

