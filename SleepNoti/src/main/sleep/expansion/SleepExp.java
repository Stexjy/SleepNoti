package main.sleep.expansion;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import main.sleep.SleepNoti;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class SleepExp extends PlaceholderExpansion {
	
    /**
     * This method should always return true unless we
     * have a dependency we need to make sure is on the server
     * for our placeholders to work!
     *
     * @return always true since we do not have any dependencies.
     */
    @Override
    public boolean canRegister(){
    	
        return true;
    }

    /**
     * The name of the person who created this expansion should go here.
     * 
     * @return The name of the author as a String.
     */
    @Override
    public String getAuthor(){
        return "Stexjy";
    }
    
    /**
     * The placeholder identifier should go here.
     * <br>This is what tells PlaceholderAPI to call our onRequest 
     * method to obtain a value if a placeholder starts with our 
     * identifier.
     * <br>The identifier has to be lowercase and can't contain _ or %
     *
     * @return The identifier in {@code %<identifier>_<value>%} as String.
     */
    @Override
    public String getIdentifier(){
        return "sleepnoti";
    }

    /**
     * This is the version of this expansion.
     * <br>You don't have to use numbers, since it is set as a String.
     *
     * @return The version as a String.
     */
    @Override
    public String getVersion(){
        return "1.0.0";
    }
    
    public String getName() {
    	
    	return "SleepNoti";
    	
    }
    
    /**
     * This is the method called when a placeholder with our identifier 
     * is found and needs a value.
     * <br>We specify the value identifier in this method.
     * <br>Since version 2.9.1 can you use OfflinePlayers in your requests.
     *
     * @param  player
     *         A {@link org.bukkit.OfflinePlayer OfflinePlayer}.
     * @param  identifier
     *         A String containing the identifier/value.
     *
     * @return Possibly-null String of the requested identifier.
     */
    @Override
    public String onRequest(OfflinePlayer player, String identifier){
    	
        if(identifier.equals("sleepingplayer")){
        	
        	int i = 0;
        	
        	for(Player p : Bukkit.getOnlinePlayers()) {
        		
        		if(p.isSleeping())
        			i++;
        		
        	}
        	
            return i + "";
            
        }

        if(identifier.equals("notsleepplayer")){
        	
        	int i = 0;
        	
        	for(Player p : Bukkit.getOnlinePlayers()) {
        		
        		if(!p.isSleeping())
        			i++;
        		
        	}
        	
            return i + "";
            
        }
        
        if(identifier.equals("totalplayer")){
        	
            return Bukkit.getOnlinePlayers().size() + "";
            
        }
        
        if(identifier.equals("sentence")){
        	
        	if(Bukkit.getWorld("world").getTime() < 12300 || Bukkit.getWorld("world").getTime() > 23850) {
        		
        		return "";
        		
        	}
        	
            return PlaceholderAPI.setPlaceholders(null, SleepNoti.getInstance().getConfig().getString("sentence_placeholder"));
            
        }
        
		return null;
        
    }
}
