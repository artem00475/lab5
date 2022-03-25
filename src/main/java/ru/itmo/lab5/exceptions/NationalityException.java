package ru.itmo.lab5.exceptions;

public class NationalityException extends RuntimeException{
    public NationalityException(String string){
        super(string);
        System.out.println(string);
    }
}
