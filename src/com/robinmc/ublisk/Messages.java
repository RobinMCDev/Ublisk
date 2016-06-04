package com.robinmc.ublisk;

import org.bukkit.ChatColor;

public class Messages {
	
	static ChatColor gold = ChatColor.GOLD;
	static ChatColor gray = ChatColor.GRAY;
	static ChatColor red = ChatColor.RED;
	static ChatColor yellow = ChatColor.YELLOW;
	
	//----------------------------- Join and quit -----------------------------//
	
	public static String playerJoin(String pn){
		return gold + "Ublisk" + gray + " >> " + yellow + pn + " has joined";
	}	
	
	public static String quit(String pn){
		return gold + "Ublisk" + gray + " >> " + yellow + pn + " has left";
	}
	
	//----------------------------- Commands -----------------------------//
	
	public static String noPlayer(){
		return gold + "Ublisk" + gray + " >> " + red + "You must be a player in order to execute this command!";
	}
	
	public static String wrongUsage(){
		return gold + "Ublisk" + gray + " >> " + red + "Wrong usage! Type /help for help";
	}
		
	public static String userNotFound(String user){
		return gold + "Ublisk" + gray + " >> " + red + "No additional information was found for user " + user;
	}
	
	public static String reportForums(){
		return gold + "Ublisk" + gray + " >> " + yellow + "Please report hackers and staff abusers over at http://robinmc.com";
	}
	
	public static String suggestFeature(){
		return gold + "Ublisk" + gray + " >> " + yellow + "Please suggest new features over at http://robinmc.com";
	}
	
	//----------------------------- Music -----------------------------//
	
	public static String songEnded(){
		return gold + "Music" + gray + " >> " + yellow + "Your song has ended. Please select a new song using /music";
	}
	
	public static String startSong(String song){
		return gold + "Music" + gray + " >> " + yellow + "You are now playing " + song;
	}
	
	//----------------------------- Resource pack -----------------------------//
	
	public static String declinedPack(){
		return red + "Please enable server resource packs and join again";
	}
	
	public static String packFailedDownload(){
		return gold + "Ublisk" + gray + " >> " + red + "We failed in sending you our resource pack. You'll have to play without. Please report this issue at the forums.";
	}
	
	public static String packLoaded(){
		return gold + "Ublisk" + gray + " >> " + yellow + "The resource pack has been successfully loaded";
	}
	
	public static String sendingPack(){
		return gold + "Ublisk" + gray + " >> " + yellow + "Sending you our resource pack...";
	}
	
	//----------------------------- Miscellaneous -----------------------------//
	
	public static String menuErrorWrongItem(){
		return gold + "Menu" + gray + " >> " + red + "An unexpected error has occured. Please report this error and the steps you took to get this error at the forums.";
	}
	
	public static String cantEat(String pn){
		return gold + "Ublisk" + gray + " >> " + red + pn + " Eating food is not allowed on this server. Please use a recycler";
	}
	
	public static String tntDetect(){
		return gold + "Ublisk" + gray + " >> " + red + "TNT has been detected in your inventory. Using it will result in a 30s temp-ban";
	}
	
	public static String tntBan(){
		return red + "You have been banned for using TNT. You will be unbanned automatically in 30 seconds.";
	}
	
	public static String removeMobsWarning(int sec){
		return gold + "Ublisk" + gray + " >> " + yellow + "Clearing all mobs and items in " + sec + " seconds!";
	}
	
	public static String removedMobs(){
		return gold + "Ublisk" + gray + " >> " + yellow + "All mobs and items have been cleared!";
	}
	
}
