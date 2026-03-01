package com.nocZaHranici.game.command;

/**
 * Rozhraní všech příkazů
 * @author Jan Karel Vesely
 */
public interface Command {
    String getName();
    String execute(String argument);
}
