package ru.itmo.lab5.commands;


import ru.itmo.lab5.collection.CollectionManager;

public class InfoCommand implements Command{
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean hasArgement() {
        return false;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return " : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)";
    }

    @Override
    public void execute(Boolean argument) {
        System.out.println("Информация о коллекции:");
        System.out.println("Коллекция типа PriorityQueue, в которой хранятся объекты класса Person");
        System.out.println("Дата инициализации: "+collectionManager.getInitDate());
        System.out.println("Количестов элементов: "+collectionManager.getCollection().size());
    }
}
