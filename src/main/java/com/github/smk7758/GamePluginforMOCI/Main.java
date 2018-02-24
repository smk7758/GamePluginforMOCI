package com.github.smk7758.GamePluginforMOCI;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static final String plugin_name = "GamePluginforMOCI";
	public static boolean debug_mode = false;
	// private CommandExecuter command_executer = new CommandExecuter(this);
	private GameListener game_listner = new GameListener(this);

	@Override
	public void onEnable() {
		if (!Main.plugin_name.equals(getDescription().getName())) getPluginLoader().disablePlugin(this);
		getServer().getPluginManager().registerEvents(game_listner, this);
		// getCommand(plugin_name).setExecutor(command_executer);
	}

	@Override
	public void onDisable() {
	}

	// public CommandExecuter getCommandExecuter() {
	// return command_executer;
	// }
}
