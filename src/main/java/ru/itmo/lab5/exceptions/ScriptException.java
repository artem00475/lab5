package ru.itmo.lab5.exceptions;

/**
 * Исключение выбрасывается, если при работе со скриптом ошибка
 */
public class ScriptException extends  RuntimeException{
    /**
     * Конструктор создаещий исключение с описанием
     * @param string описание
     */
    public ScriptException(String string){
        super(string);
        System.out.println(string);
    }
}
