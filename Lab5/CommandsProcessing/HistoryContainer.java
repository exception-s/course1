package CommandsProcessing;

import java.util.ArrayList;

/**
 * Класс, хранящий историю команд
 */
public class HistoryContainer {
    private final ArrayList<Commandable> commands = new ArrayList<>();
    private final int MAX_SIZE = 7;
    public void add(Commandable command) {
        if (commands.size() == MAX_SIZE) {
            commands.remove(0);
        }
        commands.add(command);
    }
    public ArrayList<Commandable> getHistory() {
        return commands;
    }
}
