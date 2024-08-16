package org.BlazesMeta.metaTools;

import org.BlazesMeta.metaTools.Commands.SleepplsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MetaTools extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(new SleepplsCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
