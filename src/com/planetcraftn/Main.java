package com.planetcraftn;

import com.planetcraftn.Comando.Congelar;
import com.planetcraftn.Eventos.Congelars;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    @Override
    public void onEnable() {
        getCommand("congelar").setExecutor(new Congelar(this));
        Bukkit.getPluginManager().registerEvents(new Congelars(), this);
        Configuracion();
    }



    @Override
    public void onDisable() {

    }


    private void Configuracion() {
        getConfig().addDefault("Nombre", "&7[&aPlanetcraft&7]");
        getConfig().addDefault("No-Permiso", "&cNo tienes permiso suficiente");
        getConfig().addDefault("Aviso.Staff.NotifyCongelar", "");
        getConfig().addDefault("Aviso.Staff.NotifyDescongelar", "");
        getConfig().addDefault("Aviso.Staff.JugadorDesconectado", "");
        getConfig().addDefault("Aviso.Staff.JugadorReconectado", "");
        getConfig().addDefault("Aviso.Consola.NotifyCongelar", "");
        getConfig().addDefault("Aviso.Consola.NotifyDescongelar", "");
        getConfig().addDefault("Aviso.Consola.JugadorSinPermiso", "");
        getConfig().addDefault("Aviso.Congelado.NotifyCongelar", "");
        getConfig().addDefault("Aviso.Congelado.NotifyDescongelar", "");
        getConfig().addDefault("Aviso.Congelado.Atacar", "");
        getConfig().addDefault("Aviso.Congelado.Disparar", "");
        getConfig().addDefault("Aviso.Global.Notify", true);
        getConfig().addDefault("Aviso.Global.NotifyCongelar", "");
        getConfig().addDefault("Aviso.Global.NotifyDescongelar", "");
        getConfig().addDefault("Aviso.Jugador.AtacarCongelado", "");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static String color(String texto){
        return ChatColor.translateAlternateColorCodes('&', texto);
    }

}
