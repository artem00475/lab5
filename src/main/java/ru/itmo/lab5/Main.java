package ru.itmo.lab5;

import org.json.simple.parser.ParseException;
import ru.itmo.lab5.collection.CollectionManager;
import ru.itmo.lab5.commands.*;
import ru.itmo.lab5.console.CommandManager;
import ru.itmo.lab5.console.ConsoleManager;
import ru.itmo.lab5.file.ScriptManager;

import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static void main( String[] args ) throws FileNotFoundException, ParseException, java.text.ParseException {
        Scanner scanner = new Scanner(System.in);
        Deque<String> scriptQueue = new LinkedList<>();
        CollectionManager collectionManager = new CollectionManager();
        ConsoleManager consoleManager = new ConsoleManager(scanner,collectionManager);
        ScriptManager scriptManager = new ScriptManager(scriptQueue);

        Command[] commands = {
                new AddCommand(consoleManager,collectionManager,scriptManager),
                new InfoCommand(collectionManager),
                new ShowCommand(collectionManager),
                new HelpCommand(),
                new UpdateCommand(consoleManager,collectionManager,scriptManager),
                new RemoveByIdCommand(collectionManager,consoleManager,scriptManager),
                new ClearCommand(collectionManager),
                new SaveCommand(collectionManager),
                new RemoveHeadCommand(collectionManager),
                new AddIfMaxCommand(consoleManager,collectionManager,scriptManager),
                new RemoveGreaterCommand(collectionManager,consoleManager,scriptManager),
                new CountGreaterThanLocationCommand(consoleManager,collectionManager,scriptManager),
                new PrintFieldAscendingLocationCommand(collectionManager),
                new FilterLessThanEyeColorCommand(consoleManager,collectionManager,scriptManager),
                new ExcecuteCommand(scanner,scriptManager,scriptQueue)
        };
        CommandManager commandManager = new CommandManager(collectionManager, scanner, commands,scriptQueue);
        commandManager.fileMode();
    }
}

