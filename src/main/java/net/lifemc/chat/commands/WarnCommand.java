package net.lifemc.chat.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class WarnCommand extends Command {

	public WarnCommand() {
		super("warn", "staff.warn");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (args.length < 2) {
			sender.sendMessage(new ComponentBuilder("Error > ").color(ChatColor.DARK_RED).bold(true).append("Not enough arguments.").color(ChatColor.RED).bold(false).create());
			return;
		}

		ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
		if (player == null || !player.isConnected()) {
			sender.sendMessage(new ComponentBuilder("Error > ").color(ChatColor.DARK_RED).bold(true).append(args[0] + " is not online.").color(ChatColor.RED).bold(false).create());
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			sb.append(args[i] + " ");
		}
		player.sendMessage(new ComponentBuilder("Warning > ").color(ChatColor.DARK_RED).bold(true).append("You have been warned. Reason: " + sb.toString()).bold(false).color(ChatColor.RED).create());
		sender.sendMessage(new ComponentBuilder("FuturePrefix > ").color(ChatColor.DARK_RED).bold(true).append("Warned " + args[0] + ". Reason: " + sb.toString()).bold(false).color(ChatColor.RED).create());
	}
}
