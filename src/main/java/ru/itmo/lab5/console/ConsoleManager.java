package ru.itmo.lab5.console;

import ru.itmo.lab5.exceptions.*;
import ru.itmo.lab5.person.*;

import java.util.Locale;
import java.util.Scanner;

/**
 * Класс, реализующий ввод с консоли
 */
public class ConsoleManager {
    private final Scanner scanner;

    /**
     * Конструктор, задающий параметры объекта
     * @param scanner консоль
     */
    public ConsoleManager(Scanner scanner){
        this.scanner = scanner;
    }


    /**
     * ВОзвращает объект класса {@link Person} из консоли
     * @return объект класса {@link Person}
     */
    public Person getPersonFromConsole(){
            System.out.println("Введите данные элемента:");
        return new Person(getName(), getCoordinatesX(), getCoordinatesY(), getHeight(), getEyeColor(), getHairColor(), getNationality(), getLocationX(), getLocationY(), getLocationZ(), getLocationName());
    }


    /**
     * Возвращает имя из консоли
     * @return name
     */
    public String getName(){
        String name;
        while (true) {
            try {
                System.out.print("Введите поле name: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new NameException("У элемента отсутсвует поле name");
                }
                name = scanned;
                break;
            }catch (Exception ignored) {}
        }
        return name;
    }

    /**
     * Возвращает координату Х из консоли
     * @return coordinatesX
     */
    public Integer getCoordinatesX(){
        int coordinatesX;
        while (true) {
            try {
                System.out.print("Введите поле coordinatesX: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new CoordinatesException("У элемента отсутствует поле coordinatesX");
                }
                try {
                    coordinatesX = Integer.parseInt(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("В поле coordinatesX нечисловое значение");
                }
                if (coordinatesX>408) {throw new CoordinatesException("Значение не должно превышать 408");}
                break;
            }catch (Exception ignored) {}
        }
        return coordinatesX;
    }

    /**
     * Возвращает координату Y из консоли
     * @return coordinatesY
     */
    public Integer getCoordinatesY(){
        int coordinatesY;
        while (true) {
            try {
                System.out.print("Введите поле coordinatesY: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new CoordinatesException("У элемента отсутствует поле coordinatesY");
                }
                try {
                    coordinatesY = Integer.parseInt(scanned);
                } catch (NumberFormatException e) {
                    throw new CoordinatesException("В поле coordinatesY нечисловое значение");
                }
                if (!(coordinatesY>-806)) {throw new CoordinatesException("Значение должно быть больше -806");}
                break;
            }catch (Exception ignored) {}
        }
        return coordinatesY;
    }

    /**
     * Возвращает рост из консоли
     * @return height
     */
    public Double getHeight(){
        double height;
        while (true) {
            try {
                System.out.print("Введите поле height: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new HeightException("У элемента отсутствует поле height");
                }
                try {
                    height = Double.parseDouble(scanned);
                } catch (NumberFormatException e) {
                    throw new HeightException("В поле height нечисловое значение");
                }
                if (!(height >0)) {throw new HeightException("Значение должно быть больше 0");}
                break;
            }catch (Exception ignored) {}
        }
        return height;
    }

    /**
     * Возвращает цвет глаз из консоли
     * @return eyeColor {@link ColorE}
     */
    public ColorE getEyeColor(){
        ColorE eyeColor;
        while (true) {
            try {
                System.out.print("Введите поле eyeColor (из списка: green, red, yellow, brown): ");
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
            }catch (Exception ignored) {}
        }
        return eyeColor;
    }

    /**
     * Возвращает цвет волос из консоли
     * @return hairColor {@link ColorH}
     */
    public ColorH getHairColor(){
        ColorH hairColor;
        while (true) {
            try {
                System.out.print("Введите поле hairColor (из списка: red, black, orange, brown): ");
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
            }catch (Exception ignored) {}
        }
        return hairColor;
    }

    /**
     * Возвращает национальность из консоли
     * @return nationality {@link Country}
     */
    public Country getNationality(){
        Country nationality;
        while (true) {
            try {
                System.out.print("Введите поле nationality (из списка: usa, spain, india): ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new EyeColorException("У элемента отсутствует поле nationality");
                }
                try {
                    nationality = Country.valueOf(scanned.toUpperCase(Locale.ROOT));
                } catch (IllegalArgumentException e) {
                    throw new EyeColorException("Некорректное значение поля nationality");
                }
                break;
            }catch (Exception ignored) {}
        }
        return nationality;
    }

    /**
     * Возвращает координату Х местопложения из консоли
     * @return locationX
     */
    public Integer getLocationX(){
        int locationX;
        while (true) {
            try {
                System.out.print("Введите поле locationX: ");
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
            }catch (Exception ignored) {}
        }
        return locationX;
    }

    /**
     * Возвращает координату Y местопложения из консоли
     * @return locationY
     */
    public Double getLocationY(){
        double locationY;
        while (true) {
            try {
                System.out.print("Введите поле locationY: ");
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
            }catch (Exception ignored) {}
        }
        return locationY;
    }

    /**
     * Возвращает координату Z местопложения из консоли
     * @return locationZ
     */
    public Long getLocationZ(){
        long locationZ;
        while (true) {
            try {
                System.out.print("Введите поле locationZ: ");
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
            }catch (Exception ignored) {}
        }
        return locationZ;
    }

    /**
     * Возвращает название местопложения из консоли
     * @return locationName
     */
    public String getLocationName(){
        String locationName;
        while (true) {
            try {
                System.out.print("Введите поле locationName: ");
                String scanned = scanner.nextLine();
                if (scanned.equals("")) {
                    throw new NameException("У элемента отсутсвует поле locationName");
                }
                locationName = scanned;
                if (locationName.length()>374) {throw new LocationException("Длина поля locationName не должна превышать 374");}
                break;
            }catch (Exception ignored) {}
        }
        return locationName;
    }

    /**
     * Возвращает значение id из консоли
     * @return id
     */
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

    /**
     * Возвращает объект класса {@link Location} из консоли
     * @return объект класса {@link Location}
     */
    public Location getLocationFromConsole(){
        return new Location(getLocationX(),getLocationY(),getLocationZ(),getLocationName());
    }

}
