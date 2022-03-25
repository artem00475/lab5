package ru.itmo.lab5.exceptions;

public class LocationException extends RuntimeException{
    public LocationException(String string){
        super(string);
        System.out.println(string);
    }
}
