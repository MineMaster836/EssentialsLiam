package liam.essentialsliam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Arrays;

public class RCommand implements CommandExecutor {
    public RCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("r");
        if (command == null) {
            System.err.println("Could not get command r");
        }
        command.setExecutor(this);

    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player playerSending = Bukkit.getPlayer(commandSender.getName());
        String playerSendingDisplayName = playerSending.getDisplayName();
        if (playerSending == null) {
            commandSender.sendMessage("Sorry, you're not a player");
            return false;
        }

        String message = String.join(" ", Arrays.copyOfRange(args, 0, args.length));

        Player playerToSendMsgTo = MsgCommand.lastPlayer.get(playerSending.getUniqueId());
        if (playerToSendMsgTo == null) {
            commandSender.sendMessage(ChatColor.RED + "You have no one to respond to");
            return false;
        }

        if (message.equals("")) {
            commandSender.sendMessage(ChatColor.RED + "Please add a message");
            return false;
        }
        String playerToSendMsgToDisplayName = playerToSendMsgTo.getDisplayName();
        playerToSendMsgTo.playSound(playerToSendMsgTo.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, SoundCategory.MASTER, (float) 100, (float) 1.3);

        playerToSendMsgTo.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + playerSendingDisplayName +
                ChatColor.DARK_GRAY + " -> " + ChatColor.GRAY + playerToSendMsgToDisplayName + ChatColor.DARK_GRAY +
                "]" + ChatColor.GRAY + ": " + ChatColor.RESET + message);

        commandSender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + playerSendingDisplayName +
                ChatColor.DARK_GRAY + " -> " + ChatColor.GRAY + playerToSendMsgToDisplayName + ChatColor.DARK_GRAY +
                "]" + ChatColor.GRAY + ": " + ChatColor.RESET + message);

        return true;
    }
}