package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.console.ConsoleManager;
import ru.itmo.lab5.file.ScriptManager;
import ru.itmo.lab5.person.Person;

public class AddIfMaxCommand implements Command{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private ScriptManager scriptManager;

    public AddIfMaxCommand(ConsoleManager consoleManager, CollectionManager collectionManager, ScriptManager scriptManager){
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
        return "add_if_max";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument) {
                Person person = consoleManager.getPersonFromConsole();
                if (collectionManager.ifMore(person)) {
                    collectionManager.addElement(person);
                    System.out.println("Элемент успешно добавлен");
                } else {
                    System.out.println("Значение элемента не превышает наибольшего элемента коллекции");
                }
        }else {
            try {
                Person person = scriptManager.getPersonFromScript();
                if (collectionManager.ifMore(person)) {
                    collectionManager.addElement(person);
                    System.out.println("Элемент успешно добавлен");
                } else {
                    System.out.println("Значение элемента не превышает наибольшего элемента коллекции");
                }
            }catch (Exception e) {System.out.printf("Команда %s не выполнена\n", getName());}
        }

    }
}
