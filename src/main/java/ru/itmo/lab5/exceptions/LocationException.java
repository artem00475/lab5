package ru.itmo.lab5.exceptions;

/**
 * Исключение выбрасывается, если в полях класса {@link ru.itmo.lab5.person.Location} ошибка
 */
public class LocationException extends RuntimeException{
    /**
     *Конструктор создаещий исключение с описанием
     *@param string описание
     */
    public LocationException(String string){
        super(string);
        System.out.println(string);
    }
}
