package me.athena222.clans.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClanSign implements Listener {

	  @EventHandler
	  public void onRightClick(PlayerInteractEvent e) {
		 
		  Player p = e.getPlayer();
		  
		  if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			  if(e.getClickedBlock().getState() instanceof Sign) {
				  
				  Sign s = (Sign) e.getClickedBlock().getState();
				  
				  if(s.getLine(0).equalsIgnoreCase("[Clan]")) {
						  
						  if (s.getLine(1).equalsIgnoreCase("Shop")) {
					  
					  ItemStack sword = p.getInventory().getItemInMainHand(); 
					  ItemMeta swordMeta = sword.getItemMeta(); 
					  List<String> swordLore = new ArrayList<String>(); 
					  swordLore.add(ChatColor.GRAY + "Clanzz"); 
					  swordMeta.setLore(swordLore); 
					  sword.setItemMeta(swordMeta); 
					  p.sendMessage(ChatColor.GREEN + "debug");
					  
						  }
				  }
			  }
		  }
	 }
}

/*

on rightclick on sign:
    if line 1 of clicked block is "[Clan]":
        if line 2 of clicked block is "Shop":
            if line 3 of clicked block is "List":
                make player execute command "cshop help"
            else:
                make player execute command "cshop buy %line 3 of clicked block%"
                
        if line 2 of clicked block is "Flag":
            set {cblock.line3} to line 3 of clicked block
            set {cblock.line4} to line 4 of clicked block
            if line 4 of clicked block is "%{joinedclan.%player%}%":
                if {clan.%{joinedclan.%player%}%.flag} is true:
                    if player's balance is greater than 7000:
                        message "&e&lClans&8> &7Redeemed your flag! ($7000)"
                        remove 7000 from player's balance
                        make console execute command "essentials:give %player% sunflower 1 name:&b%{cblock.line3}% lore:&aFlag_Token|&6Soulbound"
                    else:
                        message "&e&lClans&8> &7You don't have $7000 to redeem this flag."
                else:
                    message "&e&lClans&8> &7Your clan hasn't got a flag."
            else:
                if {flag.%{cblock.line3}%.claimed} is true:
                    message "&e&lClans&8> &7This flag has already been purchased by %{cblock.line4}%!"
                    stop
                else:
                    if {clan.%{joinedclan.%player%}%.bank} is less than 350000:
                        message "&e&lClans&8> &7Your clan cannot afford to claim this flag."
                        stop
                    else:
                        if {clan.%{joinedclan.%player%}%.flag} is true:
                            message "&e&lClans&8> &7Your clan already has a flag."
                            stop
                        else:
                            if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                                message "&e&lClans&8> &7You have claimed this flag design!"
                                remove 350000 from {clan.%{joinedclan.%player%}%.bank}
                                set line 4 of clicked block to "%{joinedclan.%player%}%"
                                set {flag.%{cblock.line3}%.claimed} to true
                                set {clan.%{joinedclan.%player%}%.flag} to true
                                message "&e&lClans&8> &7You can redeem flag tokens for $7000 by right clicking this sign."
                                wait 5 seconds
                                message "&e&lClans&8> &7Trade them at the shop for a customised &cClan Shield&7!"
                                stop
                            else:
                                message "&e&lClans&8> &7You are not the owner of a clan."
                                stop
        if line 2 of clicked block is "Base":
            set {cblock.line3} to line 3 of clicked block
            set {cblock.line4} to line 4 of clicked block
            if {clanbase.%{cblock.line3}%.claimed} is true:
                message "&e&lClans&8> &7This base has already been claimed by %{cblock.line4}%!"
                stop
            else:
                if {clan.%{joinedclan.%player%}%.bank} is less than {clanbase.%{cblock.line3}%.price}:
                    message "&e&lClans&8> &7Your clan cannot afford this base."
                    stop
                else:
                    if {clan.%{joinedclan.%player%}%.base} is true:
                        message "&e&lClans&8> &7Your clan already has a base."
                        stop
                    else:
                        if {clan.%{joinedclan.%player%}%.owner} is "%player%":
                            message "&e&lClans&8> &7You have purchased this base!"
                            remove {clanbase.%{cblock.line3}%.price} from {clan.%{joinedclan.%player%}%.bank}
                            set {clanbase.%{cblock.line3}%.claimed} to true
                            set {clanbase.%{cblock.line3}%.clan} to {joinedclan.%player%}
                            set line 4 of clicked block to {joinedclan.%player%}
                            set {clan.%{joinedclan.%player%}%.basename} to {cblock.line3}
                            message "&e&lClans&8> &7Use /clan home or /clan base to travel to it."
                            make console execute command "rg flag %{cblock.line3}% -w world greeting §e§lClans§8> §7Now §aentering§7 %{joinedclan.%player%}%§7's territory!"
                            make console execute command "rg flag %{cblock.line3}% -w world farewell §e§lClans§8> §7Now §cleaving§7 %{joinedclan.%player%}%§7's territory!"
                            make console execute command "rg flag %{cblock.line3}% -w TAttoine2 greeting §e§lClans§8> §7Now §aentering§7 %{joinedclan.%player%}%§7's territory!"
                            make console execute command "rg flag %{cblock.line3}% -w TAttoine2 farewell §e§lClans§8> §7Now §cleaving§7 %{joinedclan.%player%}%§7's territory!"
                            set {clan.%{joinedclan.%player%}%.base} to true
                            stop
                        else:
                            message "&e&lClans&8> &7You are not the owner of a clan."
                            stop

*/