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
    /**
     * Id aktuální lokace
     */
    private String currentLocationId;
    /**
     * Inventář
     */
    private Inventory inventory;
    /**
     * Úkoly
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

    /**
     * Vytvoří instanci hráče
     * Inicializuje hráčův inventář, aktuální lokaci, úkoly
     * @param currentLocationId Id aktuální lokace
     */
    public Player(String currentLocationId) {
        this.currentLocationId = currentLocationId;
        this.inventory = new Inventory();
        this.quests = new HashMap<>();

        this.health = 100;
        this.attack = 10;
    }

    // region get, set

    public String getCurrentLocationId() {
        return currentLocationId;
    }

    public void setCurrentLocationId(String currentLocationId) {
        this.currentLocationId = currentLocationId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Map<String, QuestState> getQuests() {
        return quests;
    }

    public void setQuests(Map<String, QuestState> quests) {
        this.quests = quests;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // endregion

    /**
     * Odečte ztracené HP hráči ze zdraví
     * @param damage Počet ztracených HP
     */
    private void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Získá konkrétní předmět z inventáře na základě ID
     * @param id Id
     * @return Konkrétní předmět
     */
    public Item getItemFromInventory(String id) {
        return inventory.getItem(id);
    }

    @Override
    public String toString() {
        return "Player{" +
                "currentLocationId='" + currentLocationId + '\'' +
                ", inventory=" + inventory +
                ", quests=" + quests +
                ", attack=" + attack +
                ", health=" + health +
                '}';
    }

    public boolean isAlive() {
        if (health <= 0) {
            health = 0;
            return false;
        }
        return true;
    }
}
