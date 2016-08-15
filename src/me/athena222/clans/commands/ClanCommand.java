package me.athena222.clans.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.athena222.clans.handlers.Clan;

public class ClanCommand implements CommandExecutor {

	Clan clans = new Clan();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console cannot use Clans commands!");
			sender.sendMessage("Support for this will be added soon.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(args.length == 0) {
		
			if(cmd.getName().equalsIgnoreCase("clan") && (player.hasPermission("member.clan"))) {				
			
				if(clans.isInClan(player)) { 
					player.sendMessage(ChatColor.WHITE + "=-=-=-=-=" + ChatColor.YELLOW + "CLANS" + ChatColor.WHITE + "=-=-=-=-=");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan create <name> " + ChatColor.GREEN + "(Costs $100,000)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan invite <name> " + ChatColor.GREEN + "(Invite a player)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan join <name> " + ChatColor.GREEN + "(Join a clan)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan leave " + ChatColor.GREEN + "(Leave your clan)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan rank <name> " + ChatColor.GREEN + "(Toggle rankup)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan kick <player> " + ChatColor.GREEN + "(Kick a player)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan invite <name> " + ChatColor.GREEN + "(Disband your clan)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan base " + ChatColor.GREEN + "(Travel to clan base)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan info <name> " + ChatColor.GREEN + "(Clan statistics)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan list " + ChatColor.GREEN + "(List all clans)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan bank " + ChatColor.GREEN + "(Displays money for clan shop/upkeep costs)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clanchat <message> " + ChatColor.GREEN + "(Send a clan message)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clanmoney deposit <amount> [clan] " + ChatColor.GREEN + "(Donate to a clan)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clanmoney withdraw <amount> [clan] " + ChatColor.GREEN + "(Withdraw money from your clan)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan flag " + ChatColor.GREEN + "(PIGLET ONLY)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan shop " + ChatColor.GREEN + "(Buy clan upgrades)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan broadcast " + ChatColor.GREEN + "(BOAR ONLY)");
				}
				else if(!clans.isInClan(player)) {
					player.sendMessage(ChatColor.WHITE + "=-=-=-=-=" + ChatColor.YELLOW + "CLANS" + ChatColor.WHITE + "=-=-=-=-=");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan create <name> " + ChatColor.GREEN + "(Costs $100,000)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan join <clan> " + ChatColor.GREEN + "(Join a clan)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan info <clan/player> " + ChatColor.GREEN + "(Clan statistics)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clan list " + ChatColor.GREEN + "(List all clans)");
					player.sendMessage(ChatColor.YELLOW + "• " + ChatColor.WHITE + "/clanmoney donate <clan> <amount> " + ChatColor.GREEN + "(Donate to a clan)");		
				}
			}
			else if(!player.hasPermission("member.clan")) {
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
			}
		}	
		
