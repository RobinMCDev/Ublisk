package com.robinmc.ublisk;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.robinmc.ublisk.commands.Command;
import com.robinmc.ublisk.listeners.Listeners;
import com.robinmc.ublisk.mob.Mob;
import com.robinmc.ublisk.task.Task;
import com.robinmc.ublisk.utils.DoubleXP;
import com.robinmc.ublisk.utils.Guild;
import com.robinmc.ublisk.utils.Logger;
import com.robinmc.ublisk.utils.Logger.LogLevel;
import com.robinmc.ublisk.utils.Ublisk;

public class Main extends JavaPlugin {

	public static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		
		Ublisk.RESTART_ERROR = false;

		HashMaps.resetAllPlayers();
		
		new WorldEditCUI().onEnable();

		Listeners.register();

		Command.registerAll();

		Mob.startMobSpawning();

		for (Task task : Task.values())
			task.start();

		DoubleXP.startDoubleXPPacketListener();
		Logger.startSiteLogger();
		
		new BukkitRunnable() {
			public void run() {
				Logger.log(LogLevel.INFO, "Guilds", "Deleting empty guilds...");
				for (Guild guild : Guild.getGuildsList()){
					if (guild.getMembers().size() == 0){
						Logger.log(LogLevel.WARNING, "Guilds", "Deleted " + guild.getName() + "!");
						guild.remove();
					}
				}
			}
		}.runTaskLater(this, 5*20);

	}

	@Override
	public void onDisable() {
		instance = null;
	}

	public static Main getInstance() {
		return instance;
	}

}
