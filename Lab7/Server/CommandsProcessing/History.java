package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.Status;
import CollectionObjects.User;
import Server.TheCollection;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Класс, реализующий команду history
 */
public class History implements Commandable, Serializable {
    private final TheCollection collection;
    private final HistoryContainer history;
    public History(TheCollection collection, HistoryContainer history) {
        this.collection = collection;
        this.history = history;
    }
    @Override
    public Response execute(String[] input, User user) {
        if (history.getHistory().isEmpty()) {
            return new Response(Status.REQUEST_ERROR, "Вы ещё не вводили никаких команд.");
        }
        ArrayList<Commandable> commandsList = history.getHistory();
        commandsList.remove(commandsList.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (Commandable command : commandsList) {
            sb.append(command.getName());
        }
        history.add(new History(collection, history));
        return new Response(Status.OK, sb.toString());
    }
    @Override
    public String getName() {
        return "history";
    }


    @Override
    public String getInfo() {
        return "вывести последние 6 команд (без их аргументов)";
    }
}
