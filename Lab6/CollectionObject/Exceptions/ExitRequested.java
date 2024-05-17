package CollectionObject.Exceptions;

/**
 * Исключение для выхода из консольного приложения
 */
public class ExitRequested extends RuntimeException {
    public ExitRequested() {
        super("Завершение работы консольного приложения...");
    }
}
