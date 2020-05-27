package com.hackclub.hackcraft.ItemMenu;


import org.bukkit.plugin.java.JavaPlugin;

public class ItemMenuPlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info("ItemMenus activated!");

    }

    @Override
    public void onDisable() {
        getLogger().info("ItemMenus deactivated!");
    }
}
