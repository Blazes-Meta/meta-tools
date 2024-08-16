package org.BlazesMeta.metaTools.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RestartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender != null) {

            // Überprüfen, ob der Spieler die benötigte Berechtigung hat
            if (commandSender.hasPermission("metatools.restart")) {
                // Befehl wird ausgeführt, wenn die Berechtigung vorhanden ist
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "tellraw @a [\"\",{\"text\":\"[\",\"color\":\"white\"},{\"text\":\"Broadcast\",\"color\":\"gold\"},{\"text\":\"] \",\"color\":\"white\"},{\"text\":\"Es wird in einer Minute ein Neustart durchgeführt.\",\"color\":\"red\"},{\"text\":\" Alle Spieler werden gebeten, sich auszuloggen, damit alle Daten sicher gespeichert werden.\"}]");
                Bukkit.dispatchCommand(commandSender, "tellraw @s [\"\",{\"text\":\"[\",\"color\":\"white\"},{\"text\":\"Servertool DP\",\"color\":\"gold\"},{\"text\":\"] \",\"color\":\"white\"},{\"text\":\"Wenn in den server.properties \"},{\"text\":\"function-permission-level\",\"color\":\"gray\"},{\"text\":\" auf \"},{\"text\":\"4\",\"color\":\"gray\"},{\"text\":\" gesetzt wurde, wird der Server in einer Minute gestopt. \"},{\"text\":\"Er muss also manuell wieder gestartet werden!\",\"color\":\"red\"}]");
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("MetaTools"), () -> {
                    Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "restart");
                }, 60 * 20L);
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
