package lab5.ExceptionsProcessing;

/**
 * Исключение для обработки команд, которых нет в ТЗ
 */
public class NoSuchCommandException extends RuntimeException {
    public NoSuchCommandException() {
        super();
    }
}
