package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;
import lab5.ExceptionsProcessing.ExitRequested;

/**
 * Класс, реализующий команду exit
 */
public class Exit implements Commandable {
    private final TheCollection collection;
    public Exit(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) throws ExitRequested {
        throw new ExitRequested();
    }
    @Override
    public String getName() {
        return "exit";
    }
    @Override
    public String getInfo() {
        return "завершить программу (без сохранения в файл)";
    }
}
