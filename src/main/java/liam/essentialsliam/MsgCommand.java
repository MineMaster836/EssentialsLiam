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
import java.util.HashMap;
import java.util.UUID;

public class MsgCommand implements CommandExecutor {
    public MsgCommand(JavaPlugin plugin) {
        PluginCommand command = plugin.getCommand("msg");
        if (command == null) {
            System.err.println("Could not get command msg");
        }
        command.setExecutor(this);

    }

    public static HashMap<UUID, Player> lastPlayer = new HashMap<UUID, Player>();
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player playerSending = Bukkit.getPlayer(commandSender.getName());
        String playerSendingDisplayName = playerSending.getDisplayName();
        if (playerSending == null) {
            commandSender.sendMessage("Sorry, you're not a player");
            return false;
        }

        String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

        Player playerToSendMsgTo = Bukkit.getPlayer(args[0]);
        if (playerToSendMsgTo == null) {
            commandSender.sendMessage(ChatColor.RED + "Please add a player name to send the message to");
            return false;
        }

        if (message.equals("")) {
            commandSender.sendMessage(ChatColor.RED + "Please add a message");
            return false;
        }
        String playerToSendMsgToDisplayName = playerToSendMsgTo.getDisplayName();
        playerToSendMsgTo.playSound(playerToSendMsgTo.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, SoundCategory.MASTER, (float) 100, (float) 1.3);

        lastPlayer.put(playerSending.getUniqueId(), playerToSendMsgTo);
        lastPlayer.put(playerToSendMsgTo.getUniqueId(), playerSending);
        playerToSendMsgTo.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + playerSendingDisplayName +
                ChatColor.DARK_GRAY + " -> " + ChatColor.GRAY + playerToSendMsgToDisplayName + ChatColor.DARK_GRAY +
                "]" + ChatColor.GRAY + ": " + ChatColor.RESET + message);

        commandSender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + playerSendingDisplayName +
                ChatColor.DARK_GRAY + " -> " + ChatColor.GRAY + playerToSendMsgToDisplayName + ChatColor.DARK_GRAY +
                "]" + ChatColor.GRAY + ": " + ChatColor.RESET + message);

        return true;
    }
}