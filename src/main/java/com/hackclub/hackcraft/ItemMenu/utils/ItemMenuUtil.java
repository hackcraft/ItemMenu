package com.hackclub.hackcraft.ItemMenu.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import com.hackclub.hackcraft.ItemMenu.objects.ItemMenu;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ItemMenuUtil {

    private Plugin plugin;
    private FileConfiguration ItemMenuFile;
    private ArrayList<ItemMenu> ItemMenus;

    File file;


    public ItemMenuUtil(Plugin pl) {
        plugin = pl;
        file = new File(plugin.getDataFolder(), "itemMenus.yml");
        ItemMenuFile = YamlConfiguration.loadConfiguration(file);
        ItemMenus = new ArrayList<ItemMenu>();
    }

    public boolean saveItemMenu(ItemMenu im) {
        ItemMenuFile.set("itemMenus." + im.getId(), im);
        try {
            ItemMenuFile.save(file);
            return true;
        } catch (IOException e) {
            plugin.getLogger().severe("Error whilst try to save ItemMenu:");
            plugin.getLogger().severe(e.getMessage());
            return false;
        }
    }

    public Optional<ItemMenu> FromID(String id) {
        Optional<ItemMenu> im =
                getItemMenus().stream().filter(m -> m.getId().equals(id)).findFirst();

        return im;
    }

    public ArrayList<ItemMenu> loadItemMenus() {
        ItemMenus.clear();



        try {
            ((MemorySection) ItemMenuFile.get("itemMenus")).getValues(true)
                    .forEach((k, v) -> ItemMenus.add((ItemMenu) v));
        } catch (NullPointerException e) {
            plugin.getLogger().severe(
                    "Error while trying to load itemMenus from file (most likely no menus exist):");
        }
        return ItemMenus;
    }

    public ArrayList<ItemMenu> getItemMenus() {
        return ItemMenus;
    }

    public void giveItemMenu(Player player, String id) {
        ArrayList<ItemStack> itemList = FromID(id).get().getItemArray();
        player.getInventory().clear();

        for (int i = 0; i < itemList.size(); i++) {
            player.getInventory().setItem(i, itemList.get(i));
        }
    }

}
