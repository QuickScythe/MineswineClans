package me.athena222.clans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClanAdmin implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console cannot use /clanadmin!");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(args.length == 0) {		
			if(cmd.getName().equalsIgnoreCase("clanadmin") && (player.hasPermission("admin.clan"))) {
			
			}
		}
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("create")) {
				
			}
			else if(args[0].equalsIgnoreCase("disband")) {
				
			}
			else if(args[0].equalsIgnoreCase("base")) {
				
			}
		}
		
		if(args.length == 2) {
			if(args[1].equalsIgnoreCase("set")) {
				
			}
			else if(args[1].equalsIgnoreCase("set") && (args[0].equalsIgnoreCase("disband"))) {
				
			}
			else if(args[1].equalsIgnoreCase("set") && (args[0].equalsIgnoreCase("create"))) {
				
			}
			else if(args[1].equalsIgnoreCase("sethome") || (args[1].equalsIgnoreCase("sh") && (args[0].equalsIgnoreCase("base")))) {
				
			}
			else if(args[1].equalsIgnoreCase("create") || (args[0].equalsIgnoreCase("base"))) {
				
			}
		}
		
		return true;
	}	
}
/*

command /clanadmin [<text>] [<text>] [<text>] [<integer>]:
    description: Clan admin commands.
    permission: admin.clan
    aliases: cadmin, adminclan
    trigger:
        if arg 1 is "create":
            if arg 2 is set:
                set {clan.%arg 2%.tpactive} to true
                set {clan.%arg 2%.taken} to true
                set {clan.%arg 2%.bank} to 1000000
                set {clan.%arg 2%.flag} to false
                set {clan.%arg 2%.owner} to "NONE"
                add arg 2 to {clanlist::*}
                set {clan.%arg 2%.membercount} to 1
                add "Admin_Clan" to {clanmembers_%arg 2%::*}
                stop
            else:
                message "&e&lClans&8> &7/clanadmin create <clan>."
        if arg 1 is "disband":
            if arg 2 is set:
                set {clan.%arg 2%.tpactive} to true
                set {clan.%arg 2%.taken} to false
                set {clan.%arg 2%.flag} to false
                add {clan.%arg 2%.bank} to {clan.%arg 2%.owner}'s balance
                set {disbanding.clan.name} to "%arg 2%"
                set {clan.%arg 2%.owner} to "NONE"
                remove arg 2 from {clanlist::*}
                set {clan.%arg 2%.membercount} to 0
                set {clan.%arg 2%.bank} to 0
                set {clan.%arg 2%.membercount} to 0
                if {clan.%arg 2%.base} is true:
                    set line 4 of block at {clanbase.%{clan.%arg 2%.basename}%.mainsign} to "%{clanbase.%{clan.%arg 2%.basename}%.price}%"
                    set {clanbase.%{clan.%arg 2%.basename}%.claimed} to false
                    set {clanbase.%{clan.%arg 2%.basename}%.clan} to "NONE"
                loop {clanmembers_%arg 2%::*}:
                    remove loop-value from {clanmembers_%arg 2%::*}
                    set {inclan.%loop-value%} to false
                    send message "&e&lClans&8> &7Your clan was disbanded by an admin." to loop-value
                    make console execute command "p u %loop-value% remove jediclans.clanchat.%{disbanding.clan.name}%@jedicraft"
                    make console execute command "pex user %loop-value% remove jediclans.clanchat.%{disbanding.clan.name}%"
                    set {joinedclan.%loop-value%} to "NONE"
                clear {clanmembers_%arg 2%::*}
                stop
            else:
                message "&e&lClans&8> &7/clanadmin disband <clan>."
        if arg 1 is "base":
            if arg 2 is "sethome" or "sh":
                if arg 3 is set:
                    set {clanbase.%arg 3%.home} to location of player
                    message "&e&lClans&8> &7Set home point for %arg 3%."
                    stop
            if arg 2 is "create" or "c":
                if targeted block is sign:
                    if arg 3 is set:
                        if arg 4 is greater than 0:
                            set {clanbase.%arg 3%.claimed} to false
                            set {clanbase.%arg 3%.clan} to "NONE"
                            set {clanbase.%arg 3%.price} to arg 4
                            set {clanbase.%arg 3%.mainsign} to position of targeted block
                            set line 1 of targeted block to "[Clan]"
                            set line 2 of targeted block to "Base"
                            set line 3 of targeted block to "%arg 3%"
                            set line 4 of targeted block to "%arg 4%"
                            add arg 3 to {clanbases::*}
                            message "&e&lClans&8> &7Base '%arg 3%' created."
                        else:
                            message "&e&lClans&8> &7/clanadmin base create <name> <price>."
                    else:
                        message "&e&lClans&8> &7/clanadmin base create <name> <price>."
                else:
                    message "&e&lClans&8> &7Look at a sign while typing this."
            else:
                message "&e&lClans&8> &7/clanadmin base <create/sethome>."
        else:
            message "&e&lClans&8> &7/clanadmin <base/create/disband>."


*/