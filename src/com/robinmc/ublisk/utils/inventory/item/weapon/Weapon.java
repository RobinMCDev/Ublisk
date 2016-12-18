package com.robinmc.ublisk.utils.inventory.item.weapon;

import static net.md_5.bungee.api.ChatColor.BOLD;
import static net.md_5.bungee.api.ChatColor.DARK_AQUA;
import static net.md_5.bungee.api.ChatColor.DARK_GREEN;
import static net.md_5.bungee.api.ChatColor.DARK_PURPLE;
import static net.md_5.bungee.api.ChatColor.GOLD;
import static net.md_5.bungee.api.ChatColor.GRAY;
import static net.md_5.bungee.api.ChatColor.GREEN;
import static net.md_5.bungee.api.ChatColor.WHITE;
import static net.md_5.bungee.api.ChatColor.YELLOW;

import java.util.ArrayList;
import java.util.List;

public class Weapon {
	
	private WeaponType type;
	private WeaponInfo weaponInfo;
	private WeaponRarity rarity;
	private String name;
	private String lore;
	
	public Weapon(WeaponType type, WeaponRarity rarity, WeaponInfo weaponInfo, String name, String lore){
		this.type = type;
		this.weaponInfo = weaponInfo;
		this.rarity = rarity;
		this.name = name;
		this.lore = lore;
	}
	
	public WeaponType getType(){
		return type;
	}
	
	public WeaponRarity getRarity(){
		return rarity;
	}

	public WeaponInfo getWeaponInfo(){
		return weaponInfo;
	}
	
	public String getName(){
		String color = WHITE + "";
		
		if (rarity == WeaponRarity.COMMON){
			color = GRAY + "";
		} else if (rarity == WeaponRarity.UNIQUE){
			color = GREEN + "";
		} else if (rarity == WeaponRarity.RARE){
			color = DARK_GREEN + "";
		} else if (rarity == WeaponRarity.EPIC){
			color = DARK_PURPLE + "" + BOLD;
		} else if (rarity == WeaponRarity.LEGENDARY){
			color = GOLD + "" + BOLD;
		}
		
		return color + this.name; 
	}
	
	public String[] getLore(){
		return getWeaponLore(lore);
	}
	
	private String[] getWeaponLore(String tag){
		List<String> lore = new ArrayList<String>();
		lore.add(DARK_AQUA + tag);
		lore.add("");
		
		lore.add(YELLOW + "Damage: " + GOLD + weaponInfo.getDamage());
		
		lore.add(YELLOW + "Attack speed: " + GOLD + weaponInfo.getAttackSpeedName());
		
		if (weaponInfo.getMovementSpeed() != -1) //If movement speed is not the default value
			lore.add(YELLOW + "Movement speed: " + GOLD + weaponInfo.getMovementSpeed());
		if (weaponInfo.getKnockbackResistance() != -1)
			lore.add(YELLOW + "Knockback resistance: " + GOLD + weaponInfo.getKnockbackResistance());
		
		return lore.toArray(new String[]{});
	}
	
}
