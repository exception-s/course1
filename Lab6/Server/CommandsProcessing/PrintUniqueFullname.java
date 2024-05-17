package Server.CommandsProcessing;

import CollectionObject.Objects.Organization;
import CollectionObject.Response;
import CollectionObject.Status;
import Server.TheCollection;
import Server.CommandsProcessing.Commandable;
import CollectionObject.Exceptions.EmptyCollectionException;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Класс, реализующий команду print_unique_full_name
 */
public class PrintUniqueFullname implements Commandable, Serializable {
    private final TheCollection collection;
    public PrintUniqueFullname(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) throws EmptyCollectionException {
        if (collection.getSize() == 0) {
            return new Response(Status.REQUEST_ERROR, "В коллекции нет элементов.", collection);
        }
        HashSet<String> names = new HashSet<>();
        for (Organization org : collection.getCollection()) {
            names.add(org.getFullName());
        }
        System.out.println(names);
        return new Response(Status.OK, names.toString(), collection);
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
