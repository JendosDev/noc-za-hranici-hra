package com.nocZaHranici.game.data;

import com.google.gson.Gson;
import com.nocZaHranici.game.model.Item;
import com.nocZaHranici.game.model.NPC;
import com.nocZaHranici.game.model.Player;
import com.sun.tools.javac.Main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GameData {
    private List<LocationData> locations;
    private List<QuestData> quests;
    private List<NPCData> npcs;
    private List<ItemData> items;


    /**
     * Vytvoří instanci herních dat
     * Iniciolizuje seznamy lokací, úkolů, NPC, předmětů
     */
    public GameData() {
        this.locations = new ArrayList<>();
        this.quests = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    // region get, set

    public List<LocationData> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationData> locations) {
        this.locations = locations;
    }

    public List<QuestData> getQuests() {
        return quests;
    }

    public void setQuests(List<QuestData> quests) {
        this.quests = quests;
    }

    public List<NPCData> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPCData> npcs) {
        this.npcs = npcs;
    }

    public List<ItemData> getItems() {
        return items;
    }

    public void setItems(List<ItemData> items) {
        this.items = items;
    }

    // endregion

    /**
     * Načte herní data z konfiguračního JSON souboru umístěného ve složce resources
     * a převede je na instanci třídy GameData.
     *
     * @param resourcePath cesta k souboru v classpath (např. "gameData.json")
     * @return naplněná instance GameData obsahující definici herního světa
     * @throws RuntimeException pokud dojde k chybě při načítání nebo zpracování souboru
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        //Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        //Načtení souboru gamedata.json, musí být ve složce res/resources, ta musí být označena jako resource složka projektu
        try (InputStream is = GameData.class.getClassLoader().getResourceAsStream(resourcePath)) {

            //Zde ověřujeme, zdali soubor existuje
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }

            //Přečte celý JSON a vytvoří instanci GameData, naplní vlastnosti podle názvů klíčů v JSONU, vrátí se hotová třída GameData
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    /**
     * Vrací nalezený úkol podle zadaného id, pokud se úkolu shoduje se zadaným id
     * @param questId Quest Id
     * @return Nalezený úkol
     */
    public QuestData getQuestById(String questId) {

        for (QuestData quest : quests) {
            if (quest.getId().equals(questId)) {
                return quest;
            }
        }

        return null;
    }
}
