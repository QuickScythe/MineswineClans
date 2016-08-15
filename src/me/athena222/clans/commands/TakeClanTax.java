package me.athena222.clans.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.athena222.clans.handlers.Clan;
import net.md_5.bungee.api.ChatColor;

public class TakeClanTax implements CommandExecutor {

	Clan clans = new Clan();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {		
			sender.sendMessage("Console cannot use /takeclantax"); // it has to have /takeclantax for it to work ;-;
			return true;
		}
		
		final Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("takeclantax") && (player.hasPermission("admin.clantax"))) {
			
			for(Player players : Bukkit.getOnlinePlayers()) { 
				players.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Clans" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Daily tax was taken.");
							
				//for(Clan clans : clans.getAllClans()) {
				//	clans.getBank(clans).remove(30);
					
					//if(clans.getBank(clans) > 30) {
					//	players.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Clans" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "'s clan couldn't pay the tax!");
					//}
				//}		
			}
			
		//	player.sendMessage(pl.getBank(""));
		}
		else if(!player.hasPermission("admin.clantax")) {
			player.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
		}
		
		return true;
	}
	
}
/*
        loop {clanlist::*}:
            set {clan.%loop-value%.tpactive} to true
            
            if {clan.%loop-value%.bank} is less than 70*{clan.%loop-value%.membercount}+10:
            
                broadcast "&e&lClans&8> &7%{clan.%loop-value%.owner}%'s clan couldn't pay the tax!"
                
                set {clan.%loop-value%.taken} to false
                
                add {clan.%loop-value%.bank} to {clan.%loop-value%.owner}'s balance
                
                set {disbanding.clan.name} to "%loop-value%"
                
                set {clan.%loop-value%.owner} to "NONE"
                
                remove loop-value from {clanlist::*}
                
                set {clan.%loop-value%.membercount} to 0
                
                set {clan.%loop-value%.bank} to 0
                
                set {clan.%loop-value%.membercount} to 0
                
                if {clan.%loop-value%.base} is true:
                
                    set line 4 of block at {clanbase.%{clan.%loop-value%.basename}%.mainsign} to "%{clanbase.%{clan.%loop-value%.basename}%.price}%"
                    
                    set {clanbase.%{clan.%loop-value%.basename}%.claimed} to false
                    
                    set {clanbase.%{clan.%loop-value%.basename}%.clan} to "NONE"
                    
                loop {clanmembers_%loop-value%::*}:
                
                    remove loop-value-2 from {clanmembers_%{disbanding.clan.name}%::*}
                    
                    set {inclan.%loop-value-2%} to false
                    
                    send message "&e&lClans&8> &7Your clan couldn't pay the tax and was disbanded." to loop-value-2
                    
                    make console execute command "p u %loop-value-2% remove jediclans.clanchat.%{disbanding.clan.name}%@jedicraft"
                    
                    make console execute command "pex user %loop-value-2% remove jediclans.clanchat.%{disbanding.clan.name}%"
                    
                    set {joinedclan.%loop-value-2%} to NONE
                    
                clear {clanmembers_%{disbanding.clan.name}%::*}
                
            else:
            
                remove 70*{clan.%loop-value%.membercount}+10 from {clan.%loop-value%.bank}
*/