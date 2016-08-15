package me.athena222.clans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.athena222.clans.handlers.Clan;

public class ClanMoney implements CommandExecutor {

	Clan clans = new Clan();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console cannot use /clanmoney!");
			return true;
		}
		
		final Player player = (Player) sender;
		
		if(args.length == 0) {
			if(cmd.getName().equalsIgnoreCase("clanmoney")) {
				player.sendMessage("Debug");
			}
		}
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("withdraw") || (args[0].equalsIgnoreCase("w"))) {
				
			}
		}
		
		return true;
	}
}
/*

command /clanmoney [<text>] [<integer>] [<text>]:
    description: Deposit or withdraw from a clan bank.
    permission: member.clanmoney
    aliases: cmoney
    trigger:
        if arg 1 is "withdraw" or "w":
            if arg 2 is greater than 0:
                if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                    if {clan.%{joinedclan.%player%}%.bank} is greater than arg 2:
                        remove arg 2 from {clan.%{joinedclan.%player%}%.bank}
                        add arg 2 to player's balance
                        message "&e&lClans&8> &7Removed $%arg 2% from your clan bank."
                        stop
                    else:
                        message "&e&lClans&8> &7Your clan doesn't have $%arg 2%."
                        stop
                else:
                    message "&e&lClans&8> &7You are not the owner of a clan."
                    stop
            else:
                message "&e&lClans&8> &7/clan withdraw <amount>."
                stop
        if arg 1 is "deposit" or "d" or "donate":
            if arg 2 is greater than 0:
                if {inclan.%player%} is true:
                    if arg 3 is set:
                        if {clan.%arg 3%.taken} is true:
                            if player's balance is greater than arg 2:
                                remove arg 2 from player's balance
                                add arg 2 to {clan.%arg 3%.bank}
                                message "&e&lClans&8> &7Deposited $%arg 2% in the bank of %arg 3%."
                                stop
                            else:
                                message "&e&lClans&8> &7You do not have $%arg 2%."
                                stop
                        else:
                            message "&e&lClans&8> &7%arg 3% is not a clan."
                            stop
                    else:
                        if player's balance is greater than arg 2:
                            remove arg 2 from player's balance
                            add arg 2 to {clan.%{joinedclan.%player%}%.bank}
                            message "&e&lClans&8> &7Deposited $%arg 2% in the bank of %{joinedclan.%player%}%."
                            stop
                        else:
                            message "&e&lClans&8> &7You do not have $%arg 2%."
                            stop
                else:
                    if arg 3 is set:
                        if {clan.%arg 3%.taken} is true:
                            if player's balance is greater than arg 2:
                                remove arg 2 from player's balance
                                add arg 2 to {clan.%arg 3%.bank}
                                message "&e&lClans&8> &7Deposited $%arg 2% in the bank of %arg 3%."
                                stop
                            else:
                                message "&e&lClans&8> &7You do not have $%arg 2%."
                                stop
                        else:
                            message "&e&lClans&8> &7%arg 3% is not a clan."
                            stop
                    else:
                        message "&e&lClans&8> &7/clan deposit <amount> [clanname]."
                        stop
            else:
                message "&e&lClans&8> &7/clan deposit <amount> [clanname]."
                stop
        else:
            message "&e&lClans&8> &7/clanmoney deposit/withdraw <amount> [clanname]."
            stop


*/