package ru.itmo.lab5.exceptions;


public class CommandException extends RuntimeException{
    public CommandException(String string){
        super(string);
        System.out.println(string);
    }
}
