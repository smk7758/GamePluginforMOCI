package com.github.smk7758.GamePluginforMOCI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandExecuter implements CommandExecutor {
	public Main main = null;

	public CommandExecuter(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("GamePluginforMOCI")) {
			if (args.length < 1) {
				SendLog.send("This is the plugin for MOCI.", sender);
				SendLog.send("args: active", sender);
			} else if (args[0].equalsIgnoreCase("active")) {
				Main.active = !Main.active;
				SendLog.send("Active status: " + Main.active, sender);
			}
			return true;
		}
		return false;
	}
}
