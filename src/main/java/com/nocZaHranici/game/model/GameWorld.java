package com.nocZaHranici.game.model;

import com.nocZaHranici.game.data.*;
import com.nocZaHranici.game.enums.ItemType;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Třída reprezentující herní svět
 * @author Jan Karel Vesely
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
     * Seznam úkolů
     */
    private Map<String, Quest> quests;

    /**
     * Vytvoří herní svět na základě načtených dat
     * Inicializuje všechny lokace a následně je vzájemně propojí podle definice v JSON souboru.
     * @param data Herní data
     */
    public GameWorld(GameData data) {
        this.locations = new HashMap<>();
        this.quests = new HashMap<>();
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



        for (ItemData itemData : data.getItems()) {
            ItemType type = ItemType.valueOf(itemData.getType());

            Item item = new Item(
                    itemData.getId(),
                    itemData.getName(),
                    itemData.getDescription(),
                    itemData.isUsable(),
                    type,
                    itemData.getDurability(),
                    itemData.getLocationId()
            );

            String locationId = itemData.getLocationId();

            Location location = locations.get(locationId);

            if (location != null) {
                location.getItems().put(item.getId(), item);
            }
        }

        for (NPCData npcData : data.getNpcs()) {
            NPC npc = new NPC(
                npcData.getId(),
                npcData.getName(),
                npcData.getDescription(),
                npcData.getHealth(),
                npcData.getDialogue(),
                npcData.getAttack(),
                npcData.getLocationId(),
                npcData.getDropItemId(),
                npcData.isAggressive()
            );

            String locationId = npcData.getLocationId();

            Location location = locations.get(locationId);

            if (location != null) {
                location.getNpcs().add(npc);
            }
        }

        for (QuestData questData : data.getQuests()) {

            Quest quest = new Quest(
                    questData.getId(),
                    questData.getName(),
                    questData.getDescription(),
                    questData.getRequiredItemId(),
                    questData.getTargetNpcId(),
                    questData.getRewardItemId(),
                    questData.getObjectiveText()
            );

            quests.put(quest.getId(), quest);
        }
    }

    public GameData getData() {
        return data;
    }

    public void setData(GameData data) {
        this.data = data;
    }

    public Map<String, Location> getLocations() {
        return locations;
    }

    public void setLocations(Map<String, Location> locations) {
        this.locations = locations;
    }

    public Location getLocation(String id) {
        return locations.get(id);
    }

    public void printLocations() {
        for (String id : locations.keySet()) {
            System.out.println(id);
        }
    }

    public Quest getQuest(String argument) {
        return quests.get(argument);
    }

    public Map<String, Quest> getQuests() {
        return quests;
    }

    public Item createItemById(String id) {

        for (ItemData itemData : data.getItems()) {
            if (itemData.getId().equals(id)) {

                return new Item(
                        itemData.getId(),
                        itemData.getName(),
                        itemData.getDescription(),
                        itemData.isUsable(),
                        ItemType.valueOf(itemData.getType()),
                        itemData.getDurability(),
                        null
                );
            }
        }

        return null;
    }
}
