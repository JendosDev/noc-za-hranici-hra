package com.nocZaHranici.game.command;

import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Player;

/**
 * Třída reprezentující příkaz nápovědy ve hře
 */
public class HelpCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;
    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu "napoveda"
     * @param world Herní svět
     * @param player Hráč
     */
    public HelpCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "napoveda";
    }

    @Override
    public String execute(String argument) {
        return """
                Dostupné příkazy:
                - jdi <směr>
                - vezmi <item>
                - zahod <item>
                - pouzij <item>
                - mluv
                - ukoly
                - inventar
                - pomoc
                """;
    }
}
