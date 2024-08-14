package org.BlazesMeta.metaTools.TestCommand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender != null) {

            // Überprüfen, ob der Spieler die benötigte Berechtigung hat
            if (commandSender.hasPermission("metatools.test")) {
                // Befehl wird ausgeführt, wenn die Berechtigung vorhanden ist
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "tellraw @a [\"\",{\"text\":\"[\",\"color\":\"white\"},{\"text\":\"Broadcast\",\"color\":\"gold\"},{\"text\":\"] Alle Spieler in der Oberwelt werden gebeten, den Server zu verlassen oder zu schlafen, damit die Nacht übersprungen werden kann.\",\"color\":\"white\"}]");
                commandSender.sendMessage("Test");
            } else {
                // Nachricht, wenn die Berechtigung fehlt
                commandSender.sendMessage("Du hast keine Berechtigung, diesen Befehl auszuführen.");
            }
        } else {
            // Wenn der Befehl von der Konsole ausgeführt wird
            commandSender.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
        }
        return true;
    }
}
