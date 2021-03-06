package xyz.derkades.ublisk.modules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;

import xyz.derkades.ublisk.Main;
import xyz.derkades.ublisk.Message;
import xyz.derkades.ublisk.utils.UPlayer;
import xyz.derkades.ublisk.utils.Logger.LogLevel;

public class ResourcePack extends UModule implements CommandExecutor {
	
	/**
	 * Direct URL to resource pack zip.
	 */
	public static final String RESOURCE_PACK_URL = "http://ut.derkades.xyz/UbliskTextures59.zip";
	
	@Override
	public void onEnable(){
		//plugin.getCommand("pack").setExecutor(this);
		registerCommand("pack", this);
		log(this, LogLevel.DEBUG, "Using URL: " + RESOURCE_PACK_URL);
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onJoin(PlayerJoinEvent event){
		final UPlayer player = new UPlayer(event);
		player.sendMessage(Message.PACK_SENDING);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable(){ 
			//For some reason sending the pack has to be delayed, otherwise the client won't get the message
			public void run(){
				player.setResourcePack(RESOURCE_PACK_URL);
			}
		}, 1*20);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage(Message.NOT_A_PLAYER.toString());
			return true;
		}
		
		UPlayer player = new UPlayer(sender);

		if (args.length == 0){
			player.setResourcePack(RESOURCE_PACK_URL);
			return true;
		} else {
			player.sendMessage(Message.WRONG_USAGE);
			return true;
		}
	}

}
