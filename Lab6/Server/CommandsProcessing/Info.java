package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.Status;
import Server.TheCollection;

import java.io.Serializable;

/**
 * Класс, реализующий команду info
 */
public class Info implements Commandable, Serializable {
    private final TheCollection collection;
    public Info(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) {
        StringBuilder sb = new StringBuilder();
        sb.append("Тип: ").append(collection.getClass().getSimpleName()).append("\n").append("Дата инициализации: ").append(
                        collection.getCreationDate()).append("\n").append("Количество элементов: ").append(
                        collection.getSize()).append("\n");
        return new Response(Status.OK, sb.toString());
    }
    @Override
    public String getName() {
        return "info";
    }


    @Override
    public String getInfo() {
        return "вывести в стандартный поток вывода информацию " +
                "о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
