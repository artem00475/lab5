package ru.itmo.lab5.exceptions;

public class HeightException extends RuntimeException{
    public HeightException(String string){
        super(string);
        System.out.println(string);
    }
}
