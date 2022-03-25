package ru.itmo.lab5.collection;

import org.json.simple.parser.ParseException;
import ru.itmo.lab5.file.FileManager;
import ru.itmo.lab5.person.*;


import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class CollectionManager {
    private Queue<Person> collection;
    private String initDate;
    private FileManager fileManager;

    public CollectionManager() throws FileNotFoundException, ParseException, java.text.ParseException {
        collection = new PriorityQueue(1, new PersonComporator());
        initDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"));
        FileManager fileManager = new FileManager();
        this.fileManager=fileManager;
    }
    public Queue<Person> getCollection(){
        return collection;
    }
    public String getInitDate() {
        return initDate;
    }

    @Override
    public String toString() {
        StringBuilder personList = new StringBuilder("");
        for (Person person : collection) {
            personList.append("\n").append(person);
        }
        return personList.toString();
    }

    public void pasreFileToCollection(Scanner scanner, String string) throws FileNotFoundException, ParseException, java.text.ParseException {
        fileManager.parseFile(collection,scanner,string);
    }
    public void addElement(Person person){
        collection.add(person);
    }

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

    public void removeElementByID(int id){
        Queue<Person> collection1 = new PriorityQueue<>(1,new PersonComporator());
        while (!collection.isEmpty()){
            Person person = collection.remove();
            if (person.getID() == id){
                for (Person per : collection1){
                    collection.add(per);
                }break;
            }else{
                collection1.add(person);
            }
        }
    }

    public void removeAll(){
        collection.removeAll(collection);
    }

    public void saveCollection() {
        fileManager.saveToFile(collection);
    }

    public Person removeFirstElement(){
        return collection.remove();
    }

    public boolean ifMore(Person person){
        if (collection.isEmpty()){return true;}
        Double h = 0.0;
        for (Person p : collection){
            h=p.getHeight();
        }
        if (person.getHeight()>h){
            return true;
        } else{
            return false;
        }

    }

    public boolean removeGreater(Person person){
        boolean found = false;
        Double h = person.getHeight();
        Queue<Person> collection1 = new PriorityQueue<>(1, new PersonComporator());
        for (Person p : collection){
            if (h<p.getHeight()){
                collection1.add(p);
                found=true;
            }
        } collection.removeAll(collection1);
        return found;
    }

    public int countGreaterLocation(Location location){
        int count = 0;
        for (Person person : collection){
            if (person.getLocation().compare(location)){
                count++;
            }
        }
        return count;
    }

    public Queue<Person> sortByLocation(){
        Queue<Person> collection1 = new PriorityQueue<>(1,new LocationComporator());
        collection1.addAll(collection);
        return collection1;
    }

    public Queue<Person> filterLessThanEyeColor(ColorE eyeColor){
        Queue<Person> collection1 = new PriorityQueue<>(1,new PersonComporator());
        for (Person person : collection){
            if (person.getEyeColor().compareTo(eyeColor)<0){
                collection1.add(person);
            }
        }return collection1;
    }

}
