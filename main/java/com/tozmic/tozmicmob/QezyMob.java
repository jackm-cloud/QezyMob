package com.qezy.qezymob;

import com.qezy.qezymob.commands.author;
import com.qezy.qezymob.commands.turtle;
import com.qezy.qezymob.listeners.SpawnMob;
import org.bukkit.plugin.java.JavaPlugin;


//freeze stuff

import com.qezy.qezymob.commands.unfreeze;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import com.qezy.qezymob.listeners.FreezeListener;
import com.qezy.qezymob.utils.text.Colorizer;
import com.qezy.qezymob.utils.text.Localizer;
import com.qezy.qezymob.commands.freeze;




public final class qezyMob extends JavaPlugin {
    public static qezyMob instance = null;
    public static Logger LOGGER = LogManager.getLogger("qezyFreeze");

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        initTextUtils();

        registerEvents();
        registerCommands();

        this.getServer().getPluginManager().registerEvents(new SpawnMob(), this);
        //NMSUtils.registerEntity("qezy_bear", MobType.POLAR_BEAR, PolarMain.class, false);
        this.getCommand("qezymob").setExecutor(new author());
        this.getCommand("turtle").setExecutor(new turtle());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private void initTextUtils() {
        // Text colorization/stylization
        ConfigurationSection styleSection = getConfig().getConfigurationSection("qezy.style");
        if (styleSection != null) {
            String styleCharStr = styleSection.getString("stylechar", "");
            String hexColorMarker = styleSection.getString("hexcolor", "");
            if (styleCharStr.trim().length() == 1 && !hexColorMarker.trim().isEmpty())
                Colorizer.setStyleChars(styleCharStr.charAt(0), hexColorMarker);
            else
                logWarning("Ignore this message for now!");
        } else
            logWarning("Ignore this message for now!");
        // Text localization
        ConfigurationSection localizationSection = getConfig().getConfigurationSection("qezy.placeholders");
        if (localizationSection != null) {
            String beginning = localizationSection.getString("inital","");
            String ending = localizationSection.getString("final","");
            if (!beginning.trim().isEmpty() && !ending.trim().isEmpty())
                Localizer.setSubstitutionDelimiters(beginning, ending);
            else
                logWarning("Ignore this message for now!");
        } else
            logWarning("Ignore this message for now!");
    }


    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new FreezeListener(), this);
    }

    public void registerCommands() {
        String permissionMessage = Localizer.getLocalizedText("noPermission");
        registerCommand("freeze", new freeze(), permissionMessage);
        registerCommand("unfreeze", new unfreeze(), permissionMessage);
    }

    public void registerCommand(String name, CommandExecutor executor, String permissionMessage) {
        PluginCommand cmd = getServer().getPluginCommand(name);
        cmd.setExecutor(executor);
        cmd.setPermissionMessage(permissionMessage);
    }

    public static void logInfo(String text) {
        LOGGER.log(Level.INFO, text);
    }
    private void logWarning(String text) {
        LOGGER.log(Level.WARN, text);
    }
}



