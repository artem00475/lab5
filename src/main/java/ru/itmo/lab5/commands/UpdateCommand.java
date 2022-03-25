package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.console.ConsoleManager;
import ru.itmo.lab5.file.ScriptManager;

public class UpdateCommand implements Command{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private ScriptManager scriptManager;

    public UpdateCommand(ConsoleManager consoleManager, CollectionManager collectionManager, ScriptManager scriptManager){
        this.consoleManager = consoleManager;
        this.collectionManager = collectionManager;
        this.scriptManager=scriptManager;
    }

    @Override
    public boolean hasArgement() {
        return true;
    }

    @Override
    public String getName() {
        return "update id {element}";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument) {
            int id = consoleManager.getID();
            collectionManager.updateElement(id, consoleManager.getPersonFromConsole());
            System.out.println("Объект успешно оновлен.");
        }else {
            int id = scriptManager.getID();
            collectionManager.updateElement(id, scriptManager.getPersonFromScript());
            System.out.println("Объект успешно оновлен.");
        }
    }
}
