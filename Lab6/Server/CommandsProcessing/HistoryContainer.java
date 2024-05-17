package Server.CommandsProcessing;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Класс, хранящий историю команд
 */
public class HistoryContainer implements Serializable {
    private final ArrayList<Commandable> commands = new ArrayList<>();
    private final int MAX_SIZE = 7;
    public void add(Commandable command) {
        if (commands.size() == MAX_SIZE) {
            commands.removeFirst();
        }
        commands.add(command);
    }
    public ArrayList<Commandable> getHistory() {
        return commands;
    }
}
