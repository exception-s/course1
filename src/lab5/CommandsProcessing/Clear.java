package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;

import java.io.File;

/**
 * Класс, реализующий команду clear
 */
public class Clear implements Commandable {
    private final TheCollection collection;
    public Clear(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        collection.clear();
        System.out.println("Коллекция успешно очищена.");
    }
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getInfo() {
        return "очистить коллекцию";
    }
}
