package net.lifemc.chat.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReportCommand extends Command {

	public ReportCommand() {
		super("report");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (args.length < 2) {
			sender.sendMessage(new ComponentBuilder("Error > ").color(ChatColor.DARK_RED).bold(true).append("Not enough arguments! /report <player> <reason>").color(ChatColor.RED).bold(false).create());
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

		for (ProxiedPlayer staff : ProxyServer.getInstance().getPlayers()) {
			if (staff.hasPermission("staff.report.receive")) {
				staff.sendMessage(new ComponentBuilder("Report ").color(ChatColor.DARK_RED).bold(true)
						.append(player.getName()).color(ChatColor.WHITE).bold(false)
						.append(" > " + sb.toString()).color(ChatColor.RED)
						.create());
			}
		}

		sender.sendMessage(new ComponentBuilder("Report >").bold(true).color(ChatColor.GREEN)
				.append(" You have succesfully reported " + args[0] + "!").bold(false).color(ChatColor.GRAY).create());
	}
}
