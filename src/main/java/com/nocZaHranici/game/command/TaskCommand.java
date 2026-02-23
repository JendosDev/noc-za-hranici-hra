package com.nocZaHranici.game.command;

import com.nocZaHranici.game.QuestState;
import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Player;
import com.nocZaHranici.game.model.Quest;

import java.util.List;
import java.util.Map;

/**
 * Třída reprezentující příkaz úkolů ve hře
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
        Map<String, QuestState> quests = player.getQuests();

        if (quests.isEmpty()) {
            return "Nemáš žádné úkoly.";
        }

        StringBuilder sb = new StringBuilder("Úkoly:\n");

        for (Map.Entry<String, QuestState> entry : quests.entrySet()) {

            sb.append("- ")
                    .append(entry.getKey())
                    .append(" (")
                    .append(entry.getValue())
                    .append(")\n");
        }

        return sb.toString();
    }
}
