package com.jubiman.customplayerlibexample.player;

import com.jubiman.customplayerlib.CustomPlayerRegistry;
import com.jubiman.customplayerlib.CustomPlayersHandlerTickable;

public class MyPlayersHandlerTickable extends CustomPlayersHandlerTickable<MyPlayerTickable> {
	public static final String name = "myplayerstickable";

	public MyPlayersHandlerTickable() {
		super(MyPlayerTickable.class, name);
	}

	/**
	 * These methods are not necessary, but they are recommended.
	 * This replaces CustomPlayerRegistry.get(MyPlayers.name).get(auth) with MyPlayers.getPlayer(auth).
	 * It's just less code to write :)
	 */
	public static MyPlayersHandlerTickable getInstance() {
		return (MyPlayersHandlerTickable) CustomPlayerRegistry.get(name);
	}

	/**
	 * A null safe way to get a player from the map, adds player if they don't exist yet
	 * @param auth the authentication of the player's ServerClient
	 * @return the MyPlayerTickable object belonging to the player
	 */
	public static MyPlayerTickable getPlayer(long auth) {
		return getInstance().get(auth);
	}
}
