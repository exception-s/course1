package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.Status;
import Server.TheCollection;
import CollectionObjects.Exceptions.IncorrectArgumentsException;

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
            return new Response(Status.REQUEST_ERROR, "Элемента с таким id нет в коллекции.");
        }
        else {
            return new Response(Status.OK, "Элемент с id " + id + " успешно удалён из коллекции.");
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
