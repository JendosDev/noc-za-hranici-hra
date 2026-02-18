package com.nocZaHranici.game.command;

import com.nocZaHranici.game.Game;
import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Location;
import com.nocZaHranici.game.model.Player;

public class GoCommand implements Command {
    private GameWorld world;
    private Player player;

    public GoCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

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
