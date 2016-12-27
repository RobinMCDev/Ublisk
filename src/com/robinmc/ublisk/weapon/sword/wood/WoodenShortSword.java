package com.robinmc.ublisk.weapon.sword.wood;

import com.robinmc.ublisk.abilities.swordsman.TestAbility;
import com.robinmc.ublisk.weapon.WeaponRarity;
import com.robinmc.ublisk.weapon.sword.AttackSpeed;

public class WoodenShortSword extends WoodenSword {

	public WoodenShortSword() {
		super("Wooden Short Sword", WeaponRarity.COMMON, "Insert description here", AttackSpeed.FAST, 3, -1, -1, new TestAbility());
	}

}
