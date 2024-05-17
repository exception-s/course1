package CollectionObject.Exceptions;

/**
 * Исключение для пустой коллекции
 */
public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException() {
        super("В коллекции нет элементов.");
    }
}
