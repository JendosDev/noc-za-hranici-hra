package com.nocZaHranici.game.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída reprezentující postavu v souboru
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
     * Vytvoří novou instanci postavy v souboru
     * Inicializuje dialog postavy
     * @param id Id
     * @param name Jméno
     * @param description Popis
     */
    public NPCData(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dialogue = new ArrayList<>();
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

    // endregion
}
