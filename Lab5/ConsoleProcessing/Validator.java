package ConsoleProcessing;

import AppProcessing.Address;
import AppProcessing.Coordinates;

import java.util.Objects;

/**
 * Класс-валидатор, реализующий 2 интерфейса для валидации данных, введённых пользователем
 */
public class Validator implements CheckerForOrganization, CheckerForAddress {
    @Override
    public boolean checkName(String name) {
        return name.isEmpty();
    }

    @Override
    public boolean checkCoordinates(Coordinates coordinates) {
        return (coordinates == null);
    }

    @Override
    public boolean checkCreationDate(String date) {
        return Objects.equals(date, "");
    }

    @Override
    public boolean checkAnnualTurnover(Long annualTurnover) {
        return annualTurnover <= 0;
    }

    @Override
    public boolean checkAddress(Address address) {
        return address == null;
    }

    @Override
    public boolean checkFullName(String fullName) {
        return fullName.isEmpty();
    }

    @Override
    public boolean checkEmployeesCount(long employeesCount) {
        return employeesCount < 0;
    }

    @Override
    public boolean checkType(String type) {
        return type.isEmpty();
    }

    @Override
    public boolean checkStreet(String street) {
        return (street.isEmpty() || street.length() > 125);
    }

    @Override
    public boolean checkZipCode(String zipCode) {
        return zipCode.length() < 4;
    }
}
