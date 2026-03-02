package com.nocZaHranici.game.command;

import com.nocZaHranici.game.model.*;

/**
 * Třída reprezentující příkaz útoku ve hře
 * @author Jan Karel Vesely
 */
public class AttackCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;
    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu "pouzij"
     * @param world Herní svět
     * @param player Hráč
     */
    public AttackCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "utoc";
    }

    @Override
    public String execute(String npcId) {
        if (npcId == null || npcId.isEmpty()) {
            return "Koho chceš napadnout? Zadej platné ID NPC.";
        }

        Location location = world.getLocation(player.getCurrentLocationId());
        if (location == null) {
            return "Chybí aktuální lokace hráče!";
        }

        NPC npc = location.getNpc(npcId);
        if (npc == null) {
            return "NPC s tímto ID zde není.";
        }

        if (!npc.isAlive()) {
            return npc.getName() + " už je mrtvý.";
        }

        StringBuilder result = new StringBuilder();

        int playerDamage = player.getAttack();
        npc.takeDamage(playerDamage);

        result.append("Zaútočil jsi na ")
                .append(npc.getName())
                .append(" za ")
                .append(playerDamage)
                .append(" HP.\n");

        if (!npc.isAlive()) {
            result.append(npc.getName()).append(" zemřel.\n");

            String dropId = npc.getDropItemId();
            if (dropId != null && !dropId.isEmpty()) {
                Item droppedItem = world.createItemById(dropId);

                if (droppedItem != null) {
                    location.getItems().put(droppedItem.getId(), droppedItem);
                    result.append("Z nepřítele vypadl: ")
                            .append(droppedItem.getName())
                            .append("\n");
                }
            }

            player.heal(50);
            location.removeNpc(npcId);
            return result.toString();
        }

        int npcDamage = npc.getAttack();
        player.takeDamage(npcDamage);

        result.append(npc.getName())
                .append(" ti útok vrátil za ")
                .append(npcDamage)
                .append(" HP.\n");

        if (!player.isAlive()) {
            result.append("💀 Zemřel jsi.");
        } else {
            result.append("Zbývá ti ").append(player.getHealth()).append(" HP.");
        }

        return result.toString();
    }
}
