package com.nocZaHranici.game.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída reprezentující postavu v souboru
 * @author Jan Karel Vesely
 */
public class NPCData {
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
     * Dialog postavy
     */
    private List<String> dialogue;
    /**
     * Zdraví
     */
    private int health;
    /**
     * Útok
     */
    private int attack;
    /**
     * Id lokace
     */
    private String locationId;
    /**
     * Id získaného předmětu
     */
    private String dropItemId;
    /**
     * Agresivní
     */
    private boolean aggressive;

    /**
     * Vytvoří novou instanci postavy v souboru
     * Inicializuje dialog postavy
     * @param id Id
     * @param name Jméno
     * @param description Popis
     * @param health Zdraví
     * @param attack útok
     * @param locationId Id lokace
     */
    public NPCData(String id, String name, String description,
                   int health, int attack,
                   String locationId, String dropItemId, boolean aggressive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dialogue = new ArrayList<>();
        this.health = health;
        this.attack = attack;
        this.locationId = locationId;
        this.dropItemId = dropItemId;
        this.aggressive = aggressive;
    }

    public NPCData() {
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

    public List<String> getDialogue() {
        return dialogue;
    }

    public void setDialogue(List<String> dialogue) {
        this.dialogue = dialogue;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getDropItemId() {
        return dropItemId;
    }

    public void setDropItemId(String dropItemId) {
        this.dropItemId = dropItemId;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }

    // endregion
}
