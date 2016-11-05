package com.robinmc.ublisk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.robinmc.ublisk.utils.logging.LogLevel;
import com.robinmc.ublisk.utils.logging.Logger;

public class HashMaps {

	public static Map<UUID, Boolean> afk = new HashMap<>();
	public static Map<UUID, Boolean> disableCommandLog = new HashMap<>();
	
	public static Map<UUID, Boolean> cooldownNpc = new HashMap<>();
	public static Map<UUID, Boolean> cooldownClass = new HashMap<>();
	
	/*
	@Deprecated
	public static Map<String, Boolean> doublexp = new HashMap<>();
	@Deprecated
	public static Map<String, Integer> doubleExpTime = new HashMap<>();
	@Deprecated
	public static Map<String, Boolean> doubleExpCooldown = new HashMap<>();
	@Deprecated
	public static Map<String, Boolean> doubleExpBarActive = new HashMap<>();
	*/
	
	public static Map<UUID, Boolean> isMuted = new HashMap<>();
	public static Map<UUID, Boolean> isSoftMuted = new HashMap<>();
	
	public static Map<Player, Player> lastMessageSender = new HashMap<>();
	
	public static Map<Player, Integer> lastLevel = new HashMap<>();

	//Tracker HashMaps. Every 5 minutes, these will be added to the database and reset to 0.
	public static Map<UUID, Integer> rightClicked = new HashMap<>();
	public static Map<UUID, Integer> leftClicked = new HashMap<>();
	public static Map<UUID, Integer> mobKills = new HashMap<>();
	public static Map<UUID, Integer> lootFound = new HashMap<>();
	public static Map<UUID, Integer> loggedIn = new HashMap<>();
	public static Map<UUID, Integer> chatMessages = new HashMap<>();
	public static Map<UUID, Integer> votingBoxes = new HashMap<>();
	
	static void resetAllPlayers(){
		for (Player player : Bukkit.getOnlinePlayers()){
			addPlayerToMaps(player);
		}
	}

	public static void addPlayerToMaps(Player player){
		Logger.log(LogLevel.INFO, "HashMaps", player.getName() + "'s maps have been reset");
		UUID uuid = player.getUniqueId();
		afk.put(uuid, false);
		cooldownNpc.put(uuid, false);
		cooldownClass.put(uuid, false);
		disableCommandLog.put(uuid, false);
		isMuted.put(uuid, false);
		isSoftMuted.put(uuid, false);
		lastMessageSender.put(player, null);
		lastLevel.put(player, player.getLevel());

		for (Tracker tracker : Tracker.values()){
			Map<UUID, Integer> map = tracker.getMap();
			map.put(uuid, 0);
		}
	}
	
	@Deprecated
	public static String placeHolder(){
		return "hi";
	}
	
}
