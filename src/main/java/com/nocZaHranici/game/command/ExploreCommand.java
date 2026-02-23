package com.nocZaHranici.game.command;

import com.nocZaHranici.game.QuestState;
import com.nocZaHranici.game.data.QuestData;
import com.nocZaHranici.game.model.*;

import java.util.Map;

/**
 * Třída reprezentující příkaz prozkoumání ve hře
 */
public class ExploreCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;
    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu "prozkoumej"
     * @param world Herní svět
     * @param player Hráč
     */
    public ExploreCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "prozkoumej";
    }

    @Override
    public String execute(String argument) {

        Location location = world.getLocation(player.getCurrentLocationId());

        if (location == null) {
            return "Tato lokace neexistuje.";
        }

        StringBuilder sb = new StringBuilder();

        // Název lokace
        sb.append("📍 ")
                .append(location.getName())
                .append("\n\n");

        // Popis
        sb.append(location.getDescription())
                .append("\n\n");

        // NPC
        if (!location.getNpcs().isEmpty()) {
            sb.append("Postavy:\n");
            for (NPC npc : location.getNpcs()) {
                sb.append("- ")
                        .append(npc.getName())
                        .append("\n");
            }
            sb.append("\n");
        }

        // Předměty
        if (!location.getItems().isEmpty()) {
            sb.append("Předměty:\n");

            for (Item item : location.getItems().values()) {
                sb.append("- ")
                        .append(item.getName())
                        .append("\n");
            }

            sb.append("\n");
        }

        // Východy
        if (!location.getExits().isEmpty()) {
            sb.append("Východy:\n");
            location.getExits().forEach((direction, targetId) ->
                    sb.append("- ")
                            .append(direction)
                            .append("\n"));
        }

        return sb.toString();
    }
}
