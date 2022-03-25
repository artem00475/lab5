package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.console.ConsoleManager;
import ru.itmo.lab5.file.ScriptManager;
import ru.itmo.lab5.person.Person;

public class FilterLessThanEyeColorCommand implements Command {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private ScriptManager scriptManager;

    public FilterLessThanEyeColorCommand(ConsoleManager consoleManager, CollectionManager collectionManager, ScriptManager scriptManager) {
        this.consoleManager = consoleManager;
        this.collectionManager = collectionManager;
        this.scriptManager = scriptManager;
    }

    @Override
    public boolean hasArgement() {
        return true;
    }

    @Override
    public String getName() {
        return "filter_less_than_eye_color eyeColor";
    }

    @Override
    public String getDescription() {
        return "вывести элементы, значение поля eyeColor которых меньше заданного";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument) {
            for (Person person : collectionManager.filterLessThanEyeColor(consoleManager.getEyeColor())) {
                System.out.println(person.toString());
            }
        } else {
            for (Person person : collectionManager.filterLessThanEyeColor(scriptManager.getEyeColor())) {
                System.out.println(person.toString());
            }
        }
    }
}
