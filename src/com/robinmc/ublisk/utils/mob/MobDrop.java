package com.robinmc.ublisk.utils.mob;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import com.robinmc.ublisk.utils.java.Random;
import com.robinmc.ublisk.utils.logging.LogLevel;
import com.robinmc.ublisk.utils.logging.Logger;
import com.robinmc.ublisk.utils.variable.Var;


public class MobDrop {
	
	private ItemStack item;
	private int min = 9001;
	private int max = 9001;
	private int percentage;
	
	/**
	 * Specifies a mob drop with random change of dropping
	 * @param item Item to be dropped
	 * @param percentage Random chance (1-100)
	 */
	public MobDrop(ItemStack item, int percentage){
		this.item = item;
		this.percentage = percentage;
	}
	
	/**
	 * Specifies a mob drop with random change of dropping
	 * @param item Item to be dropped
	 * @param min Minimum for random item amount
	 * @param max Maximum for random item amount
	 * @param percentage Random chance (1-100)
	 */
	public MobDrop(ItemStack item, int min, int max, int percentage){
		this.min = min;
		this.max = max;
		this.item = item;
		this.percentage = percentage;
	}
	
	public void drop(Location loc){
		if (min != 9001 && max != 9001){ //If min and max are set
			item.setAmount(Random.getRandomInteger(min, max));
			Logger.log(LogLevel.DEBUG, "Gold", "Random gold: " + Random.getRandomInteger(min, max));
		}
		
		double d = percentage / 100.0; // 100% - 1.0 | 50% - 0.5
		Logger.log(LogLevel.DEBUG, "Mob", "Percentage / 100 = " + d);
		boolean drop = Random.getRandomDouble() <= d;
		Logger.log(LogLevel.DEBUG, "Mob", "Random: " + drop);
		if (drop){
			org.bukkit.entity.Item entity = Var.WORLD.dropItemNaturally(loc, item);
			entity.setPickupDelay(10);
		}
	}
	
	public ItemStack getItemStack(){
		return item;
	}

}