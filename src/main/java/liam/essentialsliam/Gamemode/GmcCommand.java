package liam.essentialsliam.Gamemode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GmcCommand implements CommandExecutor {
    public GmcCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("gmc");
        if (command == null) {
            System.err.println("Could not get command gmc");
        }
        command.setExecutor(this);

    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = Bukkit.getPlayer(commandSender.getName());
        if (player == null) {
            commandSender.sendMessage("Sorry, you're not a player");
            return false;
        }

        if (args.length!=1) {
            if (player.getGameMode() == GameMode.CREATIVE) {
                commandSender.sendMessage(ChatColor.RED + "Your already in that game mode");
                return false;
            }
            player.setGameMode(GameMode.CREATIVE);
            commandSender.sendMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + "Setting your game mode to Creative");
            return false;
        }

        Player playerName = Bukkit.getPlayer(args[0]);
        if (playerName == null) {
            commandSender.sendMessage(ChatColor.RED + "That player is offline");
            return false;
        }

        String playerUsername = playerName.getDisplayName();

        if (playerName.getGameMode() == GameMode.CREATIVE) {
            commandSender.sendMessage(ChatColor.RED + playerUsername + " is already in that game mode");
            return false;
        } else {
            playerName.setGameMode(GameMode.CREATIVE);
            commandSender.sendMessage(ChatColor.AQUA + "Setting " + playerUsername + "'s game mode to Creative");
        }

        return true;
    }
}

