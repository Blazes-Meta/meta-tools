package org.BlazesMeta.metaTools;

import org.BlazesMeta.metaTools.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MetaTools extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
