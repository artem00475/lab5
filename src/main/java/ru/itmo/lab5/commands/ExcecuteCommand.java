package ru.itmo.lab5.commands;

import ru.itmo.lab5.file.ScriptManager;

import java.io.File;
import java.util.Deque;
import java.util.Scanner;

/**
 * Команда, выполняющая скрипт
 */
public class ExcecuteCommand implements Command {
    private final Scanner scanner;
    private final ScriptManager scriptManager;
    private final Deque<String> deque;

    /**
     * Конструктор, задающий параметры объекта
     * @param scanner консоль
     * @param scriptManager менеджер скрипта
     * @see ScriptManager
     * @param deque очередь команд из скрипта
     */
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
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }

    @Override
    public void execute(Boolean argument) {
        if (argument){
            System.out.print("Введите полное имя файла: ");
            try {
                String path = scanner.nextLine();
                File file = new File(path);
                scriptManager.addFile(file);
            }catch (Exception e) {
                System.out.printf("Команда %s не выполнена\n", getName());
            }
        }else {
            try {
                String path = scanner.nextLine();
                File file = new File(path);
                scriptManager.addFile(file);
            }catch (Exception e) {
                System.out.printf("Команда %s не выполнена\n", getName());
            }
        }

    }
}
