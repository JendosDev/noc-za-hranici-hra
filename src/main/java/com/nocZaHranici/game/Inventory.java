package com.nocZaHranici.game;

import com.nocZaHranici.game.model.Item;

import java.util.*;

/**
 * Třída reprezentující hráčův inventář ve hře
 */
public class Inventory {
    private Map<String, Item> items;
    private static final int ITEM_COUNT = 2;

    /**
     * Vytvoří instanci inventáře
     * Inicializuje mapu předmětů
     */
    public Inventory() {
        this.items = new HashMap<>();
    }

    // region get, set
    public Collection<Item> getItems() {
        return items.values();
    }


    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    // endregion

    /**
     * Přidá předmět do inventáře za předpokladu, že inventář není plný
     * @param item Přidaný předmět
     */
    public void addItem(Item item) {
        if (items.size() >= ITEM_COUNT) {
            System.out.println("Inventář je plný.");
        }
        items.put(item.getId(), item);
    }

    /**
     * Nachází předmět pomocí jeho ID
     * @param id Id
     * @return Předmět podle ID
     */
    public Item getItem(String id) {
        return items.get(id);
    }

    /**
     * Smaže předmět pomocí jeho ID
     * @param id Id
     */
    public void removeItem(String id) {
        if (items.isEmpty()) {
            System.out.println("Inventář je prázdný.");
        }
        items.remove(id);
    }

    /**
     * Kontroluje zda je seznam předmětů (inventář) prázdný
     * @return Zda je seznam prázdný
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }


}
