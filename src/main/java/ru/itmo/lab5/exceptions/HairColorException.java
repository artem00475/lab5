package ru.itmo.lab5.exceptions;

public class HairColorException extends RuntimeException{
    public HairColorException(String string){
        super(string);
        System.out.println(string);
    }
}
