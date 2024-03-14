package lab5.ConsoleProcessing;

import lab5.AppProcessing.Address;
import lab5.AppProcessing.Coordinates;
import lab5.AppProcessing.OrganizationType;

import java.util.Date;

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
