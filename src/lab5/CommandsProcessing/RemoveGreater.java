package lab5.CommandsProcessing;

import lab5.AppProcessing.*;
import lab5.ConsoleProcessing.Parser;
import lab5.ConsoleProcessing.ScriptReader;
import lab5.ConsoleProcessing.Validator;
import lab5.ExceptionsProcessing.EmptyCollectionException;
import lab5.ExceptionsProcessing.IncorrectArgumentsException;

import java.io.File;
import java.util.Date;

/**
 * Класс, реализующий команду remove_greater
 */
public class RemoveGreater implements Commandable {
    private final TheCollection collection;
    public RemoveGreater(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        if (collection.getSize() == 0) {
            throw new EmptyCollectionException();
        }
        Parser parser = new Parser();
        Organization org;
        if (input.length > 1) {
            ScriptReader reader = new ScriptReader();
            org = reader.scriptReading(input);
        } else {
            org = parser.parseOrg();
        }
        for (Organization organization : collection.getCollection()) {
            if (organization.compareTo(org) > 0) {
                collection.removeByID(organization.getId());
            }
        }
        System.out.println("Операция успешно выполнена.");
    }
    @Override
    public String getName() {
        return "remove_greater {element}";
    }
    @Override
    public String getInfo() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }
}
