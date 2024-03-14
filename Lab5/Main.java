import AppProcessing.TheCollection;
import CommandsProcessing.*;
import CommandsProcessing.*;
import ExceptionsProcessing.ExitRequested;
import ExceptionsProcessing.IncorrectArgumentsException;
import ExceptionsProcessing.NoFileAccessException;
import XMLProcessing.ReadFromXML;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("В качестве командной строки ничего не было передано или было передано некорректно.");
            System.exit(0);
        }
        if (!new File(args[0]).exists()) {
            System.out.println("В качестве командной строки ничего не было передано или было передано некорректно.");
            System.exit(0);
        }
        String fileName = args[0];

        // initialization
        TheCollection collection = new TheCollection();
        HistoryContainer history = new HistoryContainer();
        try {
            ReadFromXML reader = new ReadFromXML(fileName);
            collection = reader.parse();
        } catch (NoFileAccessException | IncorrectArgumentsException | NullPointerException e) {
            //e.printStackTrace();
            System.out.println("Данные во входном файле невалидны, попробуйте исправить файл.");
        }
        CommandHandler handler = new CommandHandler(collection, history, fileName);
        handler.addCommand("add", new Add(collection));
        handler.addCommand("add_if_min", new AddIfMin(collection));
        handler.addCommand("average_of_annual_turnover", new AverageAnnualTurnover(collection));
        handler.addCommand("clear", new Clear(collection));
        handler.addCommand("execute_script", new ExecuteScript(collection));
        handler.addCommand("exit", new Exit(collection));
        handler.addCommand("help", new Help(collection, handler.getCommands()));
        handler.addCommand("history", new History(collection, history));
        handler.addCommand("info", new Info(collection));
        handler.addCommand("print_descending", new PrintDescending(collection));
        handler.addCommand("print_unique_full_name", new PrintUniqueFullname(collection));
        handler.addCommand("remove_by_id", new RemoveById(collection));
        handler.addCommand("remove_greater", new RemoveGreater(collection));
        handler.addCommand("save", new Save(collection));
        handler.addCommand("show", new Show(collection));
        handler.addCommand("update", new Update(collection));
        collection.setCommandList(handler.getCommands());

        // todo suka class scriptReader, validation and remove isFile field, priberis v kode dolboeb nahui
        launchApp(handler);
    }
    public static void launchApp(CommandHandler handler) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в консольное приложение TheCollection! Чтобы увидеть список команд," +
                " введите help.");
        while (true) {
            System.out.print("$ ");
            try {
                String input = scanner.nextLine().trim();
                handler.processInput(input);
            } catch (ExitRequested | NoSuchElementException e) {
                System.out.println ("Завершение работы консольного приложения...");
                break;
            }
        }
    }
}
