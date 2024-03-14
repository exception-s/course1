package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;
import lab5.ExceptionsProcessing.EmptyCollectionException;

import java.io.File;

/**
 * Класс, реализующий команду show
 */
public class Show implements Commandable {
    private final TheCollection collection;
    public Show(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) throws EmptyCollectionException {
        if (collection.getSize() == 0) {
            throw new EmptyCollectionException();
        }
        else {
            System.out.println(collection);
        }
    }
    @Override
    public String getName() {
        return "show";
    }


    @Override
    public String getInfo() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
