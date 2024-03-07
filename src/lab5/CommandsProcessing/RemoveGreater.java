package lab5.CommandsProcessing;

import lab5.AppProcessing.Organization;
import lab5.AppProcessing.TheCollection;
import lab5.ConsoleProcessing.ConsoleParser;
import lab5.ExceptionsProcessing.EmptyCollectionException;

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
