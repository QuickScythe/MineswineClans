package me.athena222.clans.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fakekill implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console cannot fake kill players.");
			sender.sendMessage("Support for this coming soon");
			return true;
		}
		
		final Player player = (Player) sender;
		String killPrefix = ChatColor.DARK_RED + "[" + ChatColor.RED + "➵" + ChatColor.DARK_RED + "]" + ChatColor.WHITE + " ";
		
        StringBuilder arg1 = new StringBuilder();    
        for (int i = 0; i < args.length; i++) arg1.append(args[i] + " ");
        String victim = arg1.toString();
        
		if(args.length == 0) {
			
			if(cmd.getName().equalsIgnoreCase("fakekill") && (player.hasPermission("admin.fakekill"))) {
				player.sendMessage(ChatColor.RED + "Invalid Usage!");
				player.sendMessage(ChatColor.DARK_RED + "/fakekill <victim>" + ChatColor.RED + " or");
				player.sendMessage(ChatColor.DARK_RED + "/fakekill <victim> <killer>");
			}
			else if(!player.hasPermission("admin.fakekill")) {
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
			}	
		}
		
		if(args.length == 1) {
            for(Player players : Bukkit.getOnlinePlayers()) {
            	players.sendMessage(killPrefix + victim + ChatColor.GRAY + "has died.");
            }       
		}
		// add else invalid argument statements
	   if(args.length == 2) {		
			// put an else statement in here
		
			StringBuilder arg2 = new StringBuilder();
			for (int i = 1; i < args.length; i++) arg2.append(args[i] + " ");
			String killer = arg2.toString();
			
            for(Player players : Bukkit.getOnlinePlayers()) {
            	players.sendMessage(killPrefix + victim + ChatColor.GRAY + " has been killed by " + ChatColor.WHITE + killer);
           	}         
		}		
		return true;
	}
}