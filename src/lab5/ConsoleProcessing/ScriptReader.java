package lab5.ConsoleProcessing;


import lab5.AppProcessing.*;
import lab5.ExceptionsProcessing.IncorrectArgumentsException;

import java.util.Date;
import java.util.Scanner;

public class ScriptReader {
    public Organization scriptReading(String[] input) throws IllegalArgumentException {
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
            System.out.println("Данные в скрипте невалидны.");
        }
        return new Organization();
    }
}
