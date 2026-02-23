package com.nocZaHranici.game.model;

import com.nocZaHranici.game.data.GameData;
import com.nocZaHranici.game.data.LocationData;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class GameWorld {
    /**
     * Herní data
     */
    private GameData data;
    /**
     * Seznam lokací
     */
    private Map<String, Location> locations;

    /**
     * Vytvoří herní svět na základě načtených dat
     * Inicializuje všechny lokace a následně je vzájemně propojí podle definice v JSON souboru.
     * @param data Herní data
     */
    public GameWorld(GameData data) {
        this.locations = new HashMap<>();
        for (LocationData locationData : data.getLocations()) {
            Location location = new Location(
                    locationData.getId(),
                    locationData.getName(),
                    locationData.getDescription(),
                    locationData.isDark(),
                    locationData.isHasGate(),
                    locationData.isGateLocked(),
                    locationData.isHasCliff()
            );

            locations.put(location.getId(), location);
        }

        for (LocationData locationData : data.getLocations()) {
            Location location = locations.get(locationData.getId());
            if (locationData.getExits() != null) {
                for (Map.Entry<String, String> exit : locationData.getExits().entrySet()) {

                    String direction = exit.getKey();
                    String targetLocationId = exit.getValue();

                    Location targetLocation = locations.get(targetLocationId);

                    location.addExit(direction, targetLocation);
                }
            }
        }
    }

    public GameData getData() {
        return data;
    }

    public void setData(GameData data) {
        this.data = data;
    }

    public Location getLocation(String id) {
        return locations.get(id);
    }

    public void printLocations() {
        for (String id : locations.keySet()) {
            System.out.println(id);
        }
    }
}
