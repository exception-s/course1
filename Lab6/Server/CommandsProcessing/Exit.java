package Server.CommandsProcessing;

import CollectionObject.Response;
import CollectionObject.Status;
import Server.FileProcessing.WriteToXML;
import Server.TheCollection;
import CollectionObject.Exceptions.ExitRequested;

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
    public Response execute(String[] input) throws ExitRequested {
        WriteToXML writer = new WriteToXML(collection, "collection");
        try {
            writer.write();
        } catch (IOException e) {
            System.out.println("IO error");
        }
        return new Response(Status.OK, "Коллекция была успешно сохранена в файл. \n" +
                "Завершение работы консольного приложения...", collection);
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
