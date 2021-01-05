package liam.essentialsliam.ModerationTools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CcCommand implements CommandExecutor {
    public CcCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("cc");
        if (command == null) {
            System.err.println("Could not get command cc");
        } else {
            command.setExecutor(this);
        }
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player playerName = Bukkit.getPlayer(commandSender.getName());
        if (playerName == null) {
            for (int i = 0; i < 100; ++i) {
                Bukkit.broadcast(" ", "essentialsliam.cc.bypass");
            }

            Bukkit.broadcastMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + "Chat Cleared by Console");
            return true;
        }

        for (int i = 0; i < 100; ++i) {
            Bukkit.broadcast(" ", "essentialsliam.cc.bypass");
        }

        String playerUserName = playerName.getDisplayName();

        Bukkit.broadcastMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + "Chat Cleared by " + playerUserName);
        return true;
    }
}