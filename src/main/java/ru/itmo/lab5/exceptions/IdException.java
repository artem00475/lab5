package ru.itmo.lab5.exceptions;

/**
 * Исключение выбрасывается, если при вводе id ошибка
 */
public class IdException extends RuntimeException{
    /**
     *Конструктор создаещий исключение с описанием
     * @param string описание
     */
    public IdException(String string){
        super(string);
        System.out.println(string);
    }
}
