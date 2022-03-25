package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;

public class SaveCommand implements Command{
    private CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager){
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean hasArgement() {
        return false;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    @Override
    public void execute(Boolean argument) {
        if (!argument) {
            collectionManager.saveCollection();
            System.out.println("Коллеекция сохранена");
        }else {
            System.out.println("Сохранение невозможно (нет файла)");
        }
    }
}
