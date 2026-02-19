package com.nocZaHranici.game.command;

public interface Command {
    String getName();
    String execute(String argument);
}
