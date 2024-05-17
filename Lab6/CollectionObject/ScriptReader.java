package CollectionObject;


import Client.ConsoleProcessing.Validator;
import CollectionObject.Exceptions.IncorrectArgumentsException;
import CollectionObject.Objects.Address;
import CollectionObject.Objects.Coordinates;
import CollectionObject.Objects.Organization;
import CollectionObject.Objects.OrganizationType;

import java.util.Date;

public class ScriptReader {
    public Organization scriptReading(String[] input) throws IncorrectArgumentsException {
        try {
            Validator valid = new Validator();
            Organization org = new Organization();
            String name = input[0];
            long x = Long.parseLong(input[1]);
            long y = Long.parseLong(input[2]);
            long annualTurnover = Long.parseLong(input[3]);
            String fullName = input[4];
            int employeesCount = Integer.parseInt(input[5]);
            String type = input[6];
            String street = input[7];
            String zipCode = input[8];
            Coordinates coord = new Coordinates(x, y);
            Date date = new Date();
            Address postalAddress = new Address(street, zipCode);
            if (valid.checkName(name) || valid.checkCoordinates(coord) ||
                    valid.checkAnnualTurnover(annualTurnover) ||
                    valid.checkAddress(postalAddress) || valid.checkFullName(fullName) ||
                    valid.checkEmployeesCount(employeesCount) || valid.checkType(type) ||
                    valid.checkStreet(street) ||
                    valid.checkZipCode(zipCode)
            ) {
                throw new IncorrectArgumentsException("Данные в скрипте невалидны.");
            } else {
                org.setName(name);
                org.setCoordinates(coord);
                org.setDate(date);
                org.setAnnualTurnover(annualTurnover);
                org.setFullName(fullName);
                org.setEmployeesCount(employeesCount);
                org.setType(OrganizationType.valueOf(type));
                org.setPostalAddress(postalAddress);
                return org;
            }
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentsException("Данные в скрипте невалидны.");
        }
    }
}
