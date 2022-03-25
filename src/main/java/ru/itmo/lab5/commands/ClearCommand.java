package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;

public class ClearCommand implements Command {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean hasArgement() {
        return false;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }

    @Override
    public void execute(Boolean argument) {
        collectionManager.removeAll();
        System.out.println("Коллекция очищена");
    }
}
