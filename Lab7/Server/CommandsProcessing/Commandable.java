package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.User;

/**
 * Интерфейс для всех команд
 */
public interface Commandable {
    Response execute(String[] input, User user);
    String getInfo();
    String getName();
}
