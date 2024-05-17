package Server.CommandsProcessing;

import CollectionObject.Exceptions.IncorrectArgumentsException;
import CollectionObject.Objects.Organization;
import CollectionObject.Response;
import CollectionObject.ScriptReader;
import CollectionObject.Status;
import Server.Server;
import Server.TheCollection;

import java.io.Serializable;
import java.util.Arrays;
//import ConsoleProcessing.Parser;
//import ConsoleProcessing.ScriptReader;

/**
 * Класс, реализующий команду add_if_min
 */
public class AddIfMin implements Commandable, Serializable {
    private final TheCollection collection;
    public AddIfMin(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) {
        Organization org;
        ScriptReader reader = new ScriptReader();
        input = Arrays.copyOfRange(input, 1, input.length);
        try {
            org = reader.scriptReading(input);
        } catch (IncorrectArgumentsException e) {
            return new Response(Status.REQUEST_ERROR, "Данные объекта невалидны", collection);
        }
        if (collection.getSize() == 0) {
            collection.add(org);
            return new Response(Status.OK, "В коллекции не было элементов, поэтому новый элемент успешно " +
                    "добавлен.", collection);
        }
        Organization minimum = collection.getMin();
        if (minimum.compareTo(org) > 0) {
            collection.add(org);
            return new Response(Status.OK, "Элемент успешно добавлен в коллекцию", collection);
        }
        else {
            return new Response(Status.REQUEST_ERROR, "Элемент не удовлетворяет условию и не был добавлен " +
                    "в коллекцию.", collection);
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