		if(args.length == 1) {
		
			if(args[0].equalsIgnoreCase("list")) {
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
			else if(args[0].equalsIgnoreCase("home") || (args[0].equalsIgnoreCase("gohome") || (args[0].equalsIgnoreCase("base")))) {
				
				if(clans.isInClan(player) && (clans.clanHasBase())) {
					player.sendMessage(clans.clanPrefix + "Teleporting you to home in 10 seconds...");
					clans.getClanBase(clans.getClan(player));
				}
				else if(!clans.isInClan(player)) { 
					player.sendMessage(clans.clanPrefix + "You do not have a clan!");
				}
				else if(!clans.clanHasBase()) {
					player.sendMessage(clans.clanPrefix + "Your clan doesn't have a base.");
				}
				/*
				if arg 1 is "home" or "gohome" or "base":
		       
            if {clan.%{joinedclan.%player%}%.base} is true:
            
                message "&e&lClans&8> &7Teleporting you home in 10 seconds..."
                wait 10 seconds
                teleport player to {clanbase.%{clan.%{joinedclan.%player%}%.basename}%.home}
              
            else:
                message "&e&lClans&8> &7Your clan doesn't have a base."
   
				 */
			}
			else if(args[0].equalsIgnoreCase("bank")) {
				
			//	player.sendMessage(clans.getBank(clans.getClan(player)));
				
			//	player.sendMessage(clans.getBalance(clans.getClan(player));
				
				/*
				 *   if arg 1 is "bank" or "b":
            if {inclan.%player%} is true:
                message "&e&lClans&8> &7Current clan bank balance is $%{clan.%{joinedclan.%player%}%.bank}%."
                message "&e&lClans&8> &7Current daily upkeep cost is $%70*{clan.%{joinedclan.%player%}%.membercount}+10%."
                message "&e&lClans&8> &7Days until bankrupt: %{clan.%{joinedclan.%player%}%.bank}/(70*{clan.%{joinedclan.%player%}%.membercount}+10)%."
                stop
            else:
                message "&e&lClans&8> &7You are not in a clan."
                stop

				 */	
			}
			else if(args[0].equalsIgnoreCase("broadcast")) {
				/*
				 *   if arg 1 is "broadcast" or "bc":
            if {inclan.%player%} is true:
                if {clan.%{joinedclan.%player%}%.shop.broadcast} is true:
                    if {clan.%{joinedclan.%player%}%.bcactive} is true:
                        if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                            if arg 2 is set:
                                set {clan.%{joinedclan.%player%}%.bcactive} to false
                                if arg 3 is set:
                                    broadcast "&e[%{joinedclan.%player%}%] &a%arg 2% %arg 3%"
                                    stop
                                else:
                                    broadcast "&e[%{joinedclan.%player%}%] &a%arg 2%"
                                    stop
                            else:
                                message "&e&lClans&8> &7/clan broadcast <message>."
                                stop
                        if {clan.%{joinedclan.%player%}%.elder.%player%} is true:
                            if arg 2 is set:
                                set {clan.%{joinedclan.%player%}%.bcactive} to false
                                if arg 3 is set:
                                    broadcast "&e[%{joinedclan.%player%}%] &a%arg 2% %arg 3%"
                                    stop
                                else:
                                    broadcast "&e[%{joinedclan.%player%}%] &a%arg 2%"
                                    stop
                            else:
                                message "&e&lClans&8> &7/clan broadcast <message>."
                                stop
                        else:
                            message "&e&lClans&8> &7You are not an elder."
                            stop
                    else:
                        message "&e&lClans&8> &7You need to wait until tomorrow to use this."
                        stop
                else:
                    message "&e&lClans&8> &7Your clan has not purchased this feature."
                    stop
            else:
                message "&e&lClans&8> &7You are not in a clan."
                stop

				 */
			}
			else if(args[0].equalsIgnoreCase("tphere")) {
				/*
				 *                 if arg 1 is "tphere" or "tp":
            if {inclan.%player%} is true:
                if {clan.%{joinedclan.%player%}%.shop.tp} is true:
                    if {clan.%{joinedclan.%player%}%.tpactive} is true:
                        if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                            message "&e&lClans&8> &7Summoning all online members to you."
                            set {clan.%{joinedclan.%player%}%.tpactive} to false
                            set {clantp.point} to location of player
                            wait 5 seconds
                            loop all players:
                                if {joinedclan.%loop-player%} is "%{joinedclan.%player%}%":
                                    teleport loop-player to {clantp.point}
                            stop
                        if {clan.%{joinedclan.%player%}%.elder.%player%} is true:
                            message "&e&lClans&8> &7Summoning all online members to you."
                            set {clan.%{joinedclan.%player%}%.tpactive} to false
                            set {clantp.point} to location of player
                            wait 5 seconds
                            loop all players:
                                if {joinedclan.%loop-player%} is "%{joinedclan.%player%}%":
                                    teleport loop-player to {clantp.point}
                            stop
                        else:
                            message "&e&lClans&8> &7You are not an elder."
                            stop
                    else:
                        message "&e&lClans&8> &7You need to wait until tomorrow to use this."
                        stop
                else:
                    message "&e&lClans&8> &7Your clan has not purchased this feature."
                    stop
            else:
                message "&e&lClans&8> &7You are not in a clan."
                stop

				 */
			}
			else if(args[0].equalsIgnoreCase("shop")) {
				/*
				 *       if arg 1 is "shop":
            if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                message "&eClan Shop: &f%{joinedclan.%player%}%"
                message "&fBank: &7$%{clan.%{joinedclan.%player%}%.bank}%."
                if {clan.%{joinedclan.%player%}%.shop.tp} is true:
                    message "&fDaily TP: &7Reset daily cooldown."
                    message "&6/cshop buy Teleport"
                else:
                    message "&fDaily TP: &7Summon all online clan members to you. &eAVAILABLE"
                    message "&6/cshop buy Teleport"
                if {clan.%{joinedclan.%player%}%.shop.advert} is true:
                    message "&fClan Broadcast: &7Reset daily cooldown."
                    message "&6/cshop buy Broadcast"
                else:
                    message "&fClan Broadcast: &7Broadcast a message. &eAVAILABLE TO BOAR"
                    message "&6/cshop buy Broadcast"
                message "&fIncrease Membercap: &7Get 5 more member slots. &eAVAILABLE TO BOAR"
                message "&6/cshop buy +5 Members"
                stop
            else:
                message "&e&lClans&8> &7You are not the owner of a clan."
                stop

				 */
			}
			else if(args[0].equalsIgnoreCase("leave")) {
				/*
				 *           if arg 1 is "leave" or "l":
            if {inclan.%player%} is true:
                if player's name is "%{clan.%{joinedclan.%player%}%.owner}%":
                    message "&e&lClans&8> &7Your clan has been disbanded."
                    set {clan.%{joinedclan.%player%}%.taken} to false
                    set {disbanding.clan.name} to "%{joinedclan.%player%}%"
                    set {inclan.%player%} to false
                    set {clan.%{joinedclan.%player%}%.owner} to "NONE"
                    remove {joinedclan.%player%} from {clanlist::*}
                    make console execute command "p u %player% remove jediclans.clanchat.%{disbanding.clan.name}%@jedicraft"
                    make console execute command "pex user %player% remove jediclans.clanchat.%{disbanding.clan.name}%"
                    set {clan.%{joinedclan.%player%}%.membercount} to 0
                    add {clan.%{joinedclan.%player%}%.bank} to the player's balance
                    set {clan.%{joinedclan.%player%}%.bank} to 0
                    set {clan.%{joinedclan.%player%}%.membercount} to 0
                    if {clan.%{joinedclan.%player%}%.base} is true:
                        set line 4 of block at {clanbase.%{clan.%{joinedclan.%player%}%.basename}%.mainsign} to "%{clanbase.%{clan.%{joinedclan.%player%}%.basename}%.price}%"
                        set {clanbase.%{clan.%{joinedclan.%player%}%.basename}%.claimed} to false
                        set {clanbase.%{clan.%{joinedclan.%player%}%.basename}%.clan} to "NONE"
                    loop {clanmembers_%{joinedclan.%player%}%::*}:
                        remove loop-value from {clanmembers_%{joinedclan.%player%}%::*}
                        set {inclan.%loop-value%} to false
                        send message "&e&lClans&8> &7Your clan was disbanded." to loop-value
                        make console execute command "p u %loop-value% remove jediclans.clanchat.%{disbanding.clan.name}%@jedicraft"
                        make console execute command "pex user %loop-value% remove jediclans.clanchat.%{disbanding.clan.name}%"
                        set {joinedclan.%loop-value%} to NONE
                    clear {clanmembers_%{disbanding.clan.name}%::*}
                    stop
                else:
                    message "&e&lClans&8> &7You have left '%{joinedclan.%player%}%'."
                    remove player from {clanmembers_%{joinedclan.%player%}%::*}
                    set {inclan.%player%} to false
                    remove 1 from {clan.%{joinedclan.%player%}%.membercount}
                    make console execute command "p u %player% remove jediclans.clanchat.%{joinedclan.%player%}%@jedicraft"
                    make console execute command "pex user %player% remove jediclans.clanchat.%{joinedclan.%player%}%"
                    set {joinedclan.%player%} to NONE
                    stop
            else:
                message "&e&lClans&8> &7You are not in a clan."
                stop

				 */
			}
			else if(args[0].equalsIgnoreCase("disband")) {
				
		
				/*
				 *           if arg 1 is "disband":
            if {inclan.%player%} is true:
                if player's name is "%{clan.%{joinedclan.%player%}%.owner}%":
                    message "&e&lClans&8> &7Your clan has been disbanded."
                    set {clan.%{joinedclan.%player%}%.taken} to false
                    set {disbanding.clan.name} to "%{joinedclan.%player%}%"
                    set {inclan.%player%} to false
                    set {clan.%{joinedclan.%player%}%.owner} to player
                    remove {joinedclan.%player%} from {clanlist::*}
                    make console execute command "p u %player% remove jediclans.clanchat.%{joinedclan.%player%}%@jedicraft"
                    make console execute command "pex user %player% remove jediclans.clanchat.%{joinedclan.%player%}%"
                    set {clan.%{joinedclan.%player%}%.membercount} to 0
                    add {clan.%{joinedclan.%player%}%.bank} to the player's balance
                    set {clan.%{joinedclan.%player%}%.bank} to 0
                    set {clan.%{joinedclan.%player%}%.membercount} to 0
                    if {clan.%{joinedclan.%player%}%.base} is true:
                        set line 4 of block at {clanbase.%{clan.%{joinedclan.%player%}%.basename}%.mainsign} to "%{clanbase.%{clan.%{joinedclan.%player%}%.basename}%.price}%"
                        set {clanbase.%{clan.%{joinedclan.%player%}%.basename}%.claimed} to false
                        set {clanbase.%{clan.%{joinedclan.%player%}%.basename}%.clan} to "NONE"
                    loop {clanmembers_%{joinedclan.%player%}%::*}:
                        remove loop-value from {clanmembers_%{joinedclan.%player%}%::*}
                        set {inclan.%loop-value%} to false
                        send message "&e&lClans&8> &7Your clan was disbanded." to loop-value
                        make console execute command "p u %loop-value% remove jediclans.clanchat.%{joinedclan.%loop-value%}%@jedicraft"
                        make console execute command "pex user %loop-value% remove jediclans.clanchat.%{joinedclan.%loop-value%}%"
                        set {joinedclan.%loop-value%} to NONE
                    clear {clanmembers_%{disbanding.clan.name}%::*}
                    stop
                else:
                    message "&e&lClans&8> &7You are not the owner of this clan."
                    stop
            else:
                message "&e&lClans&8> &7You are not in a clan."
                stop
				 */
			}
			else if(args[0].equalsIgnoreCase("info")) {
				/*
				 *  if arg 1 is "info" or "i":
            if arg 2 is set:
                if {clan.%arg 2%.taken} is true:
                    message "&eClan Info: &f[&d%arg 2%&f]"
                    wait 12 ticks
                    message "&fLeader: &7%{clan.%arg 2%.owner}%."
                    wait 12 ticks
                    message "&fElders: &7%{clanelders_%arg 2%::*}%."
                    wait 12 ticks
                    message "&fBank: &7$%{clan.%arg 2%.bank}%."
                    wait 12 ticks
                    message "&fBase: &7%{clan.%arg 2%.base}%."
                    wait 12 ticks
                    message "&fFlag: &7%{clan.%arg 2%.flag}%."
                    wait 12 ticks
                    message "&fMember Cap: &7%{clan.%arg 2%.membercap}%."
                    wait 12 ticks
                    message "&fMember List: &7%{clanmembers_%arg 2%::*}%."
                    stop
                if {inclan.%arg 2%} is true:
                    message "&eClan Info: &f[&d%{joinedclan.%arg 2%}%&f]"
                    wait 12 ticks
                    message "&fLeader: &7%{clan.%{joinedclan.%arg 2%}%.owner}%."
                    wait 12 ticks
                    message "&fElders: &7%{clanelders_%{joinedclan.%arg 2%}%::*}%."
                    wait 12 ticks
                    message "&fBank: &7$%{clan.%{joinedclan.%arg 2%}%.bank}%."
                    wait 12 ticks
                    message "&fBase: &7%{clan.%{joinedclan.%arg 2%}%.base}%."
                    wait 12 ticks
                    message "&fFlag: &7%{clan.%{joinedclan.%arg 2%}%.flag}%."
                    wait 12 ticks
                    message "&fMember Cap: &7%{clan.%{joinedclan.%arg 2%}%.membercap}%."
                    wait 12 ticks
                    message "&fMember List: &7%{clanmembers_%{joinedclan.%arg 2%}%::*}%."
                    stop
                else:
                    message "&e&lClans&8> &7Unknown clan."
                    stop
            if {inclan.%player%} is true:
                message "&eClan Info: &f[&d%{joinedclan.%player%}%&f]"
                wait 2 ticks
                message "&fLeader: &7%{clan.%{joinedclan.%player%}%.owner}%."
                wait 2 ticks
                message "&fElders: &7%{clanelders_%{joinedclan.%player%}%::*}%."
                wait 2 ticks
                message "&fBank: &7$%{clan.%{joinedclan.%player%}%.bank}%."
                wait 2 ticks
                message "&fBase: &7%{clan.%{joinedclan.%player%}%.base}%."
                wait 2 ticks
                message "&fFlag: &7%{clan.%{joinedclan.%player%}%.flag}%."
                wait 2 ticks
                message "&fMember Cap: &7%{clan.%{joinedclan.%player%}%.membercap}%."
                wait 2 ticks
                message "&fMember List: &7%{clanmembers_%{joinedclan.%player%}%::*}%."
                stop
            else:
                message "&e&lClans&8> &7/clan info <clan name/player name>."
                stop

				 */
			}
			else if(args[0].equals("join")) {
				/*
				 *         if arg 1 is "join" or "j":
            if arg 2 is set:
                if {clan.%arg 2%.taken} is true:
                    if {clan.%arg 2%.membercount} is less than {clan.%arg 2%.membercap}:
                        if {clan.%arg 2%.invited.%player%} is true:
                            message "&e&lClans&8> &7Joined %arg 2%! :D"
                            set {clan.%arg 2%.invited.%player%} to false
                            set {inclan.%player%} to true
                            set {joinedclan.%player%} to arg 2
                            add 1 to {clan.%arg 2%.membercount}
                            add player to {clanmembers_%arg 2%::*}
                            make console execute command "p u %player% add jediclans.clanchat.%arg 2%@jedicraft"
                            make console execute command "pex user %player% add jediclans.clanchat.%arg 2%"
                            message "&e&lClans&8> &7Clans cost $500 per day, deposit money in your clan bank!"
                            stop
                        else:
                            message "&e&lClans&8> &7You aren't invited to join %arg 2%. D:"
                            stop
                    else:
                        message "&e&lClans&8> &7This clan is full!"
                        stop
                else:
                    message "&e&lClans&8> &7%arg 2% isn't a clan."
                    stop
            else:
                message "&e&lClans&8> &7/clan join <clan name>."
                stop
        if arg 1 is "rank" or "elder":
            if arg 2 is set:
                if {joinedclan.%arg 2%} is "%{joinedclan.%player%}%":
                    if {clan.%{joinedclan.%player%}%.elder.%arg 2%} is true:
                        message "&e&lClans&8> &7%arg 2% is no longer a clan Elder."
                        set {clan.%{joinedclan.%player%}%.elder.%arg 2%} to false
                        remove arg 2 from {clanelders_%{joinedclan.%player%}%::*}
                        stop
                    else:
                        message "&e&lClans&8> &7%arg 2% is now a clan Elder."
                        set {clan.%{joinedclan.%player%}%.elder.%arg 2%} to true
                        add arg 2 to {clanelders_%{joinedclan.%player%}%::*}
                        stop
                else:
                    message "&e&lClans&8> &7%arg 2% is not a member of your clan."
                    stop
            else:
                message "&e&lClans&8> &7/clan rank <name>."
                stop
        if arg 1 is "kick":
            if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                if arg 2 is set:
                    if {joinedclan.%player%} is "{joinedclan.%arg 2%}":
                        message "&e&lClans&8> &7Kicked %arg 2% from the clan."
                        remove arg 2 from {clanmembers_%{joinedclan.%player%}%::*}
                        set {inclan.%arg 2%} to false
                        set {clan.%{joinedclan.%player%}%.elder.%arg 2%} to false
                        remove 1 from {clan.%{joinedclan.%player%}%.membercount}
                        make console execute command "p u %arg 2% remove jediclans.clanchat.%{joinedclan.%player%}%@jedicraft"
                        make console execute command "pex user %arg 2% remove jediclans.clanchat.%{joinedclan.%player%}%"
                        set {joinedclan.%arg 2%} to NONE
                        stop
                    else:
                        message "&e&lClans&8> &7%arg 2% is not a member of your clan."
                        stop
                else:
                    message "&e&lClans&8> &7/clan kick <name>."
                    stop
            else if {clan.%{joinedclan.%player%}%.elder.%player%} is true:
                if arg 2 is set:
                    if {joinedclan.%player%} is "{joinedclan.%arg 2%}":
                        if {clan.%{joinedclan.%player%}%.owner} is "%arg 2%":
                            message "&e&lClans&8> &7%arg 2% is your clan leader."
                            stop
                        else:
                            if {clan.%{joinedclan.%player%}%.elder.%arg 2%} is true:
                                message "&e&lClans&8> &7%arg 2% is a clan Elder."
                                stop
                            else:
                                message "&e&lClans&8> &7Kicked %arg 2% from the clan."
                                remove arg 2 from {clanmembers_%{joinedclan.%player%}%::*}
                                set {inclan.%arg 2%} to false
                                remove 1 from {clan.%{joinedclan.%player%}%.membercount}
                                make console execute command "p u %arg 2% remove jediclans.clanchat.%{joinedclan.%player%}%@jedicraft"
                                make console execute command "pex user %arg 2% remove jediclans.clanchat.%{joinedclan.%player%}%"
                                set {joinedclan.%arg 2%} to NONE
                                stop
                    else:
                        message "&e&lClans&8> &7%arg 2% is not a member of your clan."
                        stop
                else:
                    message "&e&lClans&8> &7/clan kick <name>."
                    stop
            else:
                message "&e&lClans&8> &7You are not a clan elder or higher."
                stop
				 */
			}
			else if(args[0].equalsIgnoreCase("invite") || (args[0].equalsIgnoreCase("add"))) {
				/*
				 *         if arg 1 is "invite" or "add":
            if arg 2 is set:
                if {clan.%{joinedclan.%player%}%.invited.%arg 2%} is true:
                    message "&e&lClans&8> &7Revoked %arg 2%'s invitation to the clan. D:"
                    set {clan.%{joinedclan.%player%}%.invited.%arg 2%} to false
                    set {_invite} to arg 2
                    send "&e&lClans&8> &7Your invitation to join %{joinedclan.%player%}% was revoked. D:" to {_invite}
                    stop
                else:
                    message "&e&lClans&8> &7Invited %arg 2% to the clan. :D"
                    set {clan.%{joinedclan.%player%}%.invited.%arg 2%} to true
                    set {_invite} to arg 2
                    send message "&e&lClans&8> &7You have been invited to join %{joinedclan.%player%}%! :D" to {_invite}
                    stop
            else:
                message "&e&lClans&8> &7/clan invite <name>."
        if arg 1 is "create" or "c":
            if {clan.%arg 2%.taken} is true:
                message "&e&lClans&8> &7Clan name (%arg 2%) taken!"
                stop
            else:
                if {inclan.%player%} is true:
                    message "&e&lClans&8> &7You are already in a clan!"
                    stop
                else:
                    if player's money is greater than 100000:
                        remove 100000 from the player's balance
                        set {clan.%arg 2%.taken} to true
                        set {clan.%arg 2%.owner} to player
                        set {clan.%arg 2%.base} to false
                        set {clan.%arg 2%.membercap} to 15
                        set {clan.%arg 2%.membercount} to 1
                        set {clan.%arg 2%.flag} to false
                        set {inclan.%player%} to true
                        clear {clanmembers_%arg 2%::*}
                        clear {clanelders_%arg 2%::*}
                        set {joinedclan.%player%} to arg 2
                        add arg 2 to {clanlist::*}
                        add player to {clanmembers_%arg 2%::*}
                        add 1 to {clans.total}
                        set {clan.%arg 2%.bank} to 1000
                        make console execute command "p u %player% add jediclans.clanchat.%arg 2%@jedicraft"
                        make console execute command "pex user %player% add jediclans.clanchat.%arg 2%"
                        message "&e&lClans&8> &7Creating your clan..."
                        wait 12 ticks
                        message "&e&lClans&8> &7Adding $1000 to clan bank."
                        wait 12 ticks
                        message "&e&lClans&8> &7Clan created! You now have %player's money%."
                        message "&e&lClans&8> &7Use /clan invite <name> to invite a player."
                        message "&e&lClans&8> &7Clans cost $500 per day, deposit money in your clan bank!"
                        stop
				 */
			}
			/*
			 *      else:
                        message "&e&lClans&8> &7You need $100000!"
        else:
            message "&eMineswine JediClans &av1.0 &9by Moderocky"
            message "&e• &f/clan help &7- clan commands."
            message "&e• &f/clanmoney help &7- clan money management."
            message "&e• &f/clanshop help &7- shopping commands."
            message "&e• &f/clanchat &7- clan chat."
            message "&e• &f/clans &7- list clans."
            message "&e• &f/clanadmin help &7- admin commands."
            
			 */	
		}
		return true;
	}	
} 