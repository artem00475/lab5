package ru.itmo.lab5.file;

import ru.itmo.lab5.exceptions.*;
import ru.itmo.lab5.person.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Класс, работающий со скриптом из файла
 */
public class ScriptManager {
    private File file;
    private Deque<String> stringDeque;

    /**
     * Конструтор, задающий параметры объекта
     * @param stringDeque очередь для команд из скриптов
     */
    public ScriptManager(Deque<String> stringDeque){
        this.stringDeque=stringDeque;
    }

    /**
     * Считывает скрипт, добавляет команды в очередь команд
     * @param file файл
     */
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
            throw new ScriptException("Файл не найден");
        }
    }

    /**
     * Создает объект класса Person из скрипта, возвращет объект
     * @return объект класса {@link Person}
     */
    public Person getPersonFromScript(){
        String scanned;
        String name;
        int coordinatesX;
        int coordinatesY;
        double height;
        ColorE eyeColor;
        ColorH hairColor;
        Country nationality;
        int locationX;
        double locationY;
        long locationZ;
        String locationName;
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new NameException("У элемента отсутсвует поле name");
            }
            name = scanned;
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new CoordinatesException("У элемента отсутствует поле coordinatesX");
            }
            try {
                coordinatesX = Integer.parseInt(scanned);
            } catch (NumberFormatException e) {
                throw new CoordinatesException("В поле coordinatesX нечисловое значение");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new CoordinatesException("У элемента отсутствует поле coordinatesY");
            }
            try {
                coordinatesY = Integer.parseInt(scanned);
            } catch (NumberFormatException e) {
                throw new CoordinatesException("В поле coordinatesY нечисловое значение");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new CoordinatesException("У элемента отсутствует поле height");
            }
            try {
                height = Double.parseDouble(scanned);
            } catch (NumberFormatException e) {
                throw new CoordinatesException("В поле height нечисловое значение");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new EyeColorException("У элемента отсутствует поле eyeColor");
            }
            try {
                eyeColor = ColorE.valueOf(scanned.toUpperCase(Locale.ROOT));
            } catch (IllegalArgumentException e) {
                throw new EyeColorException("Некорректное значение поля eyeColor");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new EyeColorException("У элемента отсутствует поле hairColor");
            }
            try {
                hairColor = ColorH.valueOf(scanned.toUpperCase(Locale.ROOT));
            } catch (IllegalArgumentException e) {
                throw new EyeColorException("Некорректное значение поля hairColor");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new EyeColorException("У элемента отсутствует поле eyeColor");
            }
            try {
                nationality = Country.valueOf(scanned.toUpperCase(Locale.ROOT));
            } catch (IllegalArgumentException e) {
                throw new EyeColorException("Некорректное значение поля nationality");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new CoordinatesException("У элемента отсутствует поле locationX");
            }
            try {
                locationX = Integer.parseInt(scanned);
            } catch (NumberFormatException e) {
                throw new CoordinatesException("В поле locationX нечисловое значение");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new CoordinatesException("У элемента отсутствует поле locationY");
            }
            try {
                locationY=Double.parseDouble(scanned);
            } catch (NumberFormatException e) {
                throw new CoordinatesException("В поле locationY нечисловое значение");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new CoordinatesException("У элемента отсутствует поле locationZ");
            }
            try {
                locationZ = Long.parseLong(scanned);
            } catch (NumberFormatException e) {
                throw new CoordinatesException("В поле locationZ нечисловое значение");
            }
            scanned = stringDeque.remove();
            if (scanned.equals("")) {
                throw new NameException("У элемента отсутсвует поле locationName");
            }
            locationName = scanned;
        Person person = new Person(name, coordinatesX, coordinatesY, height, eyeColor, hairColor, nationality, locationX, locationY, locationZ, locationName);
        return person;
    }

    /**
     * Создает объект класса Location из скрипта, возвращает объект
     * @return объект класса {@link Location}
     */
    public Location getLocationFromScript(){
        int locationX;
        double locationY;
        long locationZ;
        String locationName;
        String scanned = stringDeque.remove();
        if (scanned.equals("")) {
            throw new CoordinatesException("У элемента отсутствует поле locationX");
        }
        try {
            locationX = Integer.parseInt(scanned);
        } catch (NumberFormatException e) {
            throw new CoordinatesException("В поле locationX нечисловое значение");
        }
        scanned = stringDeque.remove();
        if (scanned.equals("")) {
            throw new CoordinatesException("У элемента отсутствует поле locationY");
        }
        try {
            locationY=Double.parseDouble(scanned);
        } catch (NumberFormatException e) {
            throw new CoordinatesException("В поле locationY нечисловое значение");
        }
        scanned = stringDeque.remove();
        if (scanned.equals("")) {
            throw new CoordinatesException("У элемента отсутствует поле locationZ");
        }
        try {
            locationZ = Long.parseLong(scanned);
        } catch (NumberFormatException e) {
            throw new CoordinatesException("В поле locationZ нечисловое значение");
        }
        scanned = stringDeque.remove();
        if (scanned.equals("")) {
            throw new NameException("У элемента отсутсвует поле locationName");
        }
        locationName = scanned;
        Location location = new Location(locationX,locationY,locationZ,locationName);
        return location;
    }

    /**
     * Возвращает значение цвета глаз из скрипта
     * @return значение {@link ColorE}
     */
    public ColorE getEyeColor(){
        ColorE eyeColor;
        String scanned = stringDeque.remove();
        if (scanned.equals("")) {
            throw new EyeColorException("У элемента отсутствует поле eyeColor");
        }
        try {
            eyeColor = ColorE.valueOf(scanned.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new EyeColorException("Некорректное значение поля eyeColor");
        }
        return eyeColor;
    }

    /**
     * Возвращает значение id из скрипта
     * @return id
     */
    public int getID(){
        int id;
        String scanned = stringDeque.remove();
        if (scanned.isEmpty()) {
            throw new IdException("Ничего не введено");
        }
        try {
            id = Integer.parseInt(scanned);
        } catch (NumberFormatException e) {
            throw new IdException("Введено нечисловое значение");
        }
        if (!Person.getIdArray().contains(id)){
            throw new IdException("Элемента с таким id нет в коллекции");
        }
        return id;
    }
}
