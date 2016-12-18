package com.robinmc.ublisk.mob.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.PlayerInventory;

import com.robinmc.ublisk.Clazz;
import com.robinmc.ublisk.Message;

public class EntityDamageByEntity implements Listener {
	
	@EventHandler(ignoreCancelled = true)
	public void useWeapon(EntityDamageByEntityEvent event){
		
		if (event.getDamager().getType() == EntityType.PLAYER){
			Player player = (Player) event.getDamager();
			PlayerInventory inv = player.getInventory();
			Material item = inv.getItemInMainHand().getType();
			
			if (	item == Material.WOOD_SWORD ||
					item == Material.STONE_SWORD ||
					item == Material.DIAMOND_SWORD ||
					item == Material.GOLD_SWORD ||
					item == Material.IRON_SWORD){
				if (!(Clazz.getClass(player) == Clazz.SWORDSMAN)){
					player.sendMessage(Message.CLASS_WRONG_WEAPON.get());
					event.setCancelled(true);
				}
			}
		}
		
	}

}
