package com.hackclub.hackcraft.ItemMenu.commands;

import com.hackclub.hackcraft.ItemMenu.ItemMenuPlugin;
import com.hackclub.hackcraft.ItemMenu.objects.ItemMenu;
import java.util.Optional;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemMenuCommand implements CommandExecutor {

  private ItemMenuPlugin plugin;

  public ItemMenuCommand(ItemMenuPlugin plugin) {
    this.plugin = plugin;
  }

  public boolean onCommand(CommandSender commandSender, Command command, String label,
      String[] args) {
    Player sender = (Player) commandSender;
    Player player;
    Optional<ItemMenu> im;
    ItemMenu im2;

    switch (args[0].toLowerCase()) {
      case "give":
        if (args.length == 3) {
          player = sender.getServer().getPlayerExact(args[1]);
          im = plugin.ItemMenuUtil.FromID(args[2]);
          if (!im.isPresent()) {
            sender.sendMessage(ChatColor.RED + "That item menu doesn't exist!");
            return true;
          }
          plugin.ItemMenuUtil.giveItemMenu(player, im.get().getId());
          return true;
        }
        sender.sendMessage(ChatColor.RED + "Please specify all arguments");
        sender.sendMessage(
            ChatColor.YELLOW + "Usage:" + ChatColor.WHITE + "/menu give <username> <menu id>");
        return true;
      case "new":
        if (args.length == 3) {
          im2 = new ItemMenu(args[1], args[2]);
          if (plugin.ItemMenuUtil.saveItemMenu(im2)) {
            sender.sendMessage(ChatColor.GREEN + "Item menu successfully created!");
            plugin.ItemMenuUtil.loadItemMenus();
            return true;
          } else {
            sender.sendMessage(ChatColor.RED + "There was an issue saving the item menu!");
            return true;
          }
        }
      case "add":
        if (args.length == 2) {
          im = plugin.ItemMenuUtil.FromID(args[1]);
          if (!im.isPresent()) {
            sender.sendMessage(ChatColor.RED + "That item menu doesn't exist!");
            return true;
          }
          im2 = im.get();
          ItemStack item = sender.getInventory().getItemInMainHand();
          int slot = sender.getInventory().getHeldItemSlot();
          im2.setItem(item, slot);
          if (plugin.ItemMenuUtil.saveItemMenu(im2)) {
            sender.sendMessage(ChatColor.GREEN + "Item successfully added!");
            plugin.ItemMenuUtil.loadItemMenus();
            return true;
          }
        }
        sender.sendMessage(ChatColor.RED + "Please specify all arguments");
        sender.sendMessage(ChatColor.YELLOW + "Usage:" + ChatColor.WHITE + "/menu add <menu id>");
        return true;
    }

    return false;
  }
}
