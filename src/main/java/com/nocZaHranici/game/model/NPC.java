package com.nocZaHranici.game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída reprezentující postavu ve hře
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
     * Vytvoří novou instanci postavy
     * Inicializuje id, jméno, popis, dialog postavy, zdraví (HP) postavy, ztracené životy při útoku postavy
     * @param id Id
     * @param name Jméno
     * @param description Popis
     * @param health Životy
     * @param attack Útok
     */
    public NPC(String id, String name, String description, int health, int attack) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dialogue = new ArrayList<>();
        this.health = health;
        this.attack = attack;
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


}
