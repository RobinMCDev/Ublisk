package com.robinmc.ublisk.utils.inventory.item;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {
	
	private ItemStack item;
	
	public ItemBuilder(Material material){
		item = new ItemStack(material);
	}
	
	public ItemBuilder setAmount(int amount){
		item.setAmount(amount);
		return this;
	}
	
	public ItemBuilder setDamage(int i){
		item.setDurability((short) i);
		return this;
	}
	
	public ItemBuilder setName(String name){
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return this;
	}
	
	public ItemBuilder setLore(String... lore){
		ItemMeta meta = item.getItemMeta();
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		return this;
	}
	
	public ItemBuilder setSkullOwner(String playerName){
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(playerName);
		item.setItemMeta(meta);
		return this;
	}
	
	public Item create(){
		return new Item(item);
	}
	
	public ItemStack getItemStack(){
		return item;
	}

}