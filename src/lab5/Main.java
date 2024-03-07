package lab5;

import lab5.AppProcessing.Coordinates;
import lab5.AppProcessing.Organization;
import lab5.AppProcessing.TheCollection;
import lab5.CommandsProcessing.*;
import lab5.ExceptionsProcessing.ExitRequested;
import lab5.XMLProcessing.ReadFromXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        // initialization
        TheCollection collection = new TheCollection();
        HistoryContainer history = new HistoryContainer();
        ReadFromXML reader = new ReadFromXML(fileName);
        collection = reader.parse();
        CommandHandler handler = new CommandHandler(collection, history);
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
