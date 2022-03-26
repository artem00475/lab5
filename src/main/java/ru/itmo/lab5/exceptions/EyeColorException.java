package ru.itmo.lab5.exceptions;

/**
 * Исключение выбрасывается, если при вводе цвета глаз ошибка
 */
public class EyeColorException extends RuntimeException{
    /**
     *Конструктор создаещий исключение с описанием
     * @param string описание
     */
    public EyeColorException(String string){
        super(string);
        System.out.println(string);
    }
}
