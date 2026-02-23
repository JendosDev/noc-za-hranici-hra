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
     * Temnost
     */
    private boolean dark;
    /**
     * Brána
     */
    private boolean hasGate;
    /**
     * Brána uzavřená?
     */
    private boolean gateLocked;
    /**
     * Útes
     */
    private boolean hasCliff;

    /**
     * Vytvoří instanci lokace
     * Inicializuje proměnné, seznamy a mapu
     * @param id Id
     * @param name Jméno
     * @param description Popis
     */
    public Location(String id, String name, String description,
                    boolean dark, boolean hasGate, boolean gateLocked, boolean hasCliff) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.items = new HashMap<>();
        this.npcs = new ArrayList<>();
        this.exits = new HashMap<>();
        this.dark = dark;
        this.hasGate = hasGate;
        this.gateLocked = gateLocked;
        this.hasCliff = hasCliff;


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

    public boolean isDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public boolean isHasGate() {
        return hasGate;
    }

    public void setHasGate(boolean hasGate) {
        this.hasGate = hasGate;
    }

    public boolean isGateLocked() {
        return gateLocked;
    }

    public void setGateLocked(boolean gateLocked) {
        this.gateLocked = gateLocked;
    }

    public boolean isHasCliff() {
        return hasCliff;
    }

    public void setHasCliff(boolean hasCliff) {
        this.hasCliff = hasCliff;
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

    /**
     * Vrací předmět na základě zadaného klíče
     * @param key Klíč
     * @return Předmět dle zadaného klíče
     */
    public Item getItem(String key) {
        return items.get(key);
    }

    /**
     * Smaže předmět podle zadaného klíče
     * @param key Klíč
     */
    public void removeItem(String key) {
        items.remove(key);
    }

    public void unlockGate() {
        this.gateLocked = false;
    }

    public boolean hasGate() {
        return hasGate;
    }
}
