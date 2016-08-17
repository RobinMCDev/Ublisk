package com.robinmc.ublisk.utils.inventory;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.robinmc.ublisk.utils.inventory.item.Item;

public class InvUtils {
	
	public static Item fromMaterial(Material material){
		ItemStack itemStack = new ItemStack(material, 1);
		return new Item(itemStack);
	}

}
