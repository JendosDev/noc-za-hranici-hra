package com.nocZaHranici.game.model;

import com.nocZaHranici.game.Inventory;
import com.nocZaHranici.game.enums.QuestState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Třída reprezentující hráče ve hře.
 * Obsahuje informace o zdraví, útoku a inventáři.
 *
 * @author Jan Karel Vesely
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
     * Maximální životy
     */
    private int maxHealth;

    /**
     * Vytvoří instanci hráče
     */
    public Player(String currentLocationId) {
        this.currentLocationId = currentLocationId;
        this.inventory = new Inventory();
        this.quests = new HashMap<>();

        this.health = 200;
        this.attack = 15;

        this.notebookRead = false;
        this.amuletEquipped = false;
        this.mountainProtection = false;
        this.lightSource = false;
    }

    public Player(String currentLocationId, int health, int attack) {
        this.currentLocationId = currentLocationId;

        this.health = health;
        this.attack = attack;
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

        if (health > 200) {
            health = 200;
        }
    }

    // region get, set
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

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setQuests(Map<String, QuestState> quests) {
        this.quests = quests;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isMountainProtection() {
        return mountainProtection;
    }

    public boolean isLightSource() {
        return lightSource;
    }

    public boolean isEscaped() {
        return escaped;
    }

    // endregion

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

    /**
     * Zkontroluje, zda hráč vlastní předmět podle ID.
     *
     * @param itemId ID předmětu
     * @return true pokud předmět má, jinak false
     */
    /**
     * Zkontroluje, zda hráč vlastní předmět podle ID.
     *
     * @param itemId ID předmětu
     * @return true pokud hráč předmět má, jinak false
     */
    public boolean hasItem(String itemId) {

        if (itemId == null) {
            return false;
        }

        for (Item item : inventory.getItems()) {
            if (item.getId().equals(itemId)) {
                return true;
            }
        }

        return false;
    }
}
