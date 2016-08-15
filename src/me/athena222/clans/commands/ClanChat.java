package me.athena222.clans.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.athena222.clans.handlers.Clan;

public class ClanChat implements CommandExecutor { // Add toggle command ability?

	Clan clans = new Clan();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console cannot use /clanchat!");
			return true;
		}
		
		final Player player = (Player) sender;
		// Make a variable in main?
		String prefix = ChatColor.YELLOW + "" + ChatColor.BOLD + "Clans" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "";
		
		if(args.length == 0) {
			
			if(cmd.getName().equalsIgnoreCase("clanchat")) {
				player.sendMessage(prefix + "Incorrect usage! /clanchat <text>");
			}
		}
		
		if(args.length == 1) {
			
			if(clans.isInClan(player)) {
				
				//for(Player players : clans.getPlayersInClan(player, clans.getClan(player))) {}
			}	
			else if(clans.isInClan(player)) {
				player.sendMessage(prefix + "You are not in a clan.");
			}
			
		}
		
		return true;
	}	
}
/*

if {inclan.%player%} is true:

 loop all players:
     if loop-player has permission "mod.clanspy":
         send message "&2&lCC&7/&a%{joinedclan.%player%}%&7/&f%player%: &f%arg text%" to loop-player
     else if {joinedclan.%loop-player%} is "%{joinedclan.%player%}%":
         send message "&2&lCC&7/&a%{joinedclan.%player%}%&7/&f%player%: &f%arg text%" to loop-player

*/