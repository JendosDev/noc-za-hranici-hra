package com.nocZaHranici.game.command;

import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Location;
import com.nocZaHranici.game.model.NPC;
import com.nocZaHranici.game.model.Player;

/**
 * Třída reprezentující příkaz útoku ve hře
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

        npc.takeDamage(player.getAttack());

        String result = "Zaútočil jsi na " + npc.getName() + " za " + player.getAttack() + " HP.";

        if (!npc.isAlive()) {
            result += "\n" + npc.getName() + " zemřel.";
            location.removeNpc(npcId);
        }

        return result;
    }
}
