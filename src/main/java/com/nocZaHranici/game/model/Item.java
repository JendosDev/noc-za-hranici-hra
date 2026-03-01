package com.nocZaHranici.game.model;

import com.nocZaHranici.game.Game;
import com.nocZaHranici.game.enums.ItemType;

/**
 * Třída reprezentující předměty ve hře
 * @author Jan Karel Vesely
 */
public class Item {
    /**
     * Id
     */
    private String id;
    /**
     * Jméno
     */
    private String name;
    /**
     * Popis
     */
    private String description;
    /**
     * Použitelnost
     */
    private boolean usable;
    /**
     * Typ
     */
    private ItemType type;
    /**
     * Trvanlivost
     */
    private int durability;
    /**
     * Id lokace
     */
    private String locationId;

    /**
     * Vytvoří instanci předmětu
     * Inicializuje potřebné proměnné
     * @param id Id
     * @param name Jméno
     * @param description Popis
     * @param usable Použitelnost
     * @param type Typ
     * @param durability Trvanlivost
     * @param locationId Id lokace
     */
    public Item(String id, String name, String description,
                boolean usable, ItemType type, int durability, String locationId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.usable = usable;
        this.type = type;
        this.durability = durability;
        this.locationId = locationId;
    }


    // region get, set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    // endregion

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", usable=" + usable +
                '}';
    }

    public String use(GameWorld game, Player player) {
        if (!usable) {
            return "Tento předmět nelze použít.";
        }

        switch (type) {
            case RUSTY_KEY:
                return useRustyKey(game, player);

            case TORCH:
                return useTorch(player);

            case NOTEBOOK:
                player.setNotebookRead(true);
                return "Pročetl jsi starý zápisník.";

            case BLOODY_AMULET:
                player.setAmuletEquipped(true);
                return "Nasadil sis zakrvácený amulet.";

            case MOUNTAIN_TALISMAN:
                player.setMountainProtection(true);
                return "Cítíš ochranu horského talismanu.";

            case ROPE:
                return "Použil jsi provaz.";

            case BOUNDARY_DUST:
                return "Prach z hranice nelze odstranit.";
            case HEALTH_POTION:
                return useHealthPotion(player);

            default:
                return "Nelze použít.";
        }
    }

    private String useHealthPotion(Player player) {
        int healAmount = 30;

        if (player.getHealth() >= 100) {
            return "Máš plné zdraví, lektvar teď nepotřebuješ.";
        }

        player.heal(healAmount);
        player.getInventory().removeItem(id); // spotřebuje se

        return "Vypil jsi lektvar a doplnil " + healAmount + " HP. Aktuální HP: " + player.getHealth();
    }

    private String useRustyKey(GameWorld world, Player player) {
        Location location = world
                .getLocation(player.getCurrentLocationId());

        if (location.isHasGate()) {
            location.unlockGate();
            player.getInventory().removeItem(id);
            return "Odemknul jsi starou bránu.";
        }
        return "Tady není co odemykat.";
    }

    private String useTorch(Player player) {

        if (durability <= 0) {
            return "Pochodeň už dohořela.";
        }

        durability--;

        if (durability == 0) {
            player.getInventory().removeItem(id);
            return "Pochodeň dohořela.";
        }

        return "Osvětlil jsi temnou oblast.";
    }
}
