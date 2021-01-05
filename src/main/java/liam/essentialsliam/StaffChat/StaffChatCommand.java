package liam.essentialsliam.StaffChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffChatCommand implements CommandExecutor {
    public StaffChatCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("staffchat");
        if (command == null) {
            System.err.println("Could not get command staffchat");
        } else {
            command.setExecutor(this);
        }
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        String message = String.join(" ", args);

        if (message == "") {
            commandSender.sendMessage(ChatColor.RED + "Please add a message");
            return false;
        }

        Player player = Bukkit.getPlayer(commandSender.getName());
        if (player == null) {
            Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "[" + ChatColor.GOLD + "StaffChat" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RESET + "Server" + ChatColor.RESET + ChatColor.BOLD +" > " + ChatColor.LIGHT_PURPLE + message, "essentialsliam.staffchat");
            return false;
        }

        String playerUserName = player.getDisplayName();

        Bukkit.broadcast(ChatColor.LIGHT_PURPLE + "[" + ChatColor.GOLD + "StaffChat" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RESET + playerUserName + ChatColor.RESET + ChatColor.BOLD +" > " + ChatColor.LIGHT_PURPLE + message, "essentialsliam.staffchat");

        return true;
    }
}