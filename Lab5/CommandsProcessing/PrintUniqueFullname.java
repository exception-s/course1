package CommandsProcessing;

import AppProcessing.Organization;
import AppProcessing.TheCollection;
import ExceptionsProcessing.EmptyCollectionException;

import java.util.HashSet;

/**
 * Класс, реализующий команду print_unique_full_name
 */
public class PrintUniqueFullname implements Commandable {
    private final TheCollection collection;
    public PrintUniqueFullname(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) throws EmptyCollectionException {
        if (collection.getSize() == 0) {
            throw new EmptyCollectionException();
        }
        HashSet<String> names = new HashSet<>();
        for (Organization org : collection.getCollection()) {
            names.add(org.getFullName());
        }
        System.out.println(names);
    }
    @Override
    public String getName() {
        return "print_unique_full_name";
    }


    @Override
    public String getInfo() {
        return "вывести уникальные значения поля fullName всех элементов в коллекции";
    }
}
