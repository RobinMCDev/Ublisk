package com.robinmc.ublisk.weapons.abilities;

import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.robinmc.ublisk.utils.UPlayer;

import net.md_5.bungee.api.ChatColor;

public class Launch extends Ability {

	public Launch() {
		super(1, 1); //TODO Mana TODO Min level
	}

	@Override
	public void run(UPlayer player) {
		if (!player.onGround()){
			player.sendMessage(ChatColor.RED + "You must be on a solid block to use this ability.");
			return;
		}
		
		player.setVelocity(player.getLocation().getDirection().multiply(3));
		player.setVelocity(new Vector(player.getVelocity().getX(), 1.5D, player.getVelocity().getZ()));
		player.givePotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3*20, 4);
	}

}
