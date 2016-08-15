package me.athena222.clans.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Clan { // fix this whole class
	
	public String clanPrefix = ChatColor.YELLOW + "" + ChatColor.BOLD + "Clans" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "";
	
	private List<Clan> allClans = new ArrayList<Clan>();
	
	private HashMap<String, Clan> clans = new HashMap<String, Clan>(); // add a player parameter
	
	private HashMap<String, Clan> clanElders = new HashMap<String, Clan>();// boolean for this instead?
	
	private HashMap<String, Clan> clanOwners = new HashMap<String, Clan>();
	
	//private HashMap<Integer, Clan> clanBank = new HashMap<Integer, Clan>();
	
	private String name;
	
	private Player clanOwner;
	
	private HashMap<Location, Clan> clanBase = new HashMap<Location, Clan>();
	
	//private List<Player> clanElders = new ArrayList<Player>();
	
	public Clan() { // String name
		//this.name = name.trim();
	}
	
	public Player getOwner() {
		return clanOwner;
	}
	
	//public Player setOwner(Player player, Clan clan) {

	//}
	
	public boolean clanHasBase() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public HashMap<Location, Clan> getClanBase(String clan) {
		return clanBase;
	}
	
	public String getClan(Player player) {
		return name;
	}
	
	public HashMap<String, Clan> getOwner(Clan clan) {
		return clanOwners;
	}
	
	public HashMap<String, Clan> getElder(Clan clan) {
		return clanElders;
	}
	
	public Clan getPlayersInClan(Player player) { // fix this		
		return clans.get(player); // doesnt need Clan clan?
	}
	
	public void add(Player player, Clan clan) { // remove Clan clan? 
		clans.put(player.getName(), this);
		//members.add(player.getName());
	}
	
	public void remove(Player player, Clan clan) {
		clans.remove(player.getName());
		//members.remove(player.getName());
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isInClan(Player player) {
		if(allClans.contains(player)) {
			return true;
		}
		return false;
	}
	
	public List<Clan> getAllClans() { 
		return allClans;
	}
	
	public void createClan(Clan clan) { // String name?
		allClans.add(clan);
	}
	
	public void deleteClan(Clan clan) {
		allClans.remove(clan);
	}
	
	public Clan getClan(Player player, Clan clan) {
		return clan;
	}
	
	/*
	 * Work on getting the banks.
	 */	
	public int getBalance(String clan, int amount) {
		return amount;
	}
	
}