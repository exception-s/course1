package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс, реализующий команду history
 */
public class History implements Commandable {
    private final TheCollection collection;
    private final HistoryContainer history;
    public History(TheCollection collection, HistoryContainer history) {
        this.collection = collection;
        this.history = history;
    }
    @Override
    public void execute(String[] input) {
        if (history.getHistory().isEmpty()) {
            System.out.println("Вы ещё не вводили никаких команд.");
            return;
        }
        ArrayList<Commandable> commandsList = history.getHistory();
        commandsList.remove(commandsList.size() - 1);
        for (Commandable command : commandsList) {
            System.out.println(command.getName());
        }
        history.add(new History(collection, history));
    }
    @Override
    public String getName() {
        return "history";
    }


    @Override
    public String getInfo() {
        return "вывести последние 6 команд (без их аргументов)";
    }
}
