package ru.itmo.lab5.console;

import org.json.simple.parser.ParseException;
import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.commands.Command;

import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.Scanner;

public class CommandManager {
    private CollectionManager collectionManager;
    private Scanner scanner;
    private Command[] commands;
    private String path;
    private boolean ifEmpty = false;
    private boolean ifConsole = true;
    private Deque<String> stringDeque;

    public CommandManager(CollectionManager collectionManager, Scanner scanner, Command[] commands, Deque<String> stringDeque) {
        this.collectionManager = collectionManager;
        this.scanner = scanner;
        this.commands = commands;
        this.stringDeque=stringDeque;
    }

    public void fileMode() throws FileNotFoundException, ParseException, java.text.ParseException {
        System.out.print("Введите переменную окружения, откуда читать и куда сохранять коллекцию(exit - выход из ввода):");
        String scannedPath = scanner.nextLine();
        if (scannedPath.equals("exit")){
            ifEmpty=true;
            System.out.println("Переменная окружения не введена, сохранить коллекцию будет невозможно.");
        } else {
            path=scannedPath;
            //path=System.getenv(scannedPath);
            collectionManager.pasreFileToCollection(path);
        }

        consoleMode();
    }

    public void consoleMode(){
        ifConsole=true;
        while(true){
            System.out.print("Введите команду: ");
            String com = scanner.nextLine();
            if (com.equals("exit")){break;}
            else {
                for (Command command : commands){
                    if (com.equals(command.getName())){
                        if (com.equals("execute_script file_name")){
                            command.execute(ifConsole);
                            scriptMode();
                        }
                        else if (!command.hasArgement()){
                            command.execute(ifEmpty);
                        }else {
                            command.execute(ifConsole);
                        }
                    }
                }
            }

        }
    }

    public void scriptMode() {
        boolean noExit = true;
        ifConsole = false;
        if (!stringDeque.isEmpty()) {
            while (true) {
                String com = stringDeque.removeFirst();
                if (com.equals("stop")) {
                    System.out.println("Скрипт выполнен.");
                    break;
                } else if (com.equals("exit")) {
                    noExit=false;
                    break;
                } else {
                    for (Command command : commands) {
                        if (com.equals(command.getName())) {
                            if (com.equals("execute_script file_name")) {
                                command.execute(ifConsole);
                                scriptMode();
                            } else if (!command.hasArgement()) {
                                command.execute(ifEmpty);
                            } else {
                                command.execute(ifConsole);
                            }
                        }
                    }
                }
            }
        }else {if (noExit) {consoleMode();}}
    }
}
