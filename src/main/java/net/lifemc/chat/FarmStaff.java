package net.lifemc.chat;

import net.lifemc.chat.commands.KickCommand;
import net.lifemc.chat.commands.ReportCommand;
import net.lifemc.chat.commands.WarnCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class FarmStaff extends Plugin {

	@Override
	public void onEnable() {
		// Plugin startup logic
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new WarnCommand());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new ReportCommand());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new KickCommand());
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	/*
	- Report -> Send a broadcast to all online staff		In Progress.
	- Warn -> Warn a player with a reason 					To be tested.
	- StaffChat -> Switch to a private staff chat.			Not started.
	- Kick -> Kick a player									To be tested.
	 */
}
