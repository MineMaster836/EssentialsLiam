package liam.essentialsliam;

import liam.essentialsliam.Helpfull.EcCommand;
import liam.essentialsliam.Helpfull.FeedCommand;
import liam.essentialsliam.Helpfull.HealCommand;
import liam.essentialsliam.ModerationTools.DisableChatCommand;
import liam.essentialsliam.ModerationTools.DisableChatListener;
import liam.essentialsliam.ModerationTools.EnableChatCommand;
import liam.essentialsliam.Useless.BlessYouCommand;
import liam.essentialsliam.Useless.SneezeCommand;
import liam.essentialsliam.Gamemode.GmaCommand;
import liam.essentialsliam.Gamemode.GmcCommand;
import liam.essentialsliam.Gamemode.GmsCommand;
import liam.essentialsliam.Gamemode.GmspCommand;
import liam.essentialsliam.ModerationTools.CcCommand;
import liam.essentialsliam.StaffChat.*;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class EssentialsLiamMain extends JavaPlugin {
    public EssentialsLiamMain() {
    }

    private static LuckPerms api = null;

    public void onEnable() {

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();
        }
        DisableChatListener.gameChat = true;

        new EcCommand(this);
        new GmcCommand(this);
        new GmsCommand(this);
        new GmspCommand(this);
        new GmaCommand(this);
        new CcCommand(this);
        new HealCommand(this);
        new FeedCommand(this);
        new StaffChatCommand(this);
        new ModChatCommand(this);
        new AdminChatCommand(this);
        new BuilderChatCommand(this);
        new DevChatCommand(this);
        new SneezeCommand(this);
        new BlessYouCommand(this);
        new DisableChatCommand(this);
        new EnableChatCommand(this);
        new DisableChatListener(this);
        new JoinAndLeaveListener(this);
        new MsgCommand(this);
        new RCommand(this);
        new ChatListener(this);

        System.out.println("[EssentialsLiam] enabled");
    }
    public static LuckPerms getLuckPerms() {
        return api;
    }
}