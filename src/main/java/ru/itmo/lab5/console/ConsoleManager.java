package ru.itmo.lab5.console;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.exceptions.*;
import ru.itmo.lab5.person.*;

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
            Person person = new Person(getName(), getCoordinatesX(), getCoordinatesY(), getHeight(), getEyeColor(), getHairColor(), getNationality(), getLocationX(), getLocationY(), getLocationZ(), getLocationName());
            return person;
    }


    public String getName(){
        String name;
        while (true) {
            try {
                System.out.println("Введите имя: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new NameException("У элемента отсутсвует поле name");
                }
                name = scanned;
                break;
            }catch (Exception e) {}
        }
        return name;
    }

    public Integer getCoordinatesX(){
        Integer coordinatesX;
        while (true) {
            try {
                System.out.println("Введите координату Х: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new CoordinatesException("У элемента отсутствует координата Х");
                }
                try {
                    coordinatesX = Integer.parseInt(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("В поле координата Х нечисловое значение");
                }
                break;
            }catch (Exception e) {}
        }
        return coordinatesX;
    }

    public Integer getCoordinatesY(){
        Integer coordinatesY;
        while (true) {
            try {
                System.out.println("Введите координату Y: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new CoordinatesException("У элемента отсутствует координата Y");
                }
                try {
                    coordinatesY = Integer.parseInt(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("В поле координата Y нечисловое значение");
                }
                break;
            }catch (Exception e) {}
        }
        return coordinatesY;
    }
    public Double getHeight(){
        Double height;
        while (true) {
            try {
                System.out.println("Введите поле height: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new CoordinatesException("У элемента отсутствует поле height");
                }
                try {
                    height = Double.parseDouble(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("В поле координата Y нечисловое значение");
                }
                break;
            }catch (Exception e) {}
        }
        return height;
    }

    public ColorE getEyeColor(){
        ColorE eyeColor;
        while (true) {
            try {
                System.out.println("Введите цвет глаз: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new EyeColorException("У элемента отсутствует поле eyeColor");
                }
                try {
                    eyeColor = ColorE.valueOf(scanned.toUpperCase(Locale.ROOT));
                } catch (IllegalArgumentException e) {
                    throw new EyeColorException("Некорректное значение поля eyeColor");
                }
                break;
            }catch (Exception e) {}
        }
        return eyeColor;
    }

    public ColorH getHairColor(){
        ColorH hairColor;
        while (true) {
            try {
                System.out.println("Введите поле hairColor: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new EyeColorException("У элемента отсутствует поле hairColor");
                }
                try {
                    hairColor = ColorH.valueOf(scanned.toUpperCase(Locale.ROOT));
                } catch (IllegalArgumentException e) {
                    throw new EyeColorException("Некорректное значение поля hairColor");
                }
                break;
            }catch (Exception e) {}
        }
        return hairColor;
    }

    public Country getNationality(){
        Country nationality;
        while (true) {
            try {
                System.out.println("Введите поле nationality: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new EyeColorException("У элемента отсутствует поле eyeColor");
                }
                try {
                    nationality = Country.valueOf(scanned.toUpperCase(Locale.ROOT));
                } catch (IllegalArgumentException e) {
                    throw new EyeColorException("Некорректное значение поля nationality");
                }
                break;
            }catch (Exception e) {}
        }
        return nationality;
    }

    public Integer getLocationX(){
        Integer locationX;
        while (true) {
            try {
                System.out.println("Введите поле locationX: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new CoordinatesException("У элемента отсутствует поле locationX");
                }
                try {
                    locationX = Integer.parseInt(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("В поле locationX нечисловое значение");
                }
                break;
            }catch (Exception e) {}
        }
        return locationX;
    }

    public Double getLocationY(){
        Double locationY;
        while (true) {
            try {
                System.out.println("Введите поле locationY: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new CoordinatesException("У элемента отсутствует поле locationY");
                }
                try {
                    locationY=Double.parseDouble(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("В поле locationY нечисловое значение");
                }
                break;
            }catch (Exception e) {}
        }
        return locationY;
    }

    public Long getLocationZ(){
        Long locationZ;
        while (true) {
            try {
                System.out.println("Введите поле locationZ: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new CoordinatesException("У элемента отсутствует поле locationZ");
                }
                try {
                    locationZ = Long.parseLong(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("В поле locationZ нечисловое значение");
                }
                break;
            }catch (Exception e) {}
        }
        return locationZ;
    }

    public String getLocationName(){
        String locationName;
        while (true) {
            try {
                System.out.println("Введите поле locationName: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new NameException("У элемента отсутсвует поле locationName");
                }
                locationName = scanned;
                break;
            }catch (Exception e) {}
        }
        return locationName;
    }

    public int getID(){
        System.out.print("Введите значение id: ");
        int id;
        while (true) {
            try {
                String scanned = scanner.nextLine();
                if (scanned.isEmpty()) {
                    throw new IdException("Ничего не введено");
                }
                try {
                    id = Integer.parseInt(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("Введено нечисловое значение");
                }
                if (!Person.getIdArray().contains(id)){
                    throw new IdException("Элемента с таким id нет в коллекции");
                }
                break;
            }catch (Exception e) {
                System.out.println("Введите значение id снова: ");
            }
        }
        return id;
    }

    public Location getLocationFromConsole(){
        Location location = new Location(getLocationX(),getLocationY(),getLocationZ(),getLocationName());
        return location;
    }

}
