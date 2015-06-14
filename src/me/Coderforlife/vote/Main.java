package me.Coderforlife.vote;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin{
	public final String prefix = getConfig().getString("prefix").replaceAll("(&([a-f0-9]))", "\u00A7$2") + " ";
	public final String keys = ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Keys" + ChatColor.GOLD + "]" ;
	public void onEnable(){
		System.out.println("Running "+ System.getProperty("os.name") + " hmmmmmm");
		getConfig().options().copyDefaults(true);
		getConfig().options().header("Vote Here Config");
		saveConfig();
	}
	public void onDisable(){
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String Commandlabel, String[] args){
	if(cmd.getName().equalsIgnoreCase("votehere"));
		 if ((args.length == 0)){
		if ((sender instanceof Player)){
		Player player = (Player) sender;
		if(player.hasPermission("vothere.here")){
		player.sendMessage(ChatColor.RED + "==============" + ChatColor.WHITE + "[" + ChatColor.GREEN + 
				"Vote Here" + ChatColor.WHITE + "]" + ChatColor.RED + "==============");
	    player.sendMessage(prefix + getConfig().getString("Link1").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
	    player.sendMessage(prefix + getConfig().getString("Link2").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
	    player.sendMessage(prefix + getConfig().getString("Link3").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
	    player.sendMessage(prefix + getConfig().getString("Link4").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
	    player.sendMessage(prefix + getConfig().getString("Link5").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
	    player.sendMessage(prefix + getConfig().getString("Link6").replaceAll("(&([a-f0-9]))", "\u00A7$2"));
		}else{
			player.sendMessage(ChatColor.RED + "Sorry you don't have permisson to do that.");
		}
	    
	    

     }else{
    	 System.out.println("Sorry can't use that here");
     }
	}      if ((args.length == 1) && 
		      (args[0].equalsIgnoreCase("reload"))) {
	      if ((sender instanceof Player)){
	      {	        Player player = (Player)sender;
	    	  if (player.hasPermission("votehere.reload")){
			 this.reloadConfig();
			 this.saveConfig();
			 player.sendMessage( ChatColor.WHITE + "[" + ChatColor.GREEN + 
				"Vote Here" + ChatColor.WHITE + "] " + ChatColor.RED + "Reloaded Config");
		 }else{
			 player.sendMessage(ChatColor.RED + "Sorry you don't have permisson to do that.");
		 }
		 }
		}else{ 
			 this.reloadConfig();
			 this.saveConfig();
			 System.out.println( ChatColor.WHITE + "[" + ChatColor.GREEN + 
				"Vote Here" + ChatColor.WHITE + "] " + ChatColor.RED + "Reloaded Config");
	  }
		
	}
	return true;
}
}
