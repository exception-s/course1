package CommandsProcessing;

import AppProcessing.Organization;
import AppProcessing.TheCollection;
import ConsoleProcessing.Parser;
import ConsoleProcessing.ScriptReader;

import java.util.Arrays;

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
        Parser parser = new Parser();
        Organization org;
        if (input.length > 2) {
            ScriptReader reader = new ScriptReader();
            input = Arrays.copyOfRange(input, 2, input.length);
            org = reader.scriptReading(input);
        } else {
            org = parser.parseOrg();
        }
        for (Organization organization : collection.getCollection()) {
            if (organization.getId() == id) {
                collection.removeByID(id);
                collection.add(org);
                org.setId(id);
                return;
            }
        }
        System.out.println("Элемента с заданным id в коллекции нет.");
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
