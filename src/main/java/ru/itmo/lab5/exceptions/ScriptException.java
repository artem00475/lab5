package ru.itmo.lab5.exceptions;

public class ScriptException extends  RuntimeException{
    public ScriptException(String string){
        super(string);
        System.out.println(string);
    }
}
