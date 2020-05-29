package com.hackclub.hackcraft.ItemMenu.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemMenu implements ConfigurationSerializable {
    private String id;
    private String name;
    private ArrayList<ItemStack> items;



    public ItemMenu(String id, String name) {
        this.id = id;
        this.name = name;

        items = new ArrayList<ItemStack>();

    }

    public ItemMenu(Map<String, Object> serializedItemMenu) {
        this.id = (String) serializedItemMenu.get("id");
        this.name = (String) serializedItemMenu.get("name");

        ArrayList<Map<String, Object>> mappeditems =
                (ArrayList<Map<String, Object>>) serializedItemMenu.get("items");
        this.items = new ArrayList<>();
        mappeditems.forEach((c) -> this.items.add(ItemStack.deserialize(c)));


    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serializer = new HashMap<>();


        // serialize basic params
        serializer.put("id", id);
        serializer.put("name", name);

        ArrayList<Map<String, Object>> itemsSerialized = new ArrayList<>();
        items.forEach((c) -> itemsSerialized.add(c.serialize()));


        // add the serialized list
        serializer.put("items", itemsSerialized);


        return serializer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ItemStack> getItemArray() {
        return items;
    }

    public void setItemArray(ArrayList<ItemStack> items) {
        this.items = items;
    }

    public void setItem(ItemStack item, Integer index) {
        if (items.size() > index) {
            this.items.set(index, item);
        } else {
            this.items.add(item);
        }

    }

    public ItemStack getItem(int index) {
        return items.get(index);
    }

    public ItemMeta getItemMeta(int index) {
        try {
            return items.get(index).getItemMeta();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void setItemMeta(ItemMeta itemMeta, int index) {
    }

}
