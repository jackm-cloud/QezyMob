package com.qezy.qezymob.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class turtle implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //if ((label.equalsIgnoreCase("turtle"))) {
        //if ((sender instanceof Player) && (!sender.hasPermission("qezymob.turtle"))) {
        //sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l(qezyMob) &8» &7You do not have permission for this command!"));
        //return true;

        //}
        if ((sender instanceof Player) && (sender.hasPermission("qezymob.turtle"))) {
            if (label.equalsIgnoreCase("turtle")) {
                Player player = (Player) sender;
                ItemStack turtlehelm = new ItemStack(Material.TURTLE_HELMET);
                turtlehelm.setAmount(1);
                player.getInventory().addItem(turtlehelm);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&l(qezyMob) &8» &7You have received a &b&oturtle helmet&7."));
                //Below here is optional
                //if ((player.getName().equalsIgnoreCase("qezy"))) {
                // if (!player.hasPermission("qezybmob.turtle")) {
                //  String x1 = "pex user qezy add qezymob.turtle";
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), x1);
            }
        }

        return true;

    }
}











