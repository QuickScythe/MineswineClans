package me.athena222.clans.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.athena222.clans.handlers.Clan;

public class ClanList implements CommandExecutor {

	Clan clans = new Clan();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console cannot use /clans!");
			return true;
		}
		
		final Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("clans") && (player.hasPermission("member.clanlist"))) {
			player.sendMessage(ChatColor.YELLOW + "Listing all clans...");
			
		    if(clans.getAllClans().isEmpty()) {
				player.sendMessage(ChatColor.GRAY + "There are no clans!");
			}
		    
		    if(!clans.getAllClans().isEmpty()) {
			
		    	StringBuilder sb = new StringBuilder();
				for(Clan string : clans.getAllClans()) {
					sb.append(string).append(", ");
				}
				String output = sb.toString().trim();
			
				player.sendMessage(output);		
		    }
		}	
		else if(!player.hasPermission("member.clanlist")) {
			player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
		}
		return true;
	}
}