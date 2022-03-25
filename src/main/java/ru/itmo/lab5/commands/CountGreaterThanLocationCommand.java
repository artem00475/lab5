package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.console.ConsoleManager;
import ru.itmo.lab5.exceptions.CommandException;
import ru.itmo.lab5.exceptions.ScriptException;
import ru.itmo.lab5.file.ScriptManager;

public class CountGreaterThanLocationCommand implements Command {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private ScriptManager scriptManager;

    public CountGreaterThanLocationCommand(ConsoleManager consoleManager, CollectionManager collectionManager, ScriptManager scriptManager) {
        this.collectionManager = collectionManager;
        this.consoleManager = consoleManager;
        this.scriptManager=scriptManager;
    }

    @Override
    public boolean hasArgement() {
        return true;
    }

    @Override
    public String getName() {
        return "count_greater_than_location location";
    }

    @Override
    public String getDescription() {
        return "вывести количество элементов, значение поля location которых больше заданного";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument) {
                System.out.println(collectionManager.countGreaterLocation(consoleManager.getLocationFromConsole()));
        }else {
            try {
                System.out.println(collectionManager.countGreaterLocation(scriptManager.getLocationFromScript()));
            }catch (Exception e) {new ScriptException("Команда не выполнена");}
        }
    }
}
