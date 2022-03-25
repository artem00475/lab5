package ru.itmo.lab5.exceptions;

public class CoordinatesException extends RuntimeException{
    public CoordinatesException(String string){
        super(string);
        System.out.println(string);
    }
}
