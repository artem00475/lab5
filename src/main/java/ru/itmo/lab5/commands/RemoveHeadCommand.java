package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;

public class RemoveHeadCommand implements Command{
    private CollectionManager collectionManager;

    public RemoveHeadCommand(CollectionManager collectionManager){
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean hasArgement() {
        return false;
    }

    @Override
    public String getName() {
        return "remove_head";
    }

    @Override
    public String getDescription() {
        return "вывести первый элемент коллекции и удалить его";
    }

    @Override
    public void execute(Boolean argument) {
        System.out.println(collectionManager.removeFirstElement().toString());
    }
}
