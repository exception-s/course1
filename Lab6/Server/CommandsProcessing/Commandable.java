package Server.CommandsProcessing;

import CollectionObject.Response;

/**
 * Интерфейс для всех команд
 */
public interface Commandable {
    Response execute(String[] input);
    String getInfo();
    String getName();
}
