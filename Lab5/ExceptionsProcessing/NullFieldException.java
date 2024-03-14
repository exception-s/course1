package ExceptionsProcessing;

/**
 * Исключение для пустого(null) ввода
 */
public class NullFieldException extends RuntimeException {
    public NullFieldException() {
        super();
    }
}
