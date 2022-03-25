package ru.itmo.lab5.exceptions;

public class NameException extends RuntimeException{
    public NameException(String string){
        super(string);
        System.out.println(string);
    }
}
