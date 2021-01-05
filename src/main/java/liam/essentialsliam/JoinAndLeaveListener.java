package liam.essentialsliam;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.context.ContextManager;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinAndLeaveListener implements Listener {
    EssentialsLiamMain plugin;
    LuckPerms api = EssentialsLiamMain.getLuckPerms();

    public JoinAndLeaveListener(EssentialsLiamMain plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerLoginEvent(PlayerJoinEvent e) {
        ContextManager cm = api.getContextManager();
        User user = api.getUserManager().getUser(e.getPlayer().getUniqueId());
        QueryOptions queryOptions = cm.getQueryOptions(user).orElse(cm.getStaticQueryOptions());
        CachedMetaData metaData = user.getCachedData().getMetaData(queryOptions);
        String prefix = metaData.getPrefix();
        String playerDisplayName = e.getPlayer().getDisplayName();
        if (prefix == null) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&7[&a+&7]&r " + playerDisplayName));
        } else {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&7[&a+&7]&r " + prefix + playerDisplayName));
        }
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent e) {
        ContextManager cm = api.getContextManager();
        User user = api.getUserManager().getUser(e.getPlayer().getUniqueId());
        QueryOptions queryOptions = cm.getQueryOptions(user).orElse(cm.getStaticQueryOptions());
        CachedMetaData metaData = user.getCachedData().getMetaData(queryOptions);
        String prefix = metaData.getPrefix();
        String playerDisplayName = e.getPlayer().getDisplayName();
        if (prefix == null) {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c-&7]&r " + playerDisplayName));
        } else {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c-]&r " + prefix + playerDisplayName));
        }
    }
}

