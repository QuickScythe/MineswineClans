package me.athena222.clans.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Staff implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console cannot use /staff!");
			sender.sendMessage("Support for this coming soon");
			return true;
		}
	
		ArrayList<Player> onlinestaff = new ArrayList<Player>(); 
		final String prefix = ChatColor.YELLOW + "" + ChatColor.BOLD + "Staff" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "";	
		final Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("staff") && (player.hasPermission("members.liststaff"))) { 
			
			for(Player players : Bukkit.getOnlinePlayers()) {
				
				if(players.hasPermission("staff.list")) {
					onlinestaff.add(players);
				}	
				else if (onlinestaff.isEmpty()) {
					player.sendMessage(prefix + "There are no staff online right now.");
				}			 	
			}		

			StringBuilder sb = new StringBuilder();
			for(Player string : onlinestaff) {
				sb.append(string.getDisplayName()).append(ChatColor.GRAY + ", ");
			}
		    String output = sb.toString(); 

			player.sendMessage(prefix + output);
			
		}
		else if(!player.hasPermission("members.liststaff")) {
			player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
		}
		return true;
	}	
}