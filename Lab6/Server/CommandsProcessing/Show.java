package Server.CommandsProcessing;

import CollectionObject.Objects.Organization;
import CollectionObject.Objects.OrganizationType;
import CollectionObject.Response;
import CollectionObject.Status;
import Server.TheCollection;
import Server.CommandsProcessing.Commandable;
import CollectionObject.Exceptions.EmptyCollectionException;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;


/**
 * Класс, реализующий команду show
 */
public class Show implements Commandable, Serializable {
    private final TheCollection collection;
    public Show(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) throws EmptyCollectionException {
        if (collection.getSize() == 0) {
            return new Response(Status.REQUEST_ERROR, "В коллекции нет элементов.", collection);
        }
        else {
            LinkedHashSet<Organization> coll = collection.getCollection();
            return new Response(Status.OK, String.valueOf(coll.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new))));
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
