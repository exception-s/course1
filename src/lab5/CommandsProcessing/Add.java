package lab5.CommandsProcessing;

import lab5.AppProcessing.Organization;
import lab5.AppProcessing.TheCollection;
import lab5.ConsoleProcessing.ConsoleParser;

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
