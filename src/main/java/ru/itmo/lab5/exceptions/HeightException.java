package ru.itmo.lab5.exceptions;

/**
 * Исключение выбрасывается, если при вводе роста ошибка
 */
public class HeightException extends RuntimeException{
    /**
     *Конструктор создаещий исключение с описанием
     * @param string описание
     */
    public HeightException(String string){
        super(string);
        System.out.println(string);
    }
}
