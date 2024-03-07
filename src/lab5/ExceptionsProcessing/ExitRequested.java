package lab5.ExceptionsProcessing;

import lab5.CommandsProcessing.ExecuteScript;

/**
 * Исключение для выхода из консольного приложения
 */
public class ExitRequested extends RuntimeException {
    public ExitRequested() {
        super("Завершение работы консольного приложения...");
    }
}
