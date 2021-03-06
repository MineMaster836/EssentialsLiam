package liam.essentialsliam.StaffChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AdminChatCommand implements CommandExecutor {
    public AdminChatCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("adminchat");
        if (command == null) {
            System.err.println("Could not get command adminchat");
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
            Bukkit.broadcast(ChatColor.BLUE + "[" + ChatColor.GOLD + "AdminChat" + ChatColor.BLUE + "] " + ChatColor.RESET + "Server" + ChatColor.BOLD +" > " + ChatColor.BLUE + message, "essentialsliam.adminchat");
            return true;
        }

        String playerUserName = player.getDisplayName();

        Bukkit.broadcast(ChatColor.BLUE + "[" + ChatColor.GOLD + "AdminChat" + ChatColor.RED + "] " + ChatColor.RESET + playerUserName + ChatColor.BOLD +" > " + ChatColor.BLUE + message, "essentialsliam.adminchat");

        return true;
    }
}
