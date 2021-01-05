package liam.essentialsliam.Useless;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SneezeCommand implements CommandExecutor {
    public SneezeCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("sneeze");
        if (command == null) {
            System.err.println("Could not get command sneeze");
        } else {
            command.setExecutor(this);
        }
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = Bukkit.getPlayer(commandSender.getName());

        String playerUserName = player.getDisplayName();

        if (player == null) {
            playerUserName = "Server";
        }

        Bukkit.broadcastMessage(ChatColor.AQUA + playerUserName + " Sneezed!");


        return true;
    }
}