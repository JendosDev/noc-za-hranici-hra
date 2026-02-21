package com.nocZaHranici.game.data;

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
     * Vytvoří novou instanci předměty
     * @param id Id
     * @param name Jméno
     * @param description Popis
     * @param usable Použitelnost
     */
    public ItemData(String id, String name, String description, boolean usable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.usable = usable;
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

    // endregion
}
