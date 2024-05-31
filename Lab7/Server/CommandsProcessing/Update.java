package Server.CommandsProcessing;

import CollectionObjects.Exceptions.IncorrectArgumentsException;
import CollectionObjects.Objects.Organization;
import CollectionObjects.Response;
import CollectionObjects.ScriptReader;
import CollectionObjects.Status;
import CollectionObjects.User;
import Server.DataBase;
import Server.TheCollection;


import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс, реализующий команду update
 */
public class Update implements Commandable, Serializable {
    private final TheCollection collection;
    private final ReentrantLock locker = new ReentrantLock();
    public Update(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input, User user) {
        locker.lock();
        int id = Integer.parseInt(input[1]);
        Organization org;
        ScriptReader reader = new ScriptReader();
        input = Arrays.copyOfRange(input, 2, input.length);
        try {
            org = reader.scriptReading(input);
        } catch (IncorrectArgumentsException e) {
            locker.unlock();
            return new Response(Status.REQUEST_ERROR, "Данные объекта невалидны");
        }
        for (Organization organization : collection.getCollection()) {
            if (organization.getId() == id) {
                if (DataBase.updateById(id, org, user)) {
                    collection.removeByID(id);
                    collection.add(org);
                    org.setId(id);
                    locker.unlock();
                    return new Response(Status.OK, "Элемент успешно обновлён.");
                } else {
                    locker.unlock();
                    return new Response(Status.USER_ERROR, "Пользовательская ошибка. Элемент не был обновлён. " +
                            "Может, Вы пытаетесь модифицировать чужой объект >:(");
                }
            }
        }
        locker.unlock();
        return new Response(Status.REQUEST_ERROR, "Элемента с заданным id в коллекции нет.");
    }
    @Override
    public String getName() {
        return "update id {element}";
    }
    @Override
    public String getInfo() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
