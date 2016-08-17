package com.robinmc.ublisk.task;

import org.bukkit.Bukkit;

import com.robinmc.ublisk.Main;
import com.robinmc.ublisk.utils.Time;
import com.robinmc.ublisk.utils.scheduler.Task;

public class FastDayNight implements Task {

	@Override
	public void task(Main plugin) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
			public void run(){
				if (Time.isDay()){
					Time.add(5L);
				} else {
					Time.add(5L);
				}
			}
		}, 0, 2);
	}

}
