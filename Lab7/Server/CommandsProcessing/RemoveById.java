package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.Status;
import CollectionObjects.User;
import Server.DataBase;
import Server.TheCollection;
import CollectionObjects.Exceptions.IncorrectArgumentsException;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс, реализующий команду remove_by_id
 */
public class RemoveById implements Commandable, Serializable {
    private final TheCollection collection;
    private final ReentrantLock locker = new ReentrantLock();
    public RemoveById(TheCollection collection){
        this.collection = collection;
    }
    public Response execute(String[] args, User user) throws IncorrectArgumentsException {
        locker.lock();
        int id = Integer.parseInt(args[1]);
        if (!DataBase.removeById(id)) {

            locker.unlock();
            return new Response(Status.REQUEST_ERROR, "Элемента с таким id нет в коллекции или вы пытаетесь" +
                    "модифицировать чужой объект >:(");
        }
        else {
            collection.removeByID(id);
            locker.unlock();
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
