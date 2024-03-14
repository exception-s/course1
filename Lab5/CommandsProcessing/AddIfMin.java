package CommandsProcessing;

import AppProcessing.Organization;
import AppProcessing.TheCollection;
import AppProcessing.*;
import ConsoleProcessing.Parser;
import ConsoleProcessing.ScriptReader;

/**
 * Класс, реализующий команду add_if_min
 */
public class AddIfMin implements Commandable {
    private final TheCollection collection;
    public AddIfMin(TheCollection collection) {
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
        if (collection.getSize() == 0) {
            collection.add(org);
            System.out.println("В коллекции не было элементов, поэтому новый элемент успешно добавлен.");
            return;
        }
        Organization minimum = collection.getMin();
        if (minimum.compareTo(org) > 0) {
            collection.add(org);
            System.out.println("Элемент успешно добавлен в коллекцию.");
        }
        else {
            System.out.println("Элемент не удовлетворяет условию и не был добавлен в коллекцию.");
        }
    }
    @Override
    public String getName() {
        return "add_if_min {element}";
    }
    @Override
    public String getInfo() {
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
