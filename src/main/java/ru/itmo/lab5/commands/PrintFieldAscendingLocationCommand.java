package ru.itmo.lab5.commands;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.person.Person;

public class PrintFieldAscendingLocationCommand implements Command{
    private CollectionManager collectionManager;

    public PrintFieldAscendingLocationCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean hasArgement() {
        return false;
    }

    @Override
    public String getName() {
        return "print_field_ascending_location";
    }

    @Override
    public String getDescription() {
        return "вывести значения поля location всех элементов в порядке возрастания";
    }

    @Override
    public void execute(Boolean argument) {
        for (Person person : collectionManager.sortByLocation()){
            System.out.println(person.getLocation());
        }

    }
}
