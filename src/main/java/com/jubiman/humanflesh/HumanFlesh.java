package com.jubiman.humanflesh;

import com.jubiman.customplayerlib.CustomPlayerRegistry;
import com.jubiman.humanflesh.player.MyPlayers;
import com.jubiman.humanflesh.player.MyPlayersTickable;
import necesse.engine.modLoader.annotations.ModEntry;


@ModEntry
public class HumanFlesh {
	public void init() {
		System.out.println("Human flesh init");

		// Register the classes (you would usually only have one class)
		CustomPlayerRegistry.register(MyPlayers.name, new MyPlayers());
		CustomPlayerRegistry.register(MyPlayersTickable.name, new MyPlayersTickable());
	}
}
