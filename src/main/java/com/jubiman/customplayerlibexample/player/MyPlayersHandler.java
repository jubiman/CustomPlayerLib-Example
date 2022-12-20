package com.jubiman.customplayerlibexample.player;

import com.jubiman.customplayerlib.CustomPlayerRegistry;
import com.jubiman.customplayerlib.CustomPlayersHandler;

public class MyPlayersHandler extends CustomPlayersHandler<MyPlayer> {
	// It's recommended to store the name in a static constant, so you can easily access it
	public static final String name = "myplayers";

	public MyPlayersHandler() {
		super(MyPlayer.class, name);
		// call this class' method
		init();
	}

	/**
	 * Optional method
 	 */
	public void init() {
		// initialize stuff in this class
	}

	/**
	 * These methods are not necessary, but they are recommended.
	 * This replaces CustomPlayerRegistry.get(MyPlayers.name).get(auth) with MyPlayers.getPlayer(auth).
	 * It's just less code to write :)
	 */
	public static MyPlayersHandler getInstance() {
		return (MyPlayersHandler) CustomPlayerRegistry.get(name);
	}

	/**
	 * A null safe way to get a player from the map, adds player if they don't exist yet
	 * @param auth the authentication of the player's ServerClient
	 * @return the MyPlayer object belonging to the player
	 */
	public static MyPlayer getPlayer(long auth) {
		return getInstance().get(auth);
	}
}
