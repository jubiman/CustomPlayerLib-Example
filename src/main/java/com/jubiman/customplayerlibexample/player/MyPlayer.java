package com.jubiman.customplayerlibexample.player;

import com.jubiman.customplayerlib.CustomPlayer;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;

public class MyPlayer extends CustomPlayer {
	public MyPlayer(long auth) {
		super(auth);
	}

	@Override
	public void addSaveData(SaveData save) {
		SaveData player = generatePlayerSave();
		// save stuff
		save.addSaveData(player);
	}

	@Override
	public void loadEnter(LoadData data) {
		// load stuff before the rest of the player is loaded
	}

	@Override
	public void loadExit(LoadData data) {
		// load stuff after the rest of the player is loaded
	}
}
