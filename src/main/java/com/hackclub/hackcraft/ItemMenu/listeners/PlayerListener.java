package com.hackclub.hackcraft.ItemMenu.listeners;

import com.hackclub.hackcraft.ItemMenu.ItemMenuPlugin;
import com.hackclub.hackcraft.ItemMenu.events.ItemActionEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    private ItemMenuPlugin pl;

    public PlayerListener(ItemMenuPlugin pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent event) {
        System.out.println(event.getAction());

        if (event.getItem() != null) {
            ItemActionEvent iae = new ItemActionEvent(event.getPlayer(), event.getItem());
            Bukkit.getServer().getPluginManager().callEvent(iae);
        }
    }

}
