package com.robinmc.ublisk.enums;

import java.io.File;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import com.robinmc.ublisk.utils.inventory.BetterInventory;
import com.robinmc.ublisk.utils.inventory.InvUtils;
import com.robinmc.ublisk.utils.variable.Message;

public enum Helper {
	
	ROBINMC("RobinMC", "https://goo.gl/Aay9Ry", "http://robinmc.com/"),
	CHASPYR("Chaspyr", "", "https://twitter.com/ItsChaspyr"),
	GLITCHERDOTBE("GlitcherDOTbe", "https://www.youtube.com/user/TheGlitcherDOTbe", "http://www.planetminecraft.com/texture_pack/glitchs-3d-addons-pack-19/"),
	ROTTENNUGGET("RottenNugget", "", "https://www.reddit.com/r/Minecraft/comments/2922fb/3d_models_resource_pack/"),
	PARKER("MrParkerl11", "https://goo.gl/WFW9zm", ""),
	SANDER("SenpaiSander", "https://www.youtube.com/channel/UC7gVEC704565MNzCB6OS3Ew", ""),
	SYDAN("SirSydan", "https://www.youtube.com/channel/UCFl5VN9R5uEszEoLrYgTOoA", "");
	
	private String ign;
	private String yt;
	private String custom;
	
	Helper(String ign, String yt, String custom){
		this.ign = ign;
		this.yt = yt;
		this.custom = custom;
	}
	
	public String getIgn(){
		if (ign == ""){
			return "N/A";
		} else {
			return ign;
		}
	}
	
	public String getYT(){
		if (yt == ""){
			return "N/A";
		} else {
			return yt;
		}		
	}
	
	public String getCustom(){
		if (custom == ""){
			return "N/A";
		} else {
			return custom;
		}
	}
	
	public static Helper fromString(String text) {
		if (text != null) {
			for (Helper helper: Helper.values()) {
				if (text.equalsIgnoreCase(helper.ign)) {
					return helper;
				}
			}
		}
		return null;
	}
	
	public static void enableBuilderMode(Player player){
		InvUtils.saveIntentory(player); //Save inventory to file
		BetterInventory.getInventory(player).clear();		
		player.setGameMode(GameMode.CREATIVE);		
		player.sendMessage(Message.BUILDER_MODE_ACTIVATED.get());
	}
	
	public static void disableBuilderMode(Player player){
		BetterInventory.getInventory(player).clear();
		InvUtils.restoreInventory(player);
		player.setGameMode(GameMode.ADVENTURE);
		player.sendMessage(Message.BUILDER_MODE_DEACTIVATED.get());
	}
	
	public static boolean builderModeEnabled(Player player){
		return new File(InvUtils.path, player.getName()+".yml").exists();
	}

}
