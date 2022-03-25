package ru.itmo.lab5.file;

import ru.itmo.lab5.person.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class ScriptManager {
    private File file;
    private Deque<String> stringDeque;

    public ScriptManager(Deque<String> stringDeque){
        this.stringDeque=stringDeque;
    }

    public void addFile(File file){
        this.file = file;
        try (Scanner f = new Scanner(file)) {
            if (stringDeque.isEmpty()) {
                while (f.hasNextLine()) {
                    stringDeque.add(f.nextLine());
                }
                stringDeque.add("stop");
            }else {
                Deque<String> deque = new LinkedList<>();
                while (f.hasNextLine()) {
                    deque.add(f.nextLine());
                }
                deque.add("stop");
                while (!deque.isEmpty()){
                    stringDeque.addFirst(deque.removeLast());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Person getPersonFromScript(){
        String name = stringDeque.remove();
        Integer coordinatesX = Integer.parseInt(stringDeque.remove());
        Integer coordinatesY = Integer.parseInt(stringDeque.remove());
        Double height = Double.parseDouble(stringDeque.remove());
        String eyeColorTest = stringDeque.remove();
        ColorE eyeColor = ColorE.valueOf(eyeColorTest.toUpperCase(Locale.ROOT));
        String hairColorTest = stringDeque.remove();
        ColorH hairColor = ColorH.valueOf(hairColorTest.toUpperCase(Locale.ROOT));
        String nationalityTest = stringDeque.remove();
        Country nationality = Country.valueOf(nationalityTest.toUpperCase(Locale.ROOT));
        Integer locationX = Integer.parseInt(stringDeque.remove());
        Double locationY = Double.parseDouble(stringDeque.remove());
        Long locationZ = Long.parseLong(stringDeque.remove());
        String locationName = stringDeque.remove();
        Person person = new Person(name, coordinatesX, coordinatesY, height, eyeColor, hairColor, nationality, locationX, locationY, locationZ, locationName);
        return person;
    }

    public Location getLocationFromScript(){
        Integer locationX = Integer.parseInt(stringDeque.remove());
        Double locationY = Double.parseDouble(stringDeque.remove());
        Long locationZ = Long.parseLong(stringDeque.remove());
        String locationName = stringDeque.remove();
        Location location = new Location(locationX,locationY,locationZ,locationName);
        return location;
    }

    public ColorE getEyeColor(){
        System.out.print("Введите значение eyeColor из списка: ");
        ColorE eyeColor = ColorE.valueOf(stringDeque.remove().toUpperCase(Locale.ROOT));
        return eyeColor;
    }

    public int getID(){
        System.out.print("Введите значение id: ");
        int id = Integer.parseInt(stringDeque.remove());
        return id;
    }
}
