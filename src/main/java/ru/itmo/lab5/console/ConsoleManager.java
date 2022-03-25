package ru.itmo.lab5.console;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.exceptions.*;
import ru.itmo.lab5.person.*;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleManager {
    private Scanner scanner;
    private CollectionManager collectionManager;

    public ConsoleManager(Scanner scanner, CollectionManager collectionManager){
        this.scanner = scanner;
        this.collectionManager = collectionManager;
    }


    public Person getPersonFromConsole(){
        System.out.println("Введите данные о человеке:");
        String scanned = scanner.nextLine();
        if (scanned.equals(null)) {
            throw new NameException("У элемента отсутсвует поле name");
        }
        String nameP = scanned;
        scanned= scanner.nextLine();
        Integer coordinatesX;
        if (scanned.equals(null)) {
            throw new CoordinatesException("У элемента отсутствует координата Х");
        }
        try {
            coordinatesX = Integer.parseInt(scanned);
        } catch (NumberFormatException e) {
            throw new CoordinatesException("В поле координата Х нечисловое значение");
        }
        scanned= scanner.nextLine();
        Integer coordinatesY;
        if (scanned.equals(null)) {
            throw new CoordinatesException("У элемента отсутствует координата Y");
        }
        try {
            coordinatesY = Integer.parseInt(scanned);
        } catch (NumberFormatException e) {
            throw new CoordinatesException("В поле координата Y нечисловое значение");
        }
        scanned= scanner.nextLine();
        Double height;
        if (scanned.equals(null)) {
            throw new HeightException("У элемента отсутствует поле height");
        }
        try {
            height = Double.parseDouble(scanned);
        } catch (NumberFormatException e) {
            throw new HeightException("В поле height нечисловое значение");
        }
        if (((String) personsJSONObject.get(tags[6])).equals(null)) {
            throw new EyeColorException("У элемента отсутствует поле eyeColor");
        }
        try {
            String eyeColorTest = (String) personsJSONObject.get(tags[6]);
            eyeColorP = ColorE.valueOf(eyeColorTest.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new EyeColorException("Некорректное значение поля eyeColor");
        }
        if (((String) personsJSONObject.get(tags[7])).equals(null)) {
            throw new HairColorException("У элемента отсутствует поле hairColor");
        }
        try {
            String hairColorTest = (String) personsJSONObject.get(tags[7]);
            hairColorP = ColorH.valueOf(hairColorTest.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new HairColorException("Некорректное значение поля hairColor");
        }
        if (((String) personsJSONObject.get(tags[8])).equals(null)) {
            throw new NationalityException("У элемента отсутствует поле nationality");
        }
        try {
            String nationalityTest = (String) personsJSONObject.get(tags[8]);
            nationalityP = Country.valueOf(nationalityTest.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new NationalityException("Некорректное значение поля nationality");
        }
        if (((String) personsJSONObject.get(tags[9])).equals(null)) {
            throw new LocationException("У элемента отсутствует поле locationX");
        }
        try {
            locationXP = Integer.parseInt((String) personsJSONObject.get(tags[9]));
        } catch (NumberFormatException e) {
            throw new LocationException("В поле locationX нечисловое значение");
        }
        if (((String) personsJSONObject.get(tags[10])).equals(null)) {
            throw new LocationException("У элемента отсутствует поле locationY");
        }
        try {
            locationYP = Double.parseDouble((String) personsJSONObject.get(tags[10]));
        } catch (NumberFormatException e) {
            throw new LocationException("В поле locationY нечисловое значение");
        }
        if (((String) personsJSONObject.get(tags[11])).equals(null)) {
            throw new LocationException("У элемента отсутствует поле locationZ");
        }
        try {
            locationZP = Long.parseLong((String) personsJSONObject.get(tags[11]));
        } catch (NumberFormatException e) {
            throw new LocationException("В поле locationZ нечисловое значение");
        }
        if (((String) personsJSONObject.get(tags[12])).equals(null)) {
            throw new LocationException("У элемента отсутствует поле locationName");
        }
        String locationNameP = (String) personsJSONObject.get(tags[12]);
        Person person = new Person(name, coordinatesX, coordinatesY, height, eyeColor, hairColor, nationality, locationX, locationY, locationZ, locationName);
        return person;
    }

    public Location getLocationFromConsole(){
        System.out.println("Введите данные о местоположении:");
        System.out.println("Введите местоположение Х: ");
        Integer locationX = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите местоположение Y: ");
        Double locationY = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите местоположение Z: ");
        Long locationZ = Long.parseLong(scanner.nextLine());
        System.out.println("Введите название местоположения: ");
        String locationName = scanner.nextLine();
        Location location = new Location(locationX,locationY,locationZ,locationName);
        return location;
    }

    public ColorE getEyeColor(){
        System.out.print("Введите значение eyeColor из списка: ");
        ColorE eyeColor = ColorE.valueOf(scanner.nextLine().toUpperCase(Locale.ROOT));
        return eyeColor;
    }

    public int getID(){
        System.out.print("Введите значение id: ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

}
