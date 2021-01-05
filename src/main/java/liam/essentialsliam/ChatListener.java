package liam.essentialsliam;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.context.ContextManager;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatListener implements Listener {

    public ChatListener(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        LuckPerms api = EssentialsLiamMain.getLuckPerms();
        ContextManager cm = api.getContextManager();
        User user =  api.getUserManager().getUser(player.getUniqueId());
        QueryOptions queryOptions = cm.getQueryOptions(user).orElse(cm.getStaticQueryOptions());
        CachedMetaData metaData = user.getCachedData().getMetaData(queryOptions);
        String prefix = metaData.getPrefix();
        String playerDisplayName = player.getDisplayName();
        if (prefix == null) {
            event.setFormat(ChatColor.translateAlternateColorCodes('&', playerDisplayName + " &7>>&r " + message));
        } else {
            event.setFormat(ChatColor.translateAlternateColorCodes('&', prefix + playerDisplayName + " &7>>&r " + message));
        }
        if (message.toLowerCase().contains(player.getName().toLowerCase()) || message.toLowerCase().contains(player.getDisplayName().toLowerCase())) {
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, SoundCategory.MASTER, (float) 100, (float) 0.75);
        }
    }
}
