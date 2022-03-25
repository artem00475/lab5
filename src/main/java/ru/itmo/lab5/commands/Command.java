package ru.itmo.lab5.commands;

public interface Command {
    String getName();
    String getDescription();
    boolean hasArgement();
    void execute(Boolean argument);
}
