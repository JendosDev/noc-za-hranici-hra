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

    /**
     * Metoda zaznamenává aktuální lokaci hráče
     * Po přechodu hráče přenastaví aktuální lokaci
     * @param direction Směřovaná lokace
     */
    @Override
    public void execute(String direction) {
        Location currentLocation = world.getLocation(player.getCurrentLocationId());

        Location nextLocation = currentLocation.getExits().get(direction);

        if (nextLocation == null) {
            System.out.println("Tímto směrem nelze nemůžeš.");
            return;
        }

        player.setCurrentLocationId(nextLocation.getId());

        System.out.println("Jsi nyní v: " + nextLocation.getName());
    }
}
