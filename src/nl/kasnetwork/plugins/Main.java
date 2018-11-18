package nl.kasnetwork.plugins;


import java.io.IOException;

/////////////////////////////////
//Don't change above this      //
//                            //
//                           //
//All rights go to		    //
//IkasCoding			   //
////////////////////////////

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.horizoncode.anticheat.AntiCheatAPI;
import net.horizoncode.anticheat.checkbase.CheckManager;

public class Main extends JavaPlugin {
	/////////////////////////////////////////////////////
	//YOU ARE NOT ALLOWED TO DECOMPILE THIS CODE!!!!  //
	//I WILL FIND YOU IF YOU RERELEASE THIS CODE!!!! //
	//OR IF YOU PUBLISH IT!							//
	/////////////////////////////////////////////////
	
//////////////////////////////////
//Don't change above this      //
//							  //
//							 //
//All rights go to		    //
//IkasCoding			   //
////////////////////////////
	
	
	@SuppressWarnings("unused")
	public void onEnable() {
		
		///////////////////////////////////////
		//Metrics Initialize and Implementor//
		/////////////////////////////////////
		
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			 /////////////////////////////////////////////////////
			//Failed to submit the statistics if this is executed xD//
		   /////////////////////////////////////////////////////
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
