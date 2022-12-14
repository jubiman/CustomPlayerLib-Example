package com.jubiman.humanflesh;

import com.jubiman.humanflesh.command.SanityCommand;
import com.jubiman.humanflesh.item.CookedHumanMeat;
import com.jubiman.humanflesh.item.HumanMeat;
import com.jubiman.humanflesh.mob.HarmlessMobs;
import com.jubiman.humanflesh.sanity.SanityPlayers;
import com.jubiman.humanflesh.utils.EnumHelper;
import necesse.engine.GameEventListener;
import necesse.engine.GameEvents;
import necesse.engine.GameRaidFrequency;
import necesse.engine.commands.CommandsManager;
import necesse.engine.events.ServerStopEvent;
import necesse.engine.localization.message.GameMessage;
import necesse.engine.localization.message.LocalMessage;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.ItemRegistry;
import necesse.engine.registries.MobRegistry;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.entity.mobs.hostile.HumanRaiderMob;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;


@ModEntry
public class HumanFlesh {
	public void init() {
		System.out.println("Human flesh init");

		SanityPlayers.init();

		// Register item
		ItemRegistry.registerItem("humanmeat", new HumanMeat(), 50, true);
		ItemRegistry.registerItem("cookedhumanmeat", new CookedHumanMeat(), 77, true);

		// Register harmless mobs
		MobRegistry.registerMob("harmlessfrozendwarf", HarmlessMobs.FrozenDwarfMob.class, true);
		MobRegistry.registerMob("harmlessvoidapprentice", HarmlessMobs.VoidApprentice.class, true);
		MobRegistry.registerMob("harmlessvampire", HarmlessMobs.VampireMob.class, true);
		MobRegistry.registerMob("harmlessninja", HarmlessMobs.NinjaMob.class, true);
		MobRegistry.registerMob("harmlessswampcavespider", HarmlessMobs.SwampCaveSpiderMob.class, true);
		MobRegistry.registerMob("harmlessgiantcavespider", HarmlessMobs.GiantCaveSpiderMob.class, true);
		MobRegistry.registerMob("harmlessblackcavespider", HarmlessMobs.BlackCaveSpiderMob.class, true);
		MobRegistry.registerMob("harmlesssandspirit", HarmlessMobs.SandSpiritMob.class, true);
		MobRegistry.registerMob("harmlessdeepcavespirit", HarmlessMobs.DeepCaveSpiritMob.class, true);

		// Event listeners
		GameEvents.addListener(ServerStopEvent.class, new GameEventListener<ServerStopEvent>() {
			@Override
			public void onEvent(ServerStopEvent e) {
				SanityPlayers.stop();
			}
		});
	}

	public void postInit() {
		// Register recipes
		Recipes.registerModRecipe(new Recipe(
				"cookedhumanmeat",
				1,
				RecipeTechRegistry.COOKING_POT,
				new Ingredient[]{
						new Ingredient("humanmeat", 1)
				}
		).showAfter("cappuccino"));

		// Fix raider mob loot table since, the patch doesn't work on this (probably because of overwrite)
		HumanRaiderMob.lootTable.items.add(LootItem.between("humanmeat", 1, 5));

		// Register (debug) command
		CommandsManager.registerServerCommand(new SanityCommand());

		// Add new OFTEN field to GameRaidFrequency
		EnumHelper.addEnum(GameRaidFrequency.class, "OFTEN", new Class[] {GameMessage.class, GameMessage.class}, new LocalMessage("ui", "raidsoften"), null);
	}
}
