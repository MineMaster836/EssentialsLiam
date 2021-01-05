package liam.essentialsliam.Helpfull;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class EcCommand implements CommandExecutor {
    public EcCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("ec");
        if (command == null) {
            System.err.println("Could not get command ec");
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
            commandSender.sendMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + "Opening Your Ender Chest");
            Inventory commandSenderEnderChest = player.getEnderChest();
            player.openInventory(commandSenderEnderChest);
            return false;
        }

        Player playerName = Bukkit.getPlayer(args[0]);
        if (playerName == null) {
            commandSender.sendMessage(ChatColor.RED + "That player is offline");
            return false;
        }

        String playerUserName = playerName.getDisplayName();
        commandSender.sendMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + "Opening " + playerUserName + "'s Ender Chest");

        Inventory playerEnderChest = playerName.getEnderChest();
        player.openInventory(playerEnderChest);
        return true;


    }
}

