package Server.CommandsProcessing;

import CollectionObjects.*;
import CollectionObjects.Exceptions.IncorrectArgumentsException;
import CollectionObjects.Objects.Organization;
import Server.TheCollection;

import java.io.Serializable;
import java.util.Arrays;
//import ConsoleProcessing.Parser;
//import ConsoleProcessing.ScriptReader;

/**
 * Класс, реализующий команду add
 */
public class Add implements Commandable, Serializable {
    private final TheCollection collection;

    public Add(TheCollection collection) {
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
            return new Response(Status.REQUEST_ERROR, "Данные объекта невалидны");
        }
        collection.add(org);
        return new Response(Status.OK, "Элемент успешно добавлен в коллекцию");
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
