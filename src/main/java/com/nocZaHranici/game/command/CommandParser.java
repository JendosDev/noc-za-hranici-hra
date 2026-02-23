package com.nocZaHranici.game.command;

import com.nocZaHranici.game.model.GameWorld;
import com.nocZaHranici.game.model.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Třída sloužící ke zpracování hráčových příkazů.
 * Uchovává mapu dostupných příkazů a podle vstupu hráče
 * vyhledá a vykoná odpovídající příkaz.
 */
public class CommandParser {
    /**
     * Mapa všech dostupných příkazů ve hře.
     * Klíčem je název příkazu (např. "jdi"),
     * hodnotou je instance konkrétního příkazu.
     */
    private Map<String, Command> commands;

    /**
     * Vytvoří parser příkazů a zaregistruje všechny dostupné příkazy.
     *
     * @param world herní svět
     * @param player hráč
     */
    public CommandParser(GameWorld world, Player player) {
        this.commands = new HashMap<>();

        commands.put("jdi", new GoCommand(world, player));
        commands.put("vezmi", new TakeCommand(world, player));
        commands.put("pouzij", new UseCommand(world, player));
        commands.put("mluv", new TalkCommand(world, player));
        commands.put("prozkoumej", new ExploreCommand(world, player));
        commands.put("inventar", new InventoryCommand(world, player));
        commands.put("utoc", new AttackCommand(world, player));
        commands.put("ukoly", new TaskCommand(world, player));
        commands.put("napoveda", new HelpCommand(world, player));
    }

    /**
     * Zpracuje textový vstup hráče.
     * Rozdělí vstup na název příkazu a argument
     * a následně provede odpovídající příkaz.
     *
     * @param input text zadaný hráčem
     */
    public void parse(String input) {
        String[] parts = input.split(" ", 2);

        String name = parts[0];
        String arg = parts.length > 1 ? parts[1] : "";

        Command command = commands.get(name);

        if (command == null) {
            System.out.println("Neznámý příkaz");
            return;
        }

        String result = command.execute(arg);
        System.out.println(result);
    }
}
