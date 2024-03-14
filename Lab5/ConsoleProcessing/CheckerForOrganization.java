package ConsoleProcessing;

import AppProcessing.Address;
import AppProcessing.Coordinates;

/**
 * Интерфейс-валидатор для класса организации
 */
public interface CheckerForOrganization {
    boolean checkName(String name);
    boolean checkCoordinates(Coordinates coordinates);
    boolean checkCreationDate(String date);
    boolean checkAnnualTurnover(Long annualTurnover);
    boolean checkAddress(Address address);
    boolean checkFullName(String fullName);
    boolean checkEmployeesCount(long employeesCount);
    boolean checkType(String type);
}
