package ru.itmo.lab5.console;

import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.commands.Command;
import ru.itmo.lab5.exceptions.FileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.Scanner;

/**
 * Класс, реализующий работу команд
 */
public class CommandManager {
    private final CollectionManager collectionManager;
    private final Scanner scanner;
    private final Command[] commands;
    private String path;
    private boolean ifEmpty = false;
    private boolean ifConsole = true;
    private final Deque<String> stringDeque;

    /**
     * Конструктор, задающий параметры объекта
     * @param collectionManager менеджер коллекций
     * @see CollectionManager
     * @param scanner консоль
     * @param commands список всех команд
     * @param stringDeque очередь команд из скрипта
     */
    public CommandManager(CollectionManager collectionManager, Scanner scanner, Command[] commands, Deque<String> stringDeque) {
        this.collectionManager = collectionManager;
        this.scanner = scanner;
        this.commands = commands;
        this.stringDeque=stringDeque;
    }

    /**
     * Инициализация основного файла коллекции
     */
    public void fileMode() {
        Scanner s;
        System.out.print("Введите переменную окружения, для заполнения коллекции из файла и сохранения коллекции (exit - выход из ввода):");
        while (true) {
            try {
                String scannedPath = scanner.nextLine();
                if (scannedPath.equals("exit")) {
                    ifEmpty = true;
                    System.out.println("Переменная окружения не введена, сохранить коллекцию будет невозможно.");
                    break;
                } else {
                    path = scannedPath;
                    if (path.equals("")) {throw new FileException("Ничего не введено");}
                    String[] checkPath;
                    try {
                        path = System.getenv(scannedPath);
                         checkPath = path.split(";");
                    }catch (NullPointerException e) {throw new FileException("Переменная окружения не существует");}
                    if (checkPath.length == 1) {
                        File file = new File(path);
                        try {s = new Scanner(file);
                        }catch (FileNotFoundException e) {throw new FileException("Файл не существует");}
                        if (file.isDirectory()) {throw new FileException("Вы ввели директорию, нужно ввести файл");}
                        if (path.length()>=5 && path.substring(0,5).equals("/dev/")){throw new FileException("Вы ввели псевдоустройство, нужно ввести файл");}
                        if (!file.isFile()) {throw new FileException("Введен не файл");}
                        collectionManager.parseFileToCollection(s,path);
                        break;
                    }else if (checkPath.length > 1){
                        throw new FileException("Переменная окружения содержит больше одного пути");
                    }
                }
            }catch (FileException exception) {System.out.print("Введите переменную окружения снова: ");}
        }
        consoleMode();
    }

    /**
     * Работа с командами введенными из консоли
     */
    public void consoleMode(){
        ifConsole=true;
        boolean found = false;
        while(true){
            System.out.print("Введите команду (help - список команд): ");
            String com = scanner.nextLine();
            if (com.equals("exit")){break;}
            else {
                for (Command command : commands){
                    if (com.equals(command.getName())) {
                        found = true;
                        if (com.equals("execute_script")) {
                            command.execute(ifConsole);
                            scriptMode();
                        } else if (!command.hasArgement()) {
                            command.execute(ifEmpty);
                        } else {
                            command.execute(ifConsole);
                        }
                    }
                }if (!found) {System.out.println("Команда введениа неверно, или такой команды не существует");}
            }
        }
    }

    /**
     * Работа с командами из скрипта
     */
    public void scriptMode() {
        boolean noExit = true;
        ifConsole = false;
        if (!stringDeque.isEmpty()) {
            while (true) {
                String com = stringDeque.removeFirst();
                if (com.equals("stop")) {
                    System.out.println("Скрипт выполнен");
                    break;
                } else if (com.equals("exit")) {
                    noExit=false;
                    break;
                } else {
                    for (Command command : commands) {
                        if (com.equals(command.getName())) {
                            if (com.equals("execute_script")) {
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
            }if (noExit) {consoleMode();}
        }
    }
}
