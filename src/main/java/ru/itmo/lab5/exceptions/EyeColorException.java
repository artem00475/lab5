package ru.itmo.lab5.exceptions;

public class EyeColorException extends RuntimeException{
    public EyeColorException(String string){
        super(string);
        System.out.println(string);
    }
}
