package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.console.ConsoleManager;
import ru.itmo.lab5.file.ScriptManager;

public class RemoveByIdCommand implements Command {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private ScriptManager scriptManager;

    public RemoveByIdCommand(CollectionManager collectionManager, ConsoleManager consoleManager, ScriptManager scriptManager){
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
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его id";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument) {
                int id = consoleManager.getID();
                collectionManager.removeElementByID(id);
                System.out.println("Элемент успешно удалён.");
        }else {
            try {
                int id = scriptManager.getID();
                collectionManager.removeElementByID(id);
                System.out.println("Элемент успешно удалён.");
            }catch (Exception e) {System.out.println("Команда не выполнена");}
        }
    }
}
