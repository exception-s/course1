package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;
import lab5.ExceptionsProcessing.EmptyCollectionException;

import java.io.File;
import java.util.*;

/**
 * Класс, реализующий команду print_descending
 */
public class PrintDescending implements Commandable {
    private final TheCollection collection;
    public PrintDescending(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        if (collection.getSize() == 0) {
            throw new EmptyCollectionException();
        }
        Arrays.sort(collection.getCollection().toArray(), Collections.reverseOrder());
        System.out.println(Arrays.toString(collection.getCollection().toArray()));
    }
    @Override
    public String getName() {
        return "print_descending";
    }


    @Override
    public String getInfo() {
        return "вывести элементы коллекции в порядке убывания";
    }
}
