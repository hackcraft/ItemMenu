package com.hackclub.hackcraft.ItemMenu.commands;

import com.hackclub.hackcraft.ItemMenu.ItemMenusPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ItemMenuCommand implements CommandExecutor {

    private ItemMenusPlugin plugin;

    public ItemMenuCommand(ItemMenusPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label,
            String[] args) {


    }
}
