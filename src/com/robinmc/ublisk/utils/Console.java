package com.robinmc.ublisk.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Console {
	
	/**
	 * Sends a message to the console
	 * @param msg Message to be sent
	 */
	public static void sendMessage(String msg){
		System.out.println(msg);
		for (Player player : Bukkit.getOnlinePlayers()){
			if (player.isOp()){
				player.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Console: " + ChatColor.RESET + msg);
			}
		}
	}
	
	/**
	 * Execute a command as the console (without the /)
	 * @param cmd The command to be executed
	 */
	public static void sendCommand(String cmd){
		try {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd);
		} catch (Exception e){
			sendMessage("An error occured while attempting to perform a console command!");
			sendMessage("Command: " + cmd);
		}
	}

}