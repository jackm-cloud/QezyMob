package com.qezy.qezymob.commands;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;


import com.qezy.qezymob.qezyMob;
import com.qezy.qezymob.listeners.FreezeListener;
import com.qezy.qezymob.utils.text.Localizer;


public class freeze implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(Localizer.getLocalizedCommandUsageText("commands.freeze.error.syntax", alias));
            return true;
        }

        Player target = qezyMob.instance.getServer().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(Localizer.getLocalizedText("commands.freeze.error.unknown", new String[] {"player"}, new String[] {args[0]}));
            return true;
        }

        if (FreezeListener.addFrozenPlayer(target)) {
            target.sendMessage(Localizer.getLocalizedText("punishMessage.freeze"));
            sender.sendMessage(Localizer.getLocalizedText("commands.freeze.frozen", new String[] {"player"}, new String[] {target.getName()}));
        } else
            sender.sendMessage(Localizer.getLocalizedText("commands.freeze.none"));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) return null;
        List<String> list = new ArrayList<String>();
        return list;
    }

}