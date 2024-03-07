package lab5.CommandsProcessing;

import lab5.AppProcessing.Organization;
import lab5.AppProcessing.TheCollection;
import lab5.ConsoleProcessing.ConsoleParser;

import java.util.Date;

/**
 * Класс, реализующий команду update
 */
public class Update implements Commandable {
    private final TheCollection collection;
    public Update(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        int id = Integer.parseInt(input[1]);
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
            if (organization.getId() == id) {
                collection.removeByID(id);
                collection.add(org);
                org.setId(id);
            }
        }
    }
    @Override
    public String getName() {
        return "update id {element}";
    }
    @Override
    public String getInfo() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
