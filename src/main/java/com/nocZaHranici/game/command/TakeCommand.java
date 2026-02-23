package com.nocZaHranici.game.command;

import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Item;
import com.nocZaHranici.game.model.Location;
import com.nocZaHranici.game.model.Player;

/**
 * Třída reprezentující příkaz vezmi ve hře
 */
public class TakeCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;
    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu "vezmi"
     * @param world Herní svět
     * @param player Hráč
     */
    public TakeCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "vezmi";
    }

    @Override
    public String execute(String argument) {
        if (argument == null || argument.isEmpty()) {
            return "Co chceš sebrat?";
        }

        Location current = world.getLocation(player.getCurrentLocationId());
        Item item = current.getItem(argument);

        if (item == null) {
            return "Tento předmět zde není";
        }
        player.getInventory().addItem(item);
        current.removeItem(argument);

        return "Sebral jsi " + item.getName();
    }
}
