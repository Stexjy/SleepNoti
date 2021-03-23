package main.sleep.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import main.sleep.SleepNoti;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;

public class JoinLeaveBed implements Listener {
	
	@EventHandler
	public void onBedEnter(PlayerBedEnterEvent e) {
		
		if(e.getBedEnterResult().equals(BedEnterResult.OK)) {
			
			if(SleepNoti.getInstance().getConfig().getBoolean("enter_enabled")) {
				
				new BukkitRunnable() {
					
					public void run() {
						
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', 
								PlaceholderAPI.setPlaceholders(null, 
								SleepNoti.getInstance().getConfig().getString("enter_bed"))
								.replace("[playername]", e.getPlayer().getName())));
						
					}
					
				}.runTaskLaterAsynchronously(SleepNoti.getInstance(), 0);
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onBedLeave(PlayerBedLeaveEvent e) {
		
		if(!(Bukkit.getWorld("world").getTime() < 12300 || Bukkit.getWorld("world").getTime() > 23850)) {
    		
			if(SleepNoti.getInstance().getConfig().getBoolean("leave_enabled")) {
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', 
						PlaceholderAPI.setPlaceholders(null, 
						SleepNoti.getInstance().getConfig().getString("leave_bed"))
						.replace("[playername]", e.getPlayer().getName())));
				
			}
    		
    	}
		
	}
	
}
