package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.Status;
import CollectionObjects.User;

import Server.DataBase;
import Server.TheCollection;
import CollectionObjects.Exceptions.ExitRequested;

import java.io.IOException;
import java.io.Serializable;

/**
 * Класс, реализующий команду exit
 */
public class Exit implements Commandable, Serializable {
    private final TheCollection collection;
    public Exit(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input, User user) throws ExitRequested {
        DataBase.close();
        return new Response(Status.OK, "Завершение работы консольного приложения...");
    }
    @Override
    public String getName() {
        return "exit";
    }


    @Override
    public String getInfo() {
        return "завершить программу (без сохранения в файл)";
    }
}
