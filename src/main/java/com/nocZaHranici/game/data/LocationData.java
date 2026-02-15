package com.nocZaHranici.game.data;

import com.nocZaHranici.game.model.Item;
import com.nocZaHranici.game.model.NPC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationData {
    private String id;
    private String name;
    private String description;
    private List<Item> items;
    private List<NPC> npcs;
    private Map<String, String> exits;

    public LocationData(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.exits = new HashMap<>();
    }

    public LocationData() {}

    // region get, set

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    public Map<String, String> getExits() {
        return exits;
    }

    public void setExits(Map<String, String> exits) {
        this.exits = exits;
    }

    // endregion
}
