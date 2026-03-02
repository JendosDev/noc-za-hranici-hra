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

        if ("gate".equals(current.getId()) &&
                "final_cave".equals(next.getId()) &&
                current.isGateLocked()) {

            return "Brána je zamčená.";
        }

        if ("final_cave".equals(current.getId()) &&
                !player.hasLightSource()) {

            return "Je zde absolutní tma. Bez pochodně nenajdeš cestu ven.";
        }

        player.setCurrentLocationId(next.getId());

        StringBuilder sb = new StringBuilder();
        sb.append("Nyní jsi v: ").append(next.getName()).append("\n");
        sb.append(next.getDescription()).append("\n");

        // 🏆 FINÁLNÍ VÍTĚZSTVÍ
        if ("final_exit".equals(next.getId())) {

            if (player.isAmuletEquipped() && player.hasLightSource()) {

                sb.append("\n=====================================\n");
                sb.append("✨ VÍTĚZSTVÍ ✨\n");
                sb.append("Odhalil jsi tajemství hranice.\n");
                sb.append("Temnota ustupuje a les konečně mlčí.\n");
                sb.append("Hranice tě propouští zpět do světa lidí.\n");
                sb.append("Přežil jsi noc za hranicí.\n");
                sb.append("=====================================\n");

                player.setEscaped(true);
                return sb.toString();
            }
            else {
                sb.append("\nCítíš, že zde něco chybí.\n");

                if (!player.isAmuletEquipped()) {
                    sb.append("Bez zakrváceného amuletu zde nemáš šanci.\n");
                }

                if (!player.hasLightSource()) {
                    sb.append("Tma je příliš silná bez světla.\n");
                }

                return sb.toString();
            }
        }

        // ⚔️ Aggressive NPC útok
        NPC attacker = next.getFirstAggressiveNpc();
        if (attacker != null) {

            int dmg = attacker.getAttack();
            player.takeDamage(dmg);

            sb.append("\n⚠️ ")
                    .append(attacker.getName())
                    .append(" na tebe zaútočil jako první a způsobil ")
                    .append(dmg)
                    .append(" HP!\n");

            sb.append("Tvoje HP: ").append(player.getHealth()).append("\n");

            if (!player.isAlive()) {
                sb.append("💀 Zemřel jsi.\n");
            }
        }

        return sb.toString();
    }
}
