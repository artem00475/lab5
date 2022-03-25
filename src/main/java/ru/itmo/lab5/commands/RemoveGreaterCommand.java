package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.console.ConsoleManager;
import ru.itmo.lab5.exceptions.CommandException;
import ru.itmo.lab5.exceptions.ScriptException;
import ru.itmo.lab5.file.ScriptManager;

public class RemoveGreaterCommand implements Command{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private ScriptManager scriptManager;

    public RemoveGreaterCommand(CollectionManager collectionManager, ConsoleManager consoleManager,ScriptManager scriptManager){
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
        return "remove_greater {element}";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument) {
                if (collectionManager.removeGreater(consoleManager.getPersonFromConsole())) {
                    System.out.println("Объекты успешно удалены");
                } else {
                    System.out.println("В коллекции нет объектов, удовлетворяющих условию");
                }
        }else {
            if (collectionManager.removeGreater(scriptManager.getPersonFromScript())) {
                System.out.println("Объекты успешно удалены");
            } else {
                try {
                    System.out.println("В коллекции нет объектов, удовлетворяющих условию");
                } catch (Exception e) {new ScriptException("Команда не выполнена");}
            }
        }


    }
}
