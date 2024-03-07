package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;
import lab5.ExceptionsProcessing.IncorrectArgumentsException;

/**
 * Класс, реализующий команду remove_by_id
 */
public class RemoveById implements Commandable {
    private final TheCollection collection;
    public RemoveById(TheCollection collection){
        this.collection = collection;
    }
    public void execute(String[] args) throws IncorrectArgumentsException {
        int id = Integer.parseInt(args[1]);
        if (!collection.removeByID(id)) {
            throw new IncorrectArgumentsException("Элемента с таким id нет в коллекции.");
        }
        else {
            System.out.println("Элемент с id " + id + " успешно удалён из коллекции.");
        }
    }
    @Override
    public String getName() {
        return "remove_by_id id";
    }
    @Override
    public String getInfo() {
        return "удалить элемент из коллекции по его id";
    }
}
