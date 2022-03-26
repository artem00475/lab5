package ru.itmo.lab5.exceptions;

/**
 * Исключение выбрасывается, если в полях класса {@link ru.itmo.lab5.person.Coordinates} ошибка
 */
public class CoordinatesException extends RuntimeException{
    /**
     * Конструктор создаещий исключение с описанием
     * @param string описание
     */
    public CoordinatesException(String string){
        super(string);
        System.out.println(string);
    }
}
