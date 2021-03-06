package xyz.derkades.ublisk.mob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import xyz.derkades.ublisk.Var;
import xyz.derkades.ublisk.mob.mobs.zombie.ZombieRhocus;
import xyz.derkades.ublisk.mob.mobs.zombie.villager.RuinsDweller;

public class Mobs {
	
	public static final HashMap<UUID, Mob> SPAWNED_MOBS = new HashMap<UUID, Mob>();
	
	public static final Mob[] MOB_LIST = new Mob[]{
			new RuinsDweller(),
			new ZombieRhocus()
	};
	
	public static final List<EntityType> NON_MOB_ENTITIES = Arrays.asList(new EntityType[]{
			EntityType.PLAYER,
			EntityType.ARMOR_STAND,
			EntityType.VILLAGER,
	});
	
	public static void clearMobs(){
		SPAWNED_MOBS.clear();
		for (LivingEntity entity : Var.WORLD.getLivingEntities()){
			if (getEntityTypes().contains(entity.getType())){
				entity.remove();
			}
		}
	}
	
	public static List<EntityType> getEntityTypes(){
		List<EntityType> list = new ArrayList<>();
		for (Mob mob : MOB_LIST){
			if (!list.contains(mob.getEntityType()))
				list.add(mob.getEntityType());
		}
		return list;
	}

}
