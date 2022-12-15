package com.jubiman.humanflesh.sanity;

import com.jubiman.customplayerlib.CustomPlayers;
import com.jubiman.humanflesh.mob.HarmlessMobs;
import necesse.engine.network.server.ServerClient;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.hostile.pirates.PirateCaptainMob;
import necesse.level.maps.Level;
import necesse.level.maps.biomes.MobChance;
import necesse.level.maps.biomes.MobSpawnTable;

import java.awt.*;

public class SanityPlayers extends CustomPlayers<SanityPlayer> {
	public static final MobSpawnTable spawnTable = new MobSpawnTable();

	public SanityPlayers() {
		super(SanityPlayer.class);
		init();
	}

	public void init() {
		spawnTable.add(generate(10, HarmlessMobs.DeepCaveSpiritMob.class)
		).add(generate(15, HarmlessMobs.SandSpiritMob.class)
		).add(generate(10, HarmlessMobs.BlackCaveSpiderMob.class)
		).add(generate(15, HarmlessMobs.GiantCaveSpiderMob.class)
		).add(generate(7, HarmlessMobs.SwampCaveSpiderMob.class)
		).add(generate(20, HarmlessMobs.NinjaMob.class)
		).add(generate(20, HarmlessMobs.VampireMob.class)
		).add(generate(7, HarmlessMobs.VoidApprentice.class)
		).add(generate(1, PirateCaptainMob.class)
		).add(generate(20, HarmlessMobs.FrozenDwarfMob.class)
		);
	}

	private static MobChance generate(int tickets, Class<? extends Mob> mob) {
		return new MobChance(tickets) {
			@Override
			public boolean canSpawn(Level level, ServerClient serverClient, Point point) {
				return true;
			}

			@Override
			public Mob getMob(Level level, ServerClient serverClient, Point point) {
				try {
					return mob.newInstance();
				} catch (InstantiationException | IllegalAccessException e) { // shouldn't happen
					throw new RuntimeException(e);
				}
			}
		};
	}

	@Override
	public void save(SaveData saveData) {
		SaveData save = new SaveData("sanityplayers");
		for (SanityPlayer player : valueIterator())
			player.addSaveData(save);

		saveData.addSaveData(save);
	}

	@Override
	public void load(LoadData loadData) {
		for (LoadData data : loadData.getLoadData())
			get(Long.parseLong(data.getName())).load(data);
	}
}
