package com.robinmc.ublisk.listeners.player;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

import com.robinmc.ublisk.HashMaps;
import com.robinmc.ublisk.Helper;
import com.robinmc.ublisk.Main;
import com.robinmc.ublisk.Message;
import com.robinmc.ublisk.Music;
import com.robinmc.ublisk.Tracker;
import com.robinmc.ublisk.Var;
import com.robinmc.ublisk.iconmenus.ClassMenu;
import com.robinmc.ublisk.utils.DataFile;
import com.robinmc.ublisk.utils.Exp;
import com.robinmc.ublisk.utils.UPlayer;
import com.robinmc.ublisk.utils.UUIDUtils;
import com.robinmc.ublisk.utils.Ublisk;
import com.robinmc.ublisk.utils.exception.NotSetException;
import com.robinmc.ublisk.utils.inventory.item.Item;
import com.robinmc.ublisk.utils.perm.PermissionGroup;
import com.robinmc.ublisk.utils.settings.Setting;

import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		final Player player = event.getPlayer(); // TODO Switch to UPlayer
		final UPlayer uPlayer = new UPlayer(player);
		String pn = player.getName();
		UUID uuid = player.getUniqueId();
		
		Ublisk.sendConsoleCommand("scoreboard teams join all " + pn); //Join team "all". This team disables 1.9 collision TODO: Better solution
		
		event.setJoinMessage(Message.Complicated.JoinQuit.playerJoin(pn));
		
		player.sendMessage(Message.PACK_SENDING.get());
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable(){ 
			//For some reason sending the pack has to be delayed, otherwise the client won't get the message
			public void run(){
				//ResourcePackAPI.setResourcepack(player, Var.PACK_URL);
				uPlayer.setResourcePack(Var.PACK_URL);
			}
		}, 1*20);
		
		//Save player uuid and name for later use
		UUIDUtils.save(player);
		
		HashMaps.addPlayerToMaps(player);
		
		try {
			if (uPlayer.getSetting(Setting.PLAY_MUSIC)){
				Music.playSong(player, uPlayer.getTown().getName().toLowerCase());
			}
		} catch (NotSetException e) {
			Music.playSong(player, uPlayer.getTown().getName().toLowerCase());
			uPlayer.setSetting(Setting.PLAY_MUSIC, true);
		}
		
		Tracker.JOINED.add(player);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable(){
        	public void run(){
        		ClassMenu.open(player);
        	}
        }, 2*20);
        
        String ip = player.getAddress().toString();
        ip = ip.replace("/", "");
        DataFile.IP.set("ip." + uuid, ip);
        
        Exp.refresh(player);
        
        //If the player is not a Builder, Moderator or Owner disable builder mode to prevent griefing
        PermissionGroup group = uPlayer.getGroup();
        if (!(	group == PermissionGroup.BUILDER ||
        		group == PermissionGroup.MODERATOR ||
        		group == PermissionGroup.OWNER
        		) &&
        		uPlayer.isInBuilderMode()){
        	Helper.disableBuilderMode(player);
        }
        
        PlayerInventory inv = player.getInventory();
        if (!inv.contains(Material.CHEST)){
        	Item item = new Item(Material.CHEST);
        	item.setName(ChatColor.RESET + "" + ChatColor.BLUE + "" + ChatColor.BOLD + "Menu");
        	inv.setItem(7, item.getItemStack());
        }
        
        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(1);
	}
}
