package CommandsProcessing;

import java.io.File;

/**
 * Интерфейс для всех команд
 */
public interface Commandable {
    void execute(String[] input);
    String getInfo();
    String getName();
}
