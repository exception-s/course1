package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.Status;
import CollectionObjects.User;
import Server.DataBase;
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
    public Response execute(String[] input, User user) {
        if (DataBase.clearCollection(user)) {
            collection.clear();
            return new Response(Status.OK, "Коллекция успешно очищена.");
        } else {
            return new Response(Status.USER_ERROR, "Пользовательская ошибка. Элемент не добавлен в коллекцию.");
        }

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
