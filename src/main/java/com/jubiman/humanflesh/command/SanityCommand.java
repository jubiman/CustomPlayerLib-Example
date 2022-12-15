package com.jubiman.humanflesh.command;

import com.jubiman.customplayerlib.CustomPlayerRegistry;
import com.jubiman.humanflesh.sanity.SanityPlayer;
import com.jubiman.humanflesh.sanity.SanityPlayers;
import necesse.engine.commands.CmdParameter;
import necesse.engine.commands.CommandLog;
import necesse.engine.commands.ModularChatCommand;
import necesse.engine.commands.PermissionLevel;
import necesse.engine.commands.parameterHandlers.IntParameterHandler;
import necesse.engine.commands.parameterHandlers.StringParameterHandler;
import necesse.engine.network.client.Client;
import necesse.engine.network.server.Server;
import necesse.engine.network.server.ServerClient;

public class SanityCommand extends ModularChatCommand {
	public SanityCommand() {
		super("sanity", "Changing your sanity value", PermissionLevel.ADMIN, true, new CmdParameter("string", new StringParameterHandler()), new CmdParameter("int", new IntParameterHandler(), true));
	}

	@Override
	public void runModular(Client client, Server server, ServerClient serverClient, Object[] args, String[] errors, CommandLog commandLog) {
		switch ((String) args[0]) {
			case "set":
				((SanityPlayer) CustomPlayerRegistry.get("sanityplayers").get(serverClient.authentication)).setSanity((int) args[1]);
				break;
			case "add":
				((SanityPlayer) CustomPlayerRegistry.get("sanityplayers").get(serverClient.authentication)).addSanity((int) args[1]);
				break;
			case "remove":
				((SanityPlayer) CustomPlayerRegistry.get("sanityplayers").get(serverClient.authentication)).removeSanity((int) args[1]);
				break;
			case "get":
				commandLog.add("Sanity: " + ((SanityPlayer) CustomPlayerRegistry.get("sanityplayers").get(serverClient.authentication)).getSanity());
				return;
		}
		commandLog.add("Sanity set to " + ((SanityPlayer) CustomPlayerRegistry.get("sanityplayers").get(serverClient.authentication)).getSanity());
	}
}
