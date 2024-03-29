package CommandsProcessing;

import AppProcessing.TheCollection;
import XMLProcessing.WriteToXML;

import java.io.IOException;

/**
 * Класс, реализующий команду save
 */
public class Save implements Commandable {
    private final TheCollection collection;
    public Save(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        try {
            WriteToXML writer = new WriteToXML(collection, input[1]);
            writer.write();
        } catch (IOException e) {
            System.out.println("IO error");
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
