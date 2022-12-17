package com.jubiman.humanflesh.player;

import com.jubiman.customplayerlib.CustomPlayerTickable;
import necesse.engine.network.client.Client;
import necesse.engine.network.server.Server;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;

public class MyPlayerTickable extends CustomPlayerTickable {
	public MyPlayerTickable(long auth) {
		super(auth);
	}

	@Override
	public void serverTick(Server server) {
		// perform server tick
	}

	@Override
	public void clientTick(Client client) {
		// perform client tick
	}

	@Override
	public void addSaveData(SaveData save) {
		// save the player
	}

	@Override
	public void load(LoadData data) {
		// load the player
	}
}
