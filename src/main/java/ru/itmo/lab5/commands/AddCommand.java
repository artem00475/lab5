package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.console.ConsoleManager;
import ru.itmo.lab5.file.ScriptManager;

public class AddCommand implements Command {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private ScriptManager scriptManager;

    public AddCommand( ConsoleManager consoleManager, CollectionManager collectionManager, ScriptManager scriptManager)  {
        this.consoleManager = consoleManager;
        this.collectionManager=collectionManager;
        this.scriptManager=scriptManager;
    }

    @Override
    public boolean hasArgement() {
        return true;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument) {
                collectionManager.addElement(consoleManager.getPersonFromConsole());
                System.out.println("Элемент успешно добавлен");
        }else{
            try {
                collectionManager.addElement(scriptManager.getPersonFromScript());
                System.out.println("Элемент успешно добавлен");
            }catch (Exception e) {System.out.println("Команда не выполнена");}
        }
    }
}
