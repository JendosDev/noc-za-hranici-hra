package com.nocZaHranici.game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída reprezentující postavu ve hře
 * @author Jan Karel Vesely
 */
public class NPC {
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
     * Dialog
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
     * Vytvoří novou instanci postavy
     * Inicializuje id, jméno, popis, dialog postavy, zdraví (HP) postavy, ztracené životy při útoku postavy
     * @param id Id
     * @param name Jméno
     * @param description Popis
     * @param health Životy
     * @param attack Útok
     * @param locationId Id lokace
     * @param dropItemId Id získaného předmětu
     */
    public NPC(String id, String name, String description,
               int health, List<String> dialogue,
               int attack, String locationId,
               String dropItemId, boolean aggressive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dialogue = dialogue;
        this.health = health;
        this.attack = attack;
        this.locationId = locationId;
        this.dropItemId = dropItemId;
        this.aggressive = aggressive;
    }

    public NPC(String id, String name,
               String description, int health, int attack, String locationId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.health = health;
        this.attack = attack;
        this.locationId = locationId;
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

    /**
     * Odečítá ztracené životy po útoku
     * @param attack Útok
     */
    public void takeDamage(int attack) {
        health -= attack;
    }

    /**
     * Vrací dialog postavy
     * @return Dialog postavy
     */
    public String talk(Player player) {
        if (dialogue == null || dialogue.isEmpty()) {
            return "Postava mlčí.";
        }

        // příklad reakce podle questů
        if (player.getQuests().containsKey(id)) {
            return dialogue.get(1);
        }

        return dialogue.get(0);
    }

    /**
     * Vrací logickou hodnotu, zda postava žije
     * @return Zda postava žije
     */
    public boolean isAlive() {
        if (health <= 0) {
            health = 0;
            return false;
        }
        return true;
    }

    public String getDropItemId() {
        return dropItemId;
    }
}
