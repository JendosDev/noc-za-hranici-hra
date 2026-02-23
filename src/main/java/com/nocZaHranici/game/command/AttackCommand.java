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
            System.out.println("Koho chceš napadnout?");
        }

        Location location = world.getLocation(player.getCurrentLocationId());

        NPC npc = location.getNpc(npcId);

        npc.takeDamage(player.getAttack());

        if (!npc.isAlive()) {
            System.out.println(npc.getName() + " zemřel.");
            location.removeNpc(npcId);
        }
        return "Zaútočil jsi na " + npc + " za " + npc.getAttack() + " HP.";
    }
}
