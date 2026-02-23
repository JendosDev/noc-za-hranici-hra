package com.nocZaHranici.game.data;

import com.nocZaHranici.game.enums.ItemType;

/**
 * Tčída reprezentující předměty v souboru
 */
public class ItemData {
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
     * Použitelnost
     */
    private boolean usable;
    /**
     * Typ
     */
    private String type;
    /**
     * Trvanlivost
     */
    private int durability;

    /**
     * Vytvoří novou instanci předměty v souboru
     * @param id Id
     * @param name Jméno
     * @param description Popis
     * @param usable Použitelnost
     * @param type Typ
     * @param durability Trvanlivost
     */
    public ItemData(String id, String name, String description,
                    boolean usable, String type, int durability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.usable = usable;
        this.type = type;
        this.durability = durability;
    }

    public ItemData() {

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

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    // endregion
}
