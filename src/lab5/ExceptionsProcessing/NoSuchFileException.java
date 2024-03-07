package lab5.ExceptionsProcessing;

/**
 * Исключение для обработки случая, в котором файл не был найден
 */
public class NoSuchFileException extends RuntimeException {
    public NoSuchFileException(String message){
        super(message);
    }
}
