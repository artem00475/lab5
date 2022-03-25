package ru.itmo.lab5.commands;

import ru.itmo.lab5.file.ScriptManager;

import java.io.File;
import java.util.Deque;
import java.util.Scanner;

public class ExcecuteCommand implements Command {
    private Scanner scanner;
    private ScriptManager scriptManager;
    private Deque<String> deque;

    public ExcecuteCommand(Scanner scanner, ScriptManager scriptManager, Deque<String> deque){
        this.scanner=scanner;
        this.scriptManager = scriptManager;
        this.deque=deque;
    }

    @Override
    public boolean hasArgement() {
        return true;
    }

    @Override
    public String getName() {
        return "execute_script file_name";
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument){
            System.out.print("Введите полное имя файла: ");
            String path = scanner.nextLine();
            File file = new File(path);
            scriptManager.addFile(file);
        }else {
            String path = deque.remove();
            File file = new File(path);
            scriptManager.addFile(file);
        }

    }
}
