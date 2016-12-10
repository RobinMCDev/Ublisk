package com.robinmc.ublisk.mob.type;

import org.bukkit.entity.EntityType;

import com.robinmc.ublisk.mob.MobCode;
import com.robinmc.ublisk.mob.MobType;

public class Husk implements MobType {

	@Override
	public EntityType getEntityType() {
		return EntityType.HUSK;
	}

	@Override
	public MobCode getCode() {
		return null;
	}

	

}