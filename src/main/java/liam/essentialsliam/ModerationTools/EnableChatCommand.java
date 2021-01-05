package liam.essentialsliam.ModerationTools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EnableChatCommand implements CommandExecutor {
    public EnableChatCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("enablechat");
        if (command == null) {
            System.err.println("Could not get command enablechat");
        } else {
            command.setExecutor(this);
        }
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = Bukkit.getPlayer(commandSender.getName());
        if (!commandSender.isOp()) {
            commandSender.sendMessage(ChatColor.RED + "Sorry but you must be OP to execute this command.");
            return false;
        }


        String playerName = player.getDisplayName();

        Bukkit.broadcastMessage(ChatColor.BLUE + "EssentialsLiam" + ChatColor.AQUA + " - " + ChatColor.RESET + "Chat has been enabled by " + playerName);

        DisableChatListener.gameChat = true;

        return true;
    }
}