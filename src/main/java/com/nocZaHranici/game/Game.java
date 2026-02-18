package com.nocZaHranici.game;

import com.nocZaHranici.game.command.Command;
import com.nocZaHranici.game.data.GameData;
import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Location;
import com.nocZaHranici.game.model.NPC;
import com.nocZaHranici.game.model.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída reprezentující herní logiku
 */
public class Game {
    private Player player;
    private GameWorld world;
    private Map<String, Command> commands;
    private boolean running;

    /**
     * Vytvoří instanci hry a inicializuje základní herní objekty.
     * Nastaví počáteční lokaci hráče a připraví strukturu pro registraci příkazů.
     */
    public Game() {
        this.player = new Player("village");
        this.commands = new HashMap<>();
    }

    /**
     * Inicializuje hru
     * Načte herní svět z JSON souboru
     * Nastaví výchozí stav hry
     * Zobrazí úvodní informace o aktuální lokaci
     */
    public void start() {
        GameData data = GameData.loadGameDataFromResources("gameData.json");

        world = new GameWorld(data);

        running = true;

        Location location = world.getLocation(player.getCurrentLocationId());

        System.out.println("=====================================");
        System.out.println("           NOC ZA HRANICÍ");
        System.out.println("=====================================");

        // Úvodní příběh
        System.out.println("\nProbouzíš se ve vesnici na okraji temného lesa.");
        System.out.println("Nikdo neví, co se skrývá za starou bránou.");
        System.out.println("Někteří tvrdí, že tam není nic...");
        System.out.println("Jiní říkají, že tam není návratu.");

        System.out.println("\nCítíš chlad. Něco není v pořádku.");

        // Informace o lokaci
        System.out.println("\n-------------------------------------");
        System.out.println("Nacházíš se v lokaci:");
        System.out.println(location.getName());
        System.out.println("-------------------------------------");

        System.out.println(location.getDescription());

        // Východy
        System.out.println("\nDostupné cesty:");

        for (String exit : location.getExits().keySet()) {
            System.out.println(" - " + exit);
        }

        // NPC
        if (!location.getNpcs().isEmpty()) {
            System.out.println("\nVidíš zde:");
            for (NPC npc : location.getNpcs()) {
                System.out.println(" - " + npc.getName());
            }
        }

        // Nápověda
        System.out.println("\n-------------------------------------");
        System.out.println("Dostupné příkazy:");
        System.out.println("go <místo>");
        System.out.println("look");
        System.out.println("attack <npc>");
        System.out.println("help");
        System.out.println("-------------------------------------");

        System.out.println("\nCo uděláš?");
    }

    // region get, set
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameWorld getWorld() {
        return world;
    }

    public void setWorld(GameWorld world) {
        this.world = world;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(Map<String, Command> commands) {
        this.commands = commands;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    // endregion
}
