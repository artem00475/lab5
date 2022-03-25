package ru.itmo.lab5.exceptions;

public class FileException extends RuntimeException{
    public FileException(String string){
        super(string);
        System.out.println(string);
    }
}
