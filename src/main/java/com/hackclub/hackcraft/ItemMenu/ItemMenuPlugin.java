package com.hackclub.hackcraft.ItemMenu;

import com.hackclub.hackcraft.ItemMenu.commands.ItemMenuCommand;
import com.hackclub.hackcraft.ItemMenu.listeners.ItemActionListener;
import com.hackclub.hackcraft.ItemMenu.listeners.PlayerListener;
import com.hackclub.hackcraft.ItemMenu.objects.ItemMenu;
import com.hackclub.hackcraft.ItemMenu.utils.ItemMenuUtil;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemMenuPlugin extends JavaPlugin {

  public static ItemMenuUtil ItemMenuUtil;

  @Override
  public void onEnable() {
    getLogger().info("ItemMenu activated!");

    // register serialization
    ConfigurationSerialization.registerClass(ItemMenu.class);

    // initialize custom objects
    ItemMenuUtil = new ItemMenuUtil(this);
    ItemMenuUtil.loadItemMenus();

    // register commands
    this.getCommand("menu").setExecutor(new ItemMenuCommand(this));

    getServer().getPluginManager().registerEvents(new ItemActionListener(this), this);
    getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
  }

  @Override
  public void onDisable() {
    getLogger().info("ItemMenu deactivated!");
  }

  public static ItemMenuUtil getMenuUtil() {
    return ItemMenuUtil;
  }
}
