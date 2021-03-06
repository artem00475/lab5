package ru.itmo.lab5.collection;

import ru.itmo.lab5.file.FileManager;
import ru.itmo.lab5.person.*;


import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Класс, работающий с коллекцией
 */
public class CollectionManager {
    private final Queue<Person> collection;
    private final String initDate;
    private final FileManager fileManager;

    /**
     * Конструктор, задающий параметры объекта
     * Создается коллекция, сохраняется дата создания
     */
    public CollectionManager() {
        collection = new PriorityQueue(1, new PersonComporator());
        initDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"));
        this.fileManager= new FileManager();
    }

    /**
     * Возвращает коллекцию
     * @return коллекция
     */
    public Queue<Person> getCollection(){
        return collection;
    }

    /**
     * Возвращает дату создания коллекции
     * @return дата создания коллекции
     */
    public String getInitDate() {
        return initDate;
    }

    @Override
    public String toString() {
        StringBuilder personList = new StringBuilder();
        for (Person person : collection) {
            personList.append("\n").append(person);
        }
        return personList.toString();
    }

    /**
     * Заполнение коллекции из файла
     * @param scanner консоль
     * @param string путь к файле
     * @throws FileNotFoundException если файл, не найден
     */
    public void parseFileToCollection(Scanner scanner, String string) {
        fileManager.parseFile(collection,scanner,string);
    }

    /**
     * Добавляет объект класса {@link Person} в коллекцию
     * @param person объект класса {@link Person}
     */
    public void addElement(Person person){
        collection.add(person);
    }

    /**
     * Обновляет поля объекта класса {@link Person} по id
     * @param id id элемента
     * @param p объект класса {@link Person}
     */
    public void updateElement(int id, Person p){
        Queue<Person> collection1 = new PriorityQueue<>(1,new PersonComporator());
        while (!collection.isEmpty()){
            Person person = collection.remove();
            if (person.getID() == id){
                person.setName(p.getName());
                person.setCoordinates(p.getCoordinates());
                person.setEyeColor(p.getEyeColor());
                person.setHairColor(p.getHairColor());
                person.setNationality(p.getNationality());
                person.setLocation(p.getLocation());
                collection.add(person);
                collection.addAll(collection1);
                break;
            }else{
                collection1.add(person);
            }

        }
    }

    /**
     * Удаляет элемент из коллекции по id
     * @param id id элемента
     */
    public void removeElementByID(int id){
        for (Person person : collection){
            if (person.getID() == id){
                collection.remove(person);
                Person.removeFromIdArray(id);
            }
        }
    }

    /**
     * Удаляет все элементы из коллекции
     */
    public void removeAll(){
        Person.removeAllFromIdArray();
        collection.clear();

    }

    /**
     * Сохраняет коллекцию в файл
     */
    public void saveCollection() {
        fileManager.saveToFile(collection);
    }

    /**
     * Удаляет первый элемент из очереди
     * @return объект класса {@link Person}
     */
    public Person removeFirstElement(){
        Person person = collection.remove();
        Person.removeFromIdArray(person.getID());
        return person;
    }

    /**
     * Сравнивает значение height элементов коллекции со значением заданного объекта
     * @param person объект класса {@link Person}
     * @return {@code true} если больше, иначе {@code false}
     */
    public boolean ifMore(Person person){
        if (collection.isEmpty()){return true;}
        Double h = 0.0;
        for (Person p : collection){
            h=p.getHeight();
        }
        return person.getHeight() > h;

    }

    /**
     * Удаляет из коллекции все элементы превышающие заданный
     * @param person объект класса {@link Person}
     * @return {@code true} если нужные элементы есть, иначе {@code false}
     */
    public boolean removeGreater(Person person){
        boolean found = false;
        Double h = person.getHeight();
        Queue<Person> collection1 = new PriorityQueue<>(1, new PersonComporator());
        for (Person p : collection){
            if (h<p.getHeight()){
                Person.removeFromIdArray(p.getID());
                collection1.add(p);
                found=true;
            }
        } collection.removeAll(collection1);
        return found;
    }

    /**
     * Выводит количество, значение поле location которых больше заданного
     * @param location объект класса {@link Location}
     * @return количество элементов
     */
    public int countGreaterLocation(Location location){
        int count = 0;
        for (Person person : collection){
            if (person.getLocation().compare(location)){
                count++;
            }
        }
        return count;
    }

    /**
     * Сортирует коллекцию по местоположению
     * @return отсортированная коллекция
     */
    public Queue<Person> sortByLocation(){
        Queue<Person> collection1 = new PriorityQueue<>(1,new LocationComporator());
        collection1.addAll(collection);
        return collection1;
    }

    /**
     * Возвращает коллекцию с элементами значение поля eyeColor меньше заданного
     * @param eyeColor заданное значение {@link ColorE}
     * @return коллекция с элементами
     */
    public Queue<Person> filterLessThanEyeColor(ColorE eyeColor){
        Queue<Person> collection1 = new PriorityQueue<>(1,new PersonComporator());
        for (Person person : collection){
            if (person.getEyeColor().compareTo(eyeColor)<0){
                collection1.add(person);
            }
        }return collection1;
    }
}
