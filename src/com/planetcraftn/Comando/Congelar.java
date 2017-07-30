package com.planetcraftn.Comando;

import com.planetcraftn.Eventos.Congelars;
import com.planetcraftn.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import static com.planetcraftn.Main.color;
import java.util.logging.Level;

public class Congelar implements CommandExecutor {
    public Main pl;
    public Congelar(Main instance) { instance = pl;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        ConsoleCommandSender console = Bukkit.getConsoleSender();

        if ((sender instanceof Player)){

            if (cmd.getName().equalsIgnoreCase("congelar")){

                if (p.hasPermission("planetcraft.congelar")){

                    if ((args.length == 0) && (args.length > 1)){
                        p.sendMessage("§cHas usado mal el comando. §aForma correcta §6/" + label + " <jugador>");
                        return true;
                    }else {
                        Player t = Bukkit.getPlayerExact(args[0]);
                        if (Congelars.iscongelar(t)){
                            Congelars.congelars(p, t, false);
                        }else {
                            Congelars.congelars(p, t, true);
                            t.sendMessage(color(pl.getConfig().getString("Aviso.Congelado.NotifyCongelar")));
                        }
                    }

                }else {
                    pl.getLogger().log(Level.INFO, "El jugador " + p.getName() + " trato de usar /" + label);
                    p.sendMessage(color(pl.getConfig().getString("NoPermiso")));
                    return true;
                }

            }

        }else {
            console.sendMessage("Solo jugadores pueden ejecutar este comando");
            return true;
        }


        return true;
    }
}
