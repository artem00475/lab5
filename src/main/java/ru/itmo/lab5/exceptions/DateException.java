package ru.itmo.lab5.exceptions;

public class DateException extends RuntimeException{
    public DateException(String string){
        super(string);
        System.out.println(string);
    }
}
