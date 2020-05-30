package com.hackclub.hackcraft.ItemMenu.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class ItemActionEvent extends Event {

  private static final HandlerList handlers = new HandlerList();
  private Player player;
  private ItemStack item;

  public ItemActionEvent(Player player, ItemStack item) {
    this.player = player;
    this.item = item;
  }

  public Player getPlayer() {
    return player;
  }

  public ItemStack getItem() {
    return item;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

  public HandlerList getHandlers() {
    return handlers;
  }
}
