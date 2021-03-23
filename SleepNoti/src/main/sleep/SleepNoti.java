package main.sleep;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import main.sleep.events.JoinLeaveBed;
import main.sleep.expansion.SleepExp;

public class SleepNoti extends JavaPlugin {
	
	private static SleepNoti instance;
	
	public void onEnable() {
		
		instance = this;
		
		registerEvents();
		
		new SleepExp().register();
		
		if(!getDataFolder().exists()) {
			
			getDataFolder().mkdirs();
			
		}
		
		saveDefaultConfig();
		
		reloadConfig();
		
        Bukkit.getConsoleSender().sendMessage("[SleepNoti] " + ChatColor.GREEN + "Successfully Hooked into PAPI!");
		
	}
	
	private void registerEvents() {
		
		Bukkit.getPluginManager().registerEvents(new JoinLeaveBed(), this);
		
	}
	
	public static SleepNoti getInstance() {
		
		return instance;
		
	}
	
}
