package Server.CommandsProcessing;

import CollectionObject.Response;
import CollectionObject.Status;
import Server.TheCollection;
import Server.CommandsProcessing.Commandable;
import CollectionObject.Exceptions.IncorrectArgumentsException;

import java.io.Serializable;

/**
 * Класс, реализующий команду remove_by_id
 */
public class RemoveById implements Commandable, Serializable {
    private final TheCollection collection;
    public RemoveById(TheCollection collection){
        this.collection = collection;
    }
    public Response execute(String[] args) throws IncorrectArgumentsException {
        int id = Integer.parseInt(args[1]);
        if (!collection.removeByID(id)) {
            return new Response(Status.REQUEST_ERROR, "Элемента с таким id нет в коллекции.", collection);
        }
        else {
            return new Response(Status.OK, "Элемент с id " + id + " успешно удалён из коллекции.", collection);
        }
    }
    @Override
    public String getName() {
        return "remove_by_id id";
    }

    @Override
    public String getInfo() {
        return "удалить элемент из коллекции по его id";
    }
}
