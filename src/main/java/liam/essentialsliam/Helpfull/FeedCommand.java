package liam.essentialsliam.Helpfull;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FeedCommand implements CommandExecutor {
    public FeedCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("feed");
        if (command == null) {
            System.err.println("Could not get command feed");
        } else {
            command.setExecutor(this);
        }
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = Bukkit.getPlayer(commandSender.getName());
        if (player == null) {
            commandSender.sendMessage("Sorry, you're not a player.");
            return false;
        }

        if (args.length!=1) {
            commandSender.sendMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + "You Just Fed Yourself");
            player.setFoodLevel(20);
            return false;
        }

        Player playerName = Bukkit.getPlayer(args[0]);
        if (playerName == null) {
            commandSender.sendMessage(ChatColor.RED + "That player is offline");
            return false;
        }

        String playerUserName = playerName.getDisplayName();
        commandSender.sendMessage(ChatColor.AQUA + "You Just Fed " + playerUserName);

        String senderName = commandSender.getName();

        playerName.sendMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + senderName + " Just Fed You");

        playerName.setFoodLevel(20);

        return true;
    }
}