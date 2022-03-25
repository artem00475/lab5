package ru.itmo.lab5.exceptions;

public class IdException extends RuntimeException{
    public IdException(String string){
        super(string);
        System.out.println(string);
    }
}
