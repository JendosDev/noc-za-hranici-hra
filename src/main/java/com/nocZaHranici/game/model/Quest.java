package com.nocZaHranici.game.model;

/**
 * Třída reprezentující úkol ve hře
 */
public class Quest {
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
     * Dokončeno
     */
    private boolean completed;

    /**
     * Vytvoří novou instanci úkolu
     * Inicializuje id (id), jméno (name), popis (description), zda je úkol dokončen (completed)
     * @param id Id
     * @param name Jméno
     * @param description Popis
     * @param completed Dokončeno
     */
    public Quest(String id, String name, String description, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // endregion
}
