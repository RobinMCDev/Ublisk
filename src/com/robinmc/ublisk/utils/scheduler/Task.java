package com.robinmc.ublisk.utils.scheduler;

import org.bukkit.scheduler.BukkitRunnable;

import com.robinmc.ublisk.Main;
import com.robinmc.ublisk.task.CheckDoubleExp;
import com.robinmc.ublisk.task.CheckShield;
import com.robinmc.ublisk.task.CheckTown;
import com.robinmc.ublisk.task.ClearWeather;
import com.robinmc.ublisk.task.FastNight;
import com.robinmc.ublisk.task.LifeCrystalInventory;
import com.robinmc.ublisk.task.PlayerLevelUp;
import com.robinmc.ublisk.task.RandomTips;
import com.robinmc.ublisk.task.RegenerateHunger;
import com.robinmc.ublisk.task.RemoveMobs;
import com.robinmc.ublisk.task.RespawnNPC;
import com.robinmc.ublisk.task.SpawnRandomLoot;
import com.robinmc.ublisk.task.SyncTrackers;
import com.robinmc.ublisk.task.UpdateBackpackName;
import com.robinmc.ublisk.task.UpdateDoubleExpBar;
import com.robinmc.ublisk.task.UpdateFriendsHealthBar;
import com.robinmc.ublisk.task.UpdateInfo;

public enum Task {
	
	CHECK_DOUBLE_EXP(new CheckDoubleExp(), 10*20, 10*20, true),
	CHECK_SHIELD(new CheckShield(), 5*20, 5*20, false),
	CHECK_TOWN(new CheckTown(), 0, 2*20, false),
	CLEAR_WEATHER(new ClearWeather(), 60*20, 5*60*20, false),
	FAST_DAY_NIGHT(new FastNight(), 0, 1, false),
	LIFE_CRYSTAL_INVENTORY(new LifeCrystalInventory(), 5*20, 5*20, false),
	PLAYER_LEVEL_UP(new PlayerLevelUp(), 0, 5*20, false),
	RANDOM_TIP(new RandomTips(), 30*20, 5*60*20, false),
	REGENERATE_HUNGER(new RegenerateHunger(), 5*20, 5*20, false),
	REMOVE_MOBS(new RemoveMobs(), 5*60*20, 15*60*20, false),
	RESPAWN_NPC(new RespawnNPC(), 5*20, 5*60*20, false),
	SPAWN_RANDOM_LOOT(new SpawnRandomLoot(), 5*60*20, 5*60*20, false),
	SYNC_TRACKERS(new SyncTrackers(), 5*60*20, 5*60*20, false),
	UPDATE_BACKPACK_NAME(new UpdateBackpackName(), 0, 5*20, false),
	UPDATE_DOUBLE_XP_BAR(new UpdateDoubleExpBar(), 1*20, 1*20, false),
	UPDATE_FRIENDS_HEALTH_BAR(new UpdateFriendsHealthBar(), 5*20, 1*20, false),
	UPDATE_INFO(new UpdateInfo(), 5*20, 1*60*20, false);
	
	private BukkitRunnable runnable;
	private int delay;
	private int period;
	private boolean async;
	
	Task(BukkitRunnable runnable, int delay, int period, boolean async){
		this.runnable = runnable;
		this.delay = delay;
		this.period = period;
		this.async = async;
	}
	
	public void start(){
		if (async){
			runnable.runTaskTimerAsynchronously(Main.getInstance(), delay, period);
		} else {
			runnable.runTaskTimer(Main.getInstance(), delay, period);
		}
	}

}
