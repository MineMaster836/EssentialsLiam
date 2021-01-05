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

public class GmaCommand implements CommandExecutor {
    public GmaCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("gma");
        if (command == null) {
            System.err.println("Could not get command gma");
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
            if (player.getGameMode() == GameMode.ADVENTURE) {
                commandSender.sendMessage(ChatColor.RED + "Your already in that game mode");
                return false;
            }
            player.setGameMode(GameMode.ADVENTURE);
            commandSender.sendMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + "Setting your game mode to Adventure");
            return false;
        }

        Player playerName = Bukkit.getPlayer(args[0]);
        if (playerName == null) {
            commandSender.sendMessage(ChatColor.RED + "That player is offline");
            return false;
        }

        String playerUsername = playerName.getDisplayName();

        if (playerName.getGameMode() == GameMode.ADVENTURE) {
            commandSender.sendMessage(ChatColor.RED + playerUsername + " is already in that game mode");
            return false;
        } else {
            playerName.setGameMode(GameMode.ADVENTURE);
            commandSender.sendMessage(ChatColor.AQUA + "Setting " + playerUsername + "'s game mode to Adventure");
        }

        return true;
    }
}

