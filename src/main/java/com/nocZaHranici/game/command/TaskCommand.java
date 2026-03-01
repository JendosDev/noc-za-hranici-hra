package com.nocZaHranici.game.command;

import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Player;
import com.nocZaHranici.game.model.Quest;

/**
 * Třída reprezentující příkaz úkolů ve hře
 * @author Jan Karel Vesely
 */
public class TaskCommand implements Command {
    /**
     * Herní svět
     */
    private GameWorld world;
    /**
     * Hráč
     */
    private Player player;

    /**
     * Vytvoří instanci příkazu "ukoly"
     * @param world Herní svět
     * @param player Hráč
     */
    public TaskCommand(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String getName() {
        return "ukoly";
    }

    @Override
    public String execute(String argument) {
        if (argument == null || argument.isEmpty()) {

            StringBuilder sb = new StringBuilder("Dostupné úkoly:\n");

            for (Quest quest : world.getQuests().values()) {

                sb.append("- ")
                        .append(quest.getId())
                        .append(" | ")
                        .append(quest.getName());

                if (quest.isActive()) {
                    sb.append(" (aktivní)");
                }

                if (quest.isCompleted()) {
                    sb.append(" (splněno)");
                }

                sb.append("\n");
            }

            return sb.toString();
        }

        Quest quest = world.getQuest(argument);

        if (quest == null) {
            return "Takový úkol neexistuje.";
        }

        if (quest.isCompleted()) {
            return "Tento úkol už je splněn.";
        }

        if (quest.isActive()) {
            return "Tento úkol už je aktivní.";
        }

        quest.activate();
        return "Aktivoval jsi úkol: " + quest.getName()
                + "\nPopis: " + quest.getDescription()
                + "\nPotřebný předmět: " + quest.getRequiredItemId();
    }
}
