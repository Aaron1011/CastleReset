package io.github.Aaron1011.CastleReset;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.FactionColls;
import com.massivecraft.factions.entity.UPlayer;

public class CastleReset extends JavaPlugin {

	private final String prismString = "prism rollback r:we ";

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("reset_castles")){ // If the player typed /basic then do the following...
			sender.sendMessage("Hello world!");
			resetCastles(sender);
			return true;
		} //If this has happened the function will return true.
	        // If this hasn't happened the a value of false will be returned.
		return false;
	}

	private void resetCastles(CommandSender sender) {
		for (FactionColl fc : FactionColls.get().getColls())
		{
		    for (Faction f : fc.getAll())
		    {
		    	List<UPlayer> players = f.getUPlayers();
		    	String playerNames = "";
		    	for (int i = 0; i < players.size(); i++) {
		    		playerNames = playerNames.concat("p:!" + players.get(i).getName() + " ");
		    		sender.sendMessage("Player: " + players.get(i).getName());
		    	}
		    	Bukkit.getServer().dispatchCommand(sender, "/pos1 27,236,-132");
		    	Bukkit.getServer().dispatchCommand(sender, "/pos2 13,236,-124");
		    	if (playerNames.length() != 0)
			    	sender.sendMessage(prismString + playerNames);
		    		Bukkit.getServer().dispatchCommand(sender, prismString + playerNames);

		        sender.sendMessage(f.getUniverse() + " - " + f.getName());
		    }
		}

	}


}
