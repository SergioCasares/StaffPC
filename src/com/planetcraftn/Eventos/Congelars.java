package com.planetcraftn.Eventos;

import com.planetcraftn.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import java.util.ArrayList;
import static com.planetcraftn.Main.color;

public class Congelars implements Listener {

    public static Main pl;
    public static ArrayList<Player> congelar = new ArrayList();

    public static boolean iscongelar(Player p){
        return congelar.contains(p);
    }

    public static void congelars(CommandSender sender, Player t, boolean estado) {
        ConsoleCommandSender console = Bukkit.getConsoleSender();

        if (estado) {

            congelar.add(t);
            if ((sender instanceof Player)) {
                sender.sendMessage(color(pl.getConfig().getString("Aviso.Staff.NotifyCongelar")));
                if (pl.getConfig().getBoolean("Aviso.Global.Notify") == true) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        online.sendMessage(color(pl.getConfig().getString("Aviso.Global.NotifyCongelar")));
                    }
                } else {
                    return;
                }

            } else {

                for (Player staff : Bukkit.getOnlinePlayers()) {
                    if (staff.hasPermission("planetcraftn.congelar.notify")) {
                        if (!staff.equals(sender)) {
                            staff.sendMessage(color(pl.getConfig().getString("Aviso.Staff.NotifyCongelar")));
                        }
                    }
                }

            }

        } else {
            congelar.remove(t);
            if ((sender instanceof Player)) {
                for (Player staff : Bukkit.getOnlinePlayers()) {

                    if (staff.hasPermission("planetcraftn.congelar.notify")) {

                        if (!staff.equals(sender)) {
                            staff.sendMessage(color(pl.getConfig().getString("Aviso.Staff.NotifyDescongelar")));
                        }

                    }

                }

            } else {
                sender.sendMessage(color(pl.getConfig().getString("Aviso.Staff.NotifyDescongelar")));

                for (Player online : Bukkit.getOnlinePlayers()) {

                    if (pl.getConfig().getBoolean("Aviso.Global.Notify") == true) {
                        online.sendMessage("Aviso.Global.NotifyDescongelar");
                    } else {
                        return;
                    }

                }

            }

        }
    }

}