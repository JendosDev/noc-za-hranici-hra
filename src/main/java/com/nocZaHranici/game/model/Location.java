package com.nocZaHranici.game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Třída reprezentující lokaci ve hře
 */
public class Location {
    /**
     * Id
     */
    private String id;
    /**
     * Jméno
     */
    private String name;
    /**
     * Popis
     */
    private String description;
    /**
     * Předměty
     */
    private Map<String, Item> items;
    /**
     * NPCs
     */
    private List<NPC> npcs;
    /**
     * Východy
     */
    private Map<String, Location> exits;

    /**
     * Vytvoří instanci lokace
     * Inicializuje proměnné, seznamy a mapu
     * @param id Id
     * @param name Jméno
     * @param description Popis
     */
    public Location(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.items = new HashMap<>();
        this.npcs = new ArrayList<>();
        this.exits = new HashMap<>();
    }

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

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    public Map<String, Location> getExits() {
        return exits;
    }

    public void setExits(Map<String, Location> exits) {
        this.exits = exits;
    }

    public void addExit(String direction, Location targetLocation) {
        exits.put(direction, targetLocation);
    }

    // endregion

    public NPC getNpc(String id) {
        for (NPC npc : npcs) {
            if (npc.getId().equals(id)) {
                return npc;
            }
        }
        return null;
    }

    public void removeNpc(String id) {
        npcs.removeIf(npc -> npc.getId().equals(id));
    }

    public Item getItem(String key) {
        return items.get(key);
    }

    public void removeItem(String key) {
        items.remove(key);
    }
}
