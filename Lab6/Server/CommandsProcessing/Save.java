package Server.CommandsProcessing;

import CollectionObject.Response;
import CollectionObject.Status;
import Server.TheCollection;
import Server.CommandsProcessing.Commandable;
import Server.FileProcessing.WriteToXML;

import java.io.IOException;
import java.io.Serializable;

/**
 * Класс, реализующий команду save
 */
public class Save implements Commandable, Serializable {
    private final TheCollection collection;
    public Save(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) {
        try {
            WriteToXML writer = new WriteToXML(collection, (String) input[1]);
            writer.write();
            return new Response(Status.OK, "Коллекция сохранена.", collection);
        } catch (IOException e) {
            System.out.println("IO error");
            return new Response(Status.REQUEST_ERROR, "IO error", collection);
        }
    }
    @Override
    public String getName() {
        return "save";
    }


    @Override
    public String getInfo() {
        return "сохранить коллекцию в файл";
    }
}
