package lab5.CommandsProcessing;

import lab5.AppProcessing.Organization;
import lab5.AppProcessing.TheCollection;
import lab5.ConsoleProcessing.ConsoleParser;

import java.util.Date;

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
        ConsoleParser parser = new ConsoleParser();
        Organization org = new Organization();
        org.setName(parser.parseName());
        org.setCoordinates(parser.parseCoordinates());
        org.setDate(new Date());
        org.setAnnualTurnover(parser.parseAnnualTurnover());
        org.setFullName(parser.parseFullName());
        org.setEmployeesCount(parser.parseEmployeesCount());
        org.setType(parser.parseType());
        org.setPostalAddress(parser.parsePostalAddress());
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
