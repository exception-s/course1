package Server.CommandsProcessing;

import CollectionObjects.Exceptions.IncorrectArgumentsException;
import CollectionObjects.Objects.Organization;
import CollectionObjects.Response;
import CollectionObjects.ScriptReader;
import CollectionObjects.Status;
import CollectionObjects.User;
import Server.DataBase;
import Server.TheCollection;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
//import ConsoleProcessing.Parser;
//import ConsoleProcessing.ScriptReader;

/**
 * Класс, реализующий команду add_if_min
 */
public class AddIfMin implements Commandable, Serializable {
    private final TheCollection collection;
    private final ReentrantLock locker = new ReentrantLock();
    public AddIfMin(TheCollection collection) {
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
        if (collection.getSize() == 0 && DataBase.addOrg(org, user)) {
            collection.add(org);
            locker.unlock();
            return new Response(Status.OK, "В коллекции не было элементов, поэтому новый элемент успешно " +
                    "добавлен.");
        }
        Organization minimum = collection.getMin();
        if (minimum.compareTo(org) > 0) {
            if (DataBase.addOrg(org, user)) {
                collection.add(org);
                locker.unlock();
                return new Response(Status.OK, "Элемент успешно добавлен в коллекцию");
            } else {
                locker.unlock();
                return new Response(Status.USER_ERROR, "Пользовательская ошибка. Элемент не добавлен в коллекцию.");
            }
        }
        else {
            locker.unlock();
            return new Response(Status.REQUEST_ERROR, "Элемент не удовлетворяет условию и не был добавлен " +
                    "в коллекцию.");
        }

    }
    @Override
    public String getName() {
        return "add_if_min {element}";
    }
    @Override
    public String getInfo() {
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
