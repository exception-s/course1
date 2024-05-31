package Server.CommandsProcessing;

import CollectionObjects.*;
import CollectionObjects.Exceptions.IncorrectArgumentsException;
import CollectionObjects.Objects.Organization;
import Server.DataBase;
import Server.TheCollection;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
//import ConsoleProcessing.Parser;
//import ConsoleProcessing.ScriptReader;

/**
 * Класс, реализующий команду add
 */
public class Add implements Commandable, Serializable {
    private final TheCollection collection;
    private final ReentrantLock locker = new ReentrantLock();

    public Add(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input, User user) {
        locker.lock();
        Organization org;
        ScriptReader reader = new ScriptReader();
        input = Arrays.copyOfRange(input, 1, input.length);
        try {
            org = reader.scriptReading(input);
        } catch (IncorrectArgumentsException e) {
            locker.unlock();
            return new Response(Status.REQUEST_ERROR, "Данные объекта невалидны");
        }
        if (DataBase.addOrg(org, user)) {
            collection.add(org);
            locker.unlock();
            return new Response(Status.OK, "Элемент успешно добавлен в коллекцию");
        } else {
            locker.unlock();
            return new Response(Status.USER_ERROR, "Пользовательская ошибка. Элемент не добавлен в коллекцию.");
        }
    }
    @Override
    public String getName() {
        return "add {element}";
    }
    @Override
    public String getInfo() {
        return "добавить новый элемент в коллекцию";
    }
}
