package CollectionObjects.Exceptions;

public class NoFileAccessException extends RuntimeException {
    public NoFileAccessException() {
        super("К файлу отсутствует доступ.");
    }
}
