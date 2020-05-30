package com.hackclub.hackcraft.ItemMenu.listeners;

import java.util.logging.Level;

import com.hackclub.hackcraft.ItemMenu.ItemMenuPlugin;
import com.hackclub.hackcraft.ItemMenu.events.ItemActionEvent;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    private ItemMenuPlugin pl;

    public PlayerListener(ItemMenuPlugin ItemMenuPlugin) {
        this.pl = ItemMenuPlugin;
    }

    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent event) {
        if (event.getItem() != null) {
            System.out.println(event.getAction());
            pl.getLogger().log(Level.INFO, event.getAction().toString());
            ItemActionEvent event2 = new ItemActionEvent(event.getPlayer(), event.getItem());
            try {
                Bukkit.getServer().getPluginManager().callEvent(event2);

            } catch (NullPointerException e) {
                pl.getLogger().log(Level.SEVERE, e.toString(), e.getCause());
                e.printStackTrace();
            }
        }
        return;
    }
}
