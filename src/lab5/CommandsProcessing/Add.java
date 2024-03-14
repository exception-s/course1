package lab5.CommandsProcessing;

import lab5.AppProcessing.*;
import lab5.ConsoleProcessing.Parser;
import lab5.ConsoleProcessing.ScriptReader;
import lab5.ConsoleProcessing.Validator;
import lab5.ExceptionsProcessing.IncorrectArgumentsException;

import java.io.File;
import java.util.Date;

/**
 * Класс, реализующий команду add
 */
public class Add implements Commandable {
    private final TheCollection collection;

    public Add(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        Parser parser = new Parser();
        Organization org;
        if (input.length > 1) {
            ScriptReader reader = new ScriptReader();
            org = reader.scriptReading(input);
        } else {
            org = parser.parseOrg();
        }
        collection.add(org);
        System.out.println("Элемент успешно добавлен в коллекцию.");
    }
    @Override
    public String getName() {
        return "add {element}";
    }
    @Override
    public String getInfo() {
        return "добавить новый элемент в коллекцию";
    }
}
