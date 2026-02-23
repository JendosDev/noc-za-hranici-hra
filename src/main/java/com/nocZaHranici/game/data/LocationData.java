package com.nocZaHranici.game.data;

import com.nocZaHranici.game.model.Item;
import com.nocZaHranici.game.model.NPC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Třída reprezentující lokace v souboru
 */
public class LocationData {
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
     * Předměty lokace
     */
    private List<String> items;
    /**
     * Postavy lokace
     */
    private List<String> npcs;
    /**
     * Východy
     */
    private Map<String, String> exits;
    /**
     * Temnota
     */
    private boolean dark;
    /**
     * Brána
     */
    private boolean hasGate;
    /**
     * Brána zavřená
     */
    private boolean gateLocked;
    /**
     * Sráz
     */
    private boolean hasCliff;

    /**
     * Vytvoří instanci lokace v souboru
     * @param id Id
     * @param name Jméno
     * @param description Popis
     */
    public LocationData(String id, String name, String description,
                        boolean dark, boolean hasGate, boolean gateLocked, boolean hasCliff) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.exits = new HashMap<>();
        this.dark = dark;
        this.hasGate = hasGate;
        this.gateLocked = gateLocked;
        this.hasCliff = hasCliff;
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

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<String> npcs) {
        this.npcs = npcs;
    }

    public Map<String, String> getExits() {
        return exits;
    }

    public void setExits(Map<String, String> exits) {
        this.exits = exits;
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
}
