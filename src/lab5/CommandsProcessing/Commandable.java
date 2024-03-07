package lab5.CommandsProcessing;

/**
 * Интерфейс для всех команд
 */
public interface Commandable {
    void execute(String[] input);
    String getInfo();
    String getName();
}
