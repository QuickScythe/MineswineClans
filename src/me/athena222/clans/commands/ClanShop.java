package me.athena222.clans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClanShop implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console cannot use /clanshop!");
			return true;
		}
		
		//final Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("clanshop")) {
			
		}
		
		return true;
	}
}
/*

command /cshop <text="list"> [<text>]:
    description: Clanshop purchase maker.
    permission: member.clanshop
    aliases: clanshop
    trigger:
        if arg 1 is "buy":
            if arg 2 is set:
                if arg 2 is "+20 Members":
                    if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                        if player has permission "boar.clanshop.membercap":
                            if {clan.%{joinedclan.%player%}%.bank} is greater than 280000:
                                remove 280000 from {clan.%{joinedclan.%player%}%.bank}
                                message "&e&lClans&8> &7Removed $280000 from your clan bank."
                                message "&e&lClans&8> &7You can now have 20 extra members."
                                add 20 to {clan.%{joinedclan.%player%}%.membercap}
                                stop
                            else:
                                message "&e&lClans&8> &7Your clan doesn't have $100000."
                                stop
                        else:
                            message "&e&lClans&8> &7You need to be a boar."
                            stop
                    else:
                        message "&e&lClans&8> &7You are not the owner of a clan."
                        stop
                if arg 2 is "+5 Members":
                    if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                        if player has permission "boar.clanshop.membercap":
                            if {clan.%{joinedclan.%player%}%.bank} is greater than 80000:
                                remove 80000 from {clan.%{joinedclan.%player%}%.bank}
                                message "&e&lClans&8> &7Removed $80000 from your clan bank."
                                message "&e&lClans&8> &7You can now have 5 extra members."
                                add 5 to {clan.%{joinedclan.%player%}%.membercap}
                                stop
                            else:
                                message "&e&lClans&8> &7Your clan doesn't have $100000."
                                stop
                        else:
                            message "&e&lClans&8> &7You need to be a boar."
                            stop
                    else:
                        message "&e&lClans&8> &7You are not the owner of a clan."
                        stop
                if arg 2 is "broadcast":
                    if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                        if player has permission "boar.clanshop.broadcast":
                            if {clan.%{joinedclan.%player%}%.bank} is greater than 25000:
                                remove 25000 from {clan.%{joinedclan.%player%}%.bank}
                                message "&e&lClans&8> &7Removed $25000 from your clan bank."
                                message "&e&lClans&8> &7If you already had this item, the daily cooldown has been reset."
                                set {clan.%{joinedclan.%player%}%.shop.broadcast} to true
                                set {clan.%{joinedclan.%player%}%.bcactive} to true
                                stop
                            else:
                                message "&e&lClans&8> &7Your clan doesn't have $25000."
                                stop
                        else:
                            message "&e&lClans&8> &7You need to be boar rank!"
                            stop
                    else:
                        message "&e&lClans&8> &7You are not the owner of a clan."
                        stop
                if arg 2 is "tp" or "teleport":
                    if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                        if {clan.%{joinedclan.%player%}%.bank} is greater than 40000:
                            remove 40000 from {clan.%{joinedclan.%player%}%.bank}
                            message "&e&lClans&8> &7Removed $40000 from your clan bank."
                            message "&e&lClans&8> &7If you already had this item, the daily cooldown has been reset."
                            set {clan.%{joinedclan.%player%}%.shop.tp} to true
                            set {clan.%{joinedclan.%player%}%.tpactive} to true
                            stop
                        else:
                            message "&e&lClans&8> &7Your clan doesn't have $40000."
                            stop
                    else:
                        message "&e&lClans&8> &7You are not the owner of a clan."
                        stop
                else:
                    message "&e&lClans&8> &7This item is not available."
                    stop
            else:
                message "&e&lClans&8> &7This item is not available."
                stop
        if arg 1 is "list" or "shop" or "help" or "?":
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
                message "&fIncrease Membercap: &7Get 5 more member slots."
                message "&6/cshop buy +5 Members"
                stop
            else:
                message "&e&lClans&8> &7You are not the owner of a clan."
                stop


*/