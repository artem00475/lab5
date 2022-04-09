package ru.itmo.lab5.console;

import ru.itmo.lab5.Main;
import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.commands.Command;
import ru.itmo.lab5.exceptions.FileException;
import ru.itmo.lab5.file.ScriptManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, реализующий работу команд
 */
public class CommandManager {
    private final CollectionManager collectionManager;
    private final Command[] commands;
    private String path;
    private boolean ifEmpty = false;
    private boolean ifConsole = true;
    private final Deque<String> stringDeque;
    private String scannedPath;
    private String com;
    private ScriptManager scriptManager;

    /**
     * Конструктор, задающий параметры объекта
     * @param collectionManager менеджер коллекций
     * @see CollectionManager
     * @param commands список всех команд
     * @param stringDeque очередь команд из скрипта
     * @param scriptManager менеджер коллекций
     * @see ScriptManager
     */
    public CommandManager(CollectionManager collectionManager, Command[] commands, Deque<String> stringDeque, ScriptManager scriptManager) {
        this.collectionManager = collectionManager;
        this.commands = commands;
        this.stringDeque=stringDeque;
        this.scriptManager = scriptManager;
    }

    /**
     * Инициализация основного файла коллекции
     */
    public void fileMode() {
        Scanner s;
        System.out.print("Введите переменную окружения, для заполнения коллекции из файла и сохранения коллекции (exit - выход из ввода):");
        try {
        while (true) {
                try {
                    scannedPath = Main.scanner.nextLine();
                    if (scannedPath.equals("exit")) {
                        ifEmpty = true;
                        break;
                    } else {
                        path = scannedPath;
                        if (path.equals("")) {
                            throw new FileException("Ничего не введено");
                        }
                        String[] checkPath;
                        try {
                            path = System.getenv(scannedPath);
                            checkPath = path.split(";");
                        } catch (NullPointerException e) {
                            throw new FileException("Переменная окружения не существует");
                        }
                        if (checkPath.length == 1) {
                            File file = new File(path);
                            if (file.isDirectory()) {
                                throw new FileException("Вы ввели директорию, нужно ввести файл");
                            }
                            if (path.length() >= 5 && path.startsWith("/dev/")) {
                                throw new FileException("Вы ввели псевдоустройство, нужно ввести файл");
                            }
                            if (!file.isFile()) {
                                throw new FileException("Введен не файл");
                            }
                            try {
                                s = new Scanner(file);
                            } catch (FileNotFoundException e) {
                                throw new FileException("Файл не существует");
                            }
                            collectionManager.parseFileToCollection(s, path);
                            break;
                        } else if (checkPath.length > 1) {
                            throw new FileException("Переменная окружения содержит больше одного пути");
                        }
                    }
                } catch (FileException exception) {
                    System.out.print("Введите переменную окружения снова: ");
                }
            }
            }catch (NoSuchElementException e) {
                ifEmpty = true;
                Main.scanner = new Scanner(System.in);
                System.out.println("\nВы вышли из ввода");
            }
        if (ifEmpty) {System.out.println("Переменная окружения не введена, сохранить коллекцию будет невозможно.");}
        consoleMode();
    }

    /**
     * Работа с командами введенными из консоли
     */
    public void consoleMode() {
            ifConsole = true;
            while (true) {
                boolean found = false;
                System.out.print("Введите команду (help - список команд): ");
                try {
                    com = Main.scanner.nextLine();
                }catch (NoSuchElementException e) {
                    System.out.println("\nВы вышли из программы");
                    break;
                }
                if (com.equals("exit")) {
                    break;
                } else {
                    try {
                        for (Command command : commands) {
                            if (com.equals(command.getName())) {
                                found = true;
                                if (com.equals("execute_script")) {
                                    scriptManager.createScriptFlesArray();
                                    command.execute(ifConsole);
                                    scriptMode();
                                    ifConsole=true;
                                } else if (!command.hasArgement()) {
                                    command.execute(ifEmpty);
                                } else {
                                    command.execute(ifConsole);
                                }
                            }
                        }
                    } catch (NoSuchElementException e) {
                        Main.scanner = new Scanner(System.in);
                        System.out.println("Вы вышли из ввода команды команды");
                    }
                if (!found) {
                    System.out.println("Команда введениа неверно, или такой команды не существует");
                }
                }
            }
    }

    /**
     * Работа с командами из скрипта
     */
    public void scriptMode() {
        ifConsole = false;
        if (!stringDeque.isEmpty()) {
            while (true) {
                String com = stringDeque.removeFirst();
                if (com.equals("stop")) {
                    System.out.println("Скрипт выполнен");
                    break;
                } else {
                    for (Command command : commands) {
                        if (com.equals(command.getName())) {
                            if (com.equals("execute_script")) {
                                command.execute(ifConsole);
                            } else if (!command.hasArgement()) {
                                command.execute(ifEmpty);
                            } else {
                                command.execute(ifConsole);
                            }
                        }
                    }
                }
            }
        }
    }
}
