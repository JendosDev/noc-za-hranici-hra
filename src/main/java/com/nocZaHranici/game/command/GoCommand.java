package com.nocZaHranici.game.command;

import com.nocZaHranici.game.Game;
import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Location;
import com.nocZaHranici.game.model.NPC;
import com.nocZaHranici.game.model.Player;

/**
 * Třída reprezentující příkaz pro pohyb hráče
 * @author Jan Karel Vesely
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

        if (current == null) {
            return "Aktuální lokace neexistuje.";
        }

        Location next = current.getExits().get(direction);

        if (next == null) {
            return "Tímto směrem nemůžeš jít.";
        }

        if (current.isHasGate() && current.isGateLocked()) {
            return "Brána je zamčená.";
        }

        player.setCurrentLocationId(next.getId());

        StringBuilder sb = new StringBuilder();
        sb.append("Nyní jsi v: ").append(next.getName()).append("\n");
        sb.append(next.getDescription()).append("\n");

        NPC attacker = next.getFirstAggressiveNpc();
        if (attacker != null) {
            int dmg = attacker.getAttack();
            player.takeDamage(dmg);

            sb.append("\n⚠️ ").append(attacker.getName())
                    .append(" na tebe zaútočil jako první a způsobil ")
                    .append(dmg).append(" HP!\n");
            sb.append("Tvoje HP: ").append(player.getHealth()).append("\n");

            if (!player.isAlive()) {
                sb.append("💀 Zemřel jsi.");
            }
        }

        return sb.toString();
    }
}
