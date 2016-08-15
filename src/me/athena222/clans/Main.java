package me.athena222.clans;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.athena222.clans.commands.ClanAdmin;
import me.athena222.clans.commands.ClanChat;
import me.athena222.clans.commands.ClanCommand;
import me.athena222.clans.commands.ClanList;
import me.athena222.clans.commands.ClanMoney;
import me.athena222.clans.commands.ClanShop;
import me.athena222.clans.commands.Fakekill;
import me.athena222.clans.commands.Staff;
import me.athena222.clans.commands.TakeClanTax;
import me.athena222.clans.listeners.ClanSign;

/**
 * Made by Athena222 (Land1401)
 * August 12th, 2016
 */
public class Main extends JavaPlugin {
	
	public Main plugin;
	private final Logger logger = getLogger();
	
	//public Map<> config = new HashMap<>();
	
	public void onEnable() {
		plugin = this;
		registerCommands();
		registerListeners();
		dailyTax();
		saveDefaultConfig();
		
		if(Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			logger.info("Successfully found Vault, Clans will now hook into Vault for economy.");
		}
		else if(!Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			logger.info("Clans couldn't find Vault, now disabling...");
			Bukkit.getPluginManager().disablePlugin(this);
		}		
	}

	/*
	public void start() {
		for(Entry e : config.entrySet()){
			  getConfig().set(e.getKey(), e.getValue());
		}
	}
	
	public void end() {
		
	}
	*/
	
	private void registerCommands() {
		
		/* Clan Commands */
		getCommand("clanadmin").setExecutor(new ClanAdmin());
		getCommand("clans").setExecutor(new ClanList()); // Finished 
		getCommand("clan").setExecutor(new ClanCommand()); 
		getCommand("clanmoney").setExecutor(new ClanMoney());
		getCommand("clanshop").setExecutor(new ClanShop());
		getCommand("clanchat").setExecutor(new ClanChat());
		getCommand("takeclantax").setExecutor(new TakeClanTax());		
		
		/* Other Commands */
		getCommand("fakekill").setExecutor(new Fakekill());
		getCommand("staff").setExecutor(new Staff()); // Finished 
	}
	
	private void registerListeners() {
		getServer().getPluginManager().registerEvents(new ClanSign(), this);
	}
	
	private void dailyTax() {
		
		new BukkitRunnable() {
			public void run() {
				getServer().dispatchCommand(Bukkit.getConsoleSender(), "takeclantax");
			}
		}.runTaskTimer(this, 0, 86400 * 20); // Configurable integer? Different class?
	}
}