package Server.Exceptions;

/**
 * Исключение для неправильных аргументов команд/иных данных
 */
public class IncorrectArgumentsException extends RuntimeException {
    public IncorrectArgumentsException(String reason) {
        super(reason);
    }
}
