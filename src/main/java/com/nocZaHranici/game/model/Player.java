package com.nocZaHranici.game.model;

import com.nocZaHranici.game.Inventory;
import com.nocZaHranici.game.QuestState;
import com.nocZaHranici.game.data.QuestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Třída reprezentující hráče ve hře
 */
public class Player {

    // =========================
    // ZÁKLADNÍ INFORMACE
    // =========================

    /**
     * Id aktuální lokace
     */
    private String currentLocationId;

    /**
     * Inventář hráče
     */
    private Inventory inventory;

    /**
     * Úkoly hráče (id -> stav)
     */
    private Map<String, QuestState> quests;

    /**
     * Útok
     */
    private int attack;

    /**
     * Zdraví
     */
    private int health;

    // =========================
    // HERNÍ STAVY
    // =========================

    /**
     * Čtení zápisníku
     */
    private boolean notebookRead;
    /**
     * Amulet vybavený
     */
    private boolean amuletEquipped;
    /**
     * Ochrana hor
     */
    private boolean mountainProtection;

    /**
     * Zdroj světla
     */
    private boolean lightSource;

    private boolean escaped;
    /**
     * Umrtí
     */
    private boolean dead;

    /**
     * Vytvoří instanci hráče
     */
    public Player(String currentLocationId) {
        this.currentLocationId = currentLocationId;
        this.inventory = new Inventory();
        this.quests = new HashMap<>();

        this.health = 100;
        this.attack = 10;

        this.notebookRead = false;
        this.amuletEquipped = false;
        this.mountainProtection = false;
        this.lightSource = false;
    }

    public String getCurrentLocationId() {
        return currentLocationId;
    }

    public void setCurrentLocationId(String currentLocationId) {
        this.currentLocationId = currentLocationId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Item getItemFromInventory(String id) {
        return inventory.getItem(id);
    }

    public Map<String, QuestState> getQuests() {
        return quests;
    }

    public List<String> getActiveQuests() {

        List<String> active = new ArrayList<>();

        for (Map.Entry<String, QuestState> entry : quests.entrySet()) {
            if (entry.getValue() == QuestState.ACTIVE) {
                active.add(entry.getKey());
            }
        }

        return active;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;

        if (health > 100) {
            health = 100;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isNotebookRead() {
        return notebookRead;
    }

    public void setNotebookRead(boolean notebookRead) {
        this.notebookRead = notebookRead;
    }

    public boolean isAmuletEquipped() {
        return amuletEquipped;
    }

    public void setAmuletEquipped(boolean amuletEquipped) {
        this.amuletEquipped = amuletEquipped;
    }

    public boolean hasMountainProtection() {
        return mountainProtection;
    }

    public void setMountainProtection(boolean mountainProtection) {
        this.mountainProtection = mountainProtection;
    }

    public boolean hasLightSource() {
        return lightSource;
    }

    public void setLightSource(boolean lightSource) {
        this.lightSource = lightSource;
    }

    public boolean hasEscaped() {
        return escaped;
    }

    public void setEscaped(boolean escaped) {
        this.escaped = escaped;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public String toString() {
        return "Player{" +
                "location='" + currentLocationId + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", notebookRead=" + notebookRead +
                ", amuletEquipped=" + amuletEquipped +
                ", mountainProtection=" + mountainProtection +
                ", lightSource=" + lightSource +
                '}';
    }
}
