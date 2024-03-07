package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;
import lab5.XMLProcessing.WriteToXML;

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
            WriteToXML writer = new WriteToXML(collection);
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
