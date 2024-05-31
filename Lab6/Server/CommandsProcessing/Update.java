package Server.CommandsProcessing;

import CollectionObjects.Exceptions.IncorrectArgumentsException;
import CollectionObjects.Objects.Organization;
import CollectionObjects.Response;
import CollectionObjects.ScriptReader;
import CollectionObjects.Status;
import Server.TheCollection;


import java.io.Serializable;
import java.util.Arrays;

/**
 * Класс, реализующий команду update
 */
public class Update implements Commandable, Serializable {
    private final TheCollection collection;
    public Update(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) {
        int id = Integer.parseInt(input[1]);
        Organization org;
        ScriptReader reader = new ScriptReader();
        input = Arrays.copyOfRange(input, 2, input.length);
        try {
            org = reader.scriptReading(input);
        } catch (IncorrectArgumentsException e) {
            return new Response(Status.REQUEST_ERROR, "Данные объекта невалидны");
        }
        for (Organization organization : collection.getCollection()) {
            if (organization.getId() == id) {
                collection.removeByID(id);
                collection.add(org);
                org.setId(id);
                return new Response(Status.OK, "Элемент успешно обновлён.");
            }
        }
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
