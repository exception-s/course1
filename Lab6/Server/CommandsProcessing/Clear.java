package Server.CommandsProcessing;

import CollectionObject.Response;
import CollectionObject.Status;
import Server.TheCollection;

import java.io.Serializable;

/**
 * Класс, реализующий команду clear
 */
public class Clear implements Commandable, Serializable {
    private final TheCollection collection;
    public Clear(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) {
        collection.clear();
        System.out.println("Коллекция успешно очищена.");
        return new Response(Status.OK, "Коллекция успешно очищена.", collection);
    }
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getInfo() {
        return "очистить коллекцию";
    }
}
