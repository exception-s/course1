package CollectionObjects.Exceptions;

/**
 * Исключение для повторяющихся файлов
 */
public class FileRepeatException extends RuntimeException {
    public FileRepeatException(String message) {
        super(message);
    }
}
