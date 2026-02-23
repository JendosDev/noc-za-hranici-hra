package com.nocZaHranici.game.command;

import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Location;
import com.nocZaHranici.game.model.NPC;
import com.nocZaHranici.game.model.Player;

/**
 * Třída reprezentující příkaz pro mluvení ve hře
 */
public class TalkCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;
    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu "mluv"
     * @param world Herní svět
     * @param player Hráč
     */
    public TalkCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "mluv";
    }

    @Override
    public String execute(String argument) {
        Location location = world.getLocation(player.getCurrentLocationId());

        NPC npc = location.getNpc(argument);

        if (npc == null) {
            return "Není tu s kým mluvit.";
        }

        return npc.talk(player);
    }
}
