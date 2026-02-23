package com.nocZaHranici.game.command;

import com.nocZaHranici.game.Game;
import com.nocZaHranici.game.Inventory;
import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Item;
import com.nocZaHranici.game.model.Player;

/**
 * Třída reprezentující příkaz inventáře ve hře
 */
public class InventoryCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;
    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu "inventar"
     * @param world Herní svět
     * @param player Hráč
     */
    public InventoryCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "inventar";
    }

    @Override
    public String execute(String argument) {
        Inventory inventory = player.getInventory();

        if (inventory.isEmpty()) {
            System.out.println("Inventář je prázdný.");
        }

        StringBuilder sb = new StringBuilder("Tvůj inventář:\n");

        for (Item item : inventory.getItems()) {
            sb.append("- ")
                .append(item.getName())
                .append("\n");
        }
        return sb.toString();
    }
}
