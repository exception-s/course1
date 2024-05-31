package Server.CommandsProcessing;

import CollectionObjects.Objects.Organization;
import CollectionObjects.Response;
import CollectionObjects.Status;
import CollectionObjects.User;
import Server.TheCollection;
import CollectionObjects.Exceptions.EmptyCollectionException;

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
    public Response execute(String[] input, User user) throws EmptyCollectionException {
        if (collection.getSize() == 0) {
            return new Response(Status.REQUEST_ERROR, "В коллекции нет элементов.");
        }
        HashSet<String> names = new HashSet<>();
        for (Organization org : collection.getCollection()) {
            names.add(org.getFullName());
        }
        System.out.println(names);
        return new Response(Status.OK, names.toString());
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
