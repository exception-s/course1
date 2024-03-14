package ConsoleProcessing;

/**
 * Интерфейс-валидатор для адресов организаций
 */
public interface CheckerForAddress {
    boolean checkStreet(String street);
    boolean checkZipCode(String zipCode);
}
