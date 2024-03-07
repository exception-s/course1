package lab5.ConsoleProcessing;

import lab5.AppProcessing.Address;
import lab5.AppProcessing.Coordinates;
import lab5.AppProcessing.OrganizationType;

/**
 * Интерфейс-валидатор для класса организации
 */
public interface CheckerForOrganization {
    boolean checkName(String name);
    boolean checkCoordinates(Coordinates coordinates);
    boolean checkCreationDate(java.time.LocalDateTime date);
    boolean checkAnnualTurnover(Long annualTurnover);
    boolean checkAddress(Address address);
    boolean checkFullName(String fullName);
    boolean checkEmployeesCount(long employeesCount);
    boolean checkType(String type);
    boolean checkPostalAddress(Address postalAddress);
}
