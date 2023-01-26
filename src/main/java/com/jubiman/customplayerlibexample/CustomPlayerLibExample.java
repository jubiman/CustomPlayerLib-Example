package com.jubiman.customplayerlibexample;

import com.jubiman.customplayerlib.CustomPlayerRegistry;
import com.jubiman.customplayerlibexample.player.MyPlayersHandler;
import com.jubiman.customplayerlibexample.player.MyPlayersHandlerTickable;
import necesse.engine.modLoader.annotations.ModEntry;


@ModEntry
public class CustomPlayerLibExample {
	public void init() {
		// Register the classes (you would usually only have one class)
		CustomPlayerRegistry.register(MyPlayersHandler.name, new MyPlayersHandler());
		CustomPlayerRegistry.register(MyPlayersHandlerTickable.name, new MyPlayersHandlerTickable());
	}
}
