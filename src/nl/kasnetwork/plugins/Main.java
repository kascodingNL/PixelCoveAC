package nl.kasnetwork.plugins;


import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.horizoncode.anticheat.AntiCheatAPI;
import net.horizoncode.anticheat.checkbase.CheckManager;

public class Main extends JavaPlugin {
	
	
	@SuppressWarnings("unused")
	public void onEnable() {
	
		
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
		}
		
		
		
		
		this.saveDefaultConfig();
		this.getConfig();
		FileConfiguration config = this.getConfig();
		config.addDefault("Enabled", false);
		config.options().copyDefaults(true);
		saveConfig();
		
		//AntiCheatAPI enabler
		AntiCheatAPI ac = AntiCheatAPI.getNewAPI("PixelCoveAntiCheat");
		
		//Sprint Check
		CheckManager.registerCheck(new Sprint());
		CheckManager.registerCheck(new Fly());
		if (config.getBoolean("Enabled")) {
			Bukkit.getPluginManager().disablePlugin(Main.getPlugin(null));
		}
	}

}
