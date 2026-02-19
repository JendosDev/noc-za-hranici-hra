package com.nocZaHranici.game.command;

import com.nocZaHranici.game.Game;
import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Location;
import com.nocZaHranici.game.model.Player;

/**
 * Třída reprezentující příkaz pro pohyb hráče
 */
public class GoCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;

    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu pro pohyb hráče
     * @param world Herní svět
     * @param player Hráč
     */
    public GoCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "jdi";
    }

    /**
     * Metoda zaznamenává aktuální lokaci hráče
     * Po přechodu hráče přenastaví aktuální lokaci
     * @param direction Směřovaná lokace
     */
    @Override
    public String execute(String direction) {
        if (direction == null || direction.isEmpty()) {
            return "Kam chceš jít?";
        }

        Location current = world.getLocation(player.getCurrentLocationId());
        Location next = current.getExits().get(direction);

        if (next == null) {
            return "Tímto směrem nemůžeš jít.";
        }

        player.setCurrentLocationId(next.getId());

        return "Nyní jsi v: " + next.getName();
    }
}
