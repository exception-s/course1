package Server.CommandsProcessing;

import CollectionObject.Objects.Organization;
import CollectionObject.Request;
import CollectionObject.Response;
import CollectionObject.Status;
import Server.TheCollection;
import Server.CommandsProcessing.Commandable;
import CollectionObject.Exceptions.EmptyCollectionException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 * Класс, реализующий команду print_descending
 */
public class PrintDescending implements Commandable, Serializable {
    private final TheCollection collection;
    public PrintDescending(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) throws EmptyCollectionException {
        if (collection.getSize() == 0) {
            return new Response(Status.REQUEST_ERROR, "В коллекции нет элементов", collection);
        }
        LinkedHashSet<Organization> coll = collection.getCollection();
        //Arrays.sort(collection.getCollection().toArray(), Collections.reverseOrder());
        return new Response(Status.OK, coll.stream().sorted(Comparator.reverseOrder()).toString(), collection);
        // return new Response(Status.OK, Arrays.toString(collection.getCollection().toArray()), collection);
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