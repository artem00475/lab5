package ru.itmo.lab5.exceptions;

/**
 * Исключение выбрасывается, если при работе с файлом ошибка
 */
public class FileException extends RuntimeException{
    /**
     *Конструктор создаещий исключение с описанием
     * @param string описание
     */
    public FileException(String string){
        super(string);
        System.out.println(string);
    }
}
