package com.hackclub.hackcraft.ItemMenu.listeners;

import com.hackclub.hackcraft.ItemMenu.ItemMenuPlugin;
import com.hackclub.hackcraft.ItemMenu.events.ItemActionEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ItemActionListener implements Listener {

    private ItemMenuPlugin pl;

    public ItemActionListener(ItemMenuPlugin pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onItemAction(final ItemActionEvent event) {
        System.out.println(
                event.getPlayer() + "used" + event.getItem().getItemMeta().getDisplayName());
    }

}
