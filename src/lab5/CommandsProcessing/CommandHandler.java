package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;
import lab5.ExceptionsProcessing.*;

import java.io.File;
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
    public void processInput(String line) {
        String[] input = line.split("\\s+");
        String command = input[0];
        try {
            if (command.isEmpty()) {
                throw new NullFieldException();
            } else {
                if (commands.get(command) == null) {
                    throw new NoSuchCommandException();
                } else {
                    if (command.equals("save")) {
                        line += " " + file;
                        input = line.split("\\s+");
                    }
                    history.add(commands.get(command));
                    commands.get(command).execute(input);
                }
            }
        } catch(NullFieldException e) {
            System.out.println("Вы не ввели команду.");
        } catch (NoSuchCommandException e) {
            System.out.println("Команды {" + command + "} нет в списке команд. Чтобы вывести список, введите {help}.");
        } catch (IncorrectArgumentsException | EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
    }
}
