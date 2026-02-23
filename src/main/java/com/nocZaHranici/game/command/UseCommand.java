package com.nocZaHranici.game.command;

import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Item;
import com.nocZaHranici.game.model.Player;

/**
 * Třída reprezentující příkaz pro použití předmětu ve hře
 */
public class UseCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;
    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu "pouzij"
     * @param world Herní svět
     * @param player Hráč
     */
    public UseCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "pouzij";
    }

    @Override
    public String execute(String argument) {
        if (argument == null || argument.isEmpty()) {
            return "Co chceš použít?";
        }

        Item item = player.getInventory().getItem(argument);

        if (item == null) {
            return "Tento předmět nemáš.";
        }

        return item.use(world, player);
    }
}
