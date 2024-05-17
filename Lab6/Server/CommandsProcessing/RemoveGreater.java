package Server.CommandsProcessing;

import CollectionObject.Exceptions.IncorrectArgumentsException;
import CollectionObject.Objects.Organization;
import CollectionObject.Response;
import CollectionObject.ScriptReader;
import CollectionObject.Status;
import Server.TheCollection;
import Server.CommandsProcessing.Commandable;
import CollectionObject.Exceptions.EmptyCollectionException;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Класс, реализующий команду remove_greater
 */
public class RemoveGreater implements Commandable, Serializable {
    private final TheCollection collection;
    public RemoveGreater(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) {
        if (collection.getSize() == 0) {
            throw new EmptyCollectionException();
        }
        Organization org;
        ScriptReader reader = new ScriptReader();
        input = Arrays.copyOfRange(input, 1, input.length);
        try {
            org = reader.scriptReading(input);
        } catch (IncorrectArgumentsException e) {
            return new Response(Status.REQUEST_ERROR, "Данные объекта невалидны", collection);
        }
        collection.getCollection().removeIf(organization -> org.compareTo(organization) > 0);
//        for (Organization organization : collection.getCollection()) {
//            if (organization.compareTo(org) > 0) {
//                collection.removeByID(organization.getId());
//            }
//        }
        return new Response(Status.OK, "Операция успешно выполнена.", collection);
    }
    @Override
    public String getName() {
        return "remove_greater {element}";
    }
    @Override
    public String getInfo() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }
}
