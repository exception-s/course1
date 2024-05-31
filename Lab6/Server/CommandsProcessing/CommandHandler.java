package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.Status;
import Server.TheCollection;
import Server.Exceptions.EmptyCollectionException;
import Server.Exceptions.IncorrectArgumentsException;
import Server.Exceptions.NullFieldException;

import java.util.HashMap;

/**
 * Класс-обработчик команд, поступающих из консоли
 */
public class CommandHandler {
    private final TheCollection collection;
    private final HashMap<String, Commandable> commands = new HashMap<>();
    private final HistoryContainer history;
    private final String file;
    public CommandHandler(TheCollection collection, HistoryContainer history, String file) {
        this.collection = collection;
        this.history = history;
        this.file = file;
    }
    public void addCommand(String commandName, Commandable command) {
        commands.put(commandName, command);
    }
    public HashMap<String, Commandable> getCommands() {
        return commands;
    }
    public Response processInput(String[] input) {
        String command = input[0];
        try {
            if (command.equals("save")) {
                input = new String[]{file};
            }
            history.add(commands.get(command));
            return commands.get(command).execute(input);
        } catch(NullFieldException e) {
            return new Response(Status.REQUEST_ERROR, "Вы не ввели команду.");
        } catch (IncorrectArgumentsException | EmptyCollectionException e) {
            return new Response(Status.REQUEST_ERROR, e.getMessage());
        }
    }
}
