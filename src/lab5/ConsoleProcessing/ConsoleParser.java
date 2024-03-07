package lab5.ConsoleProcessing;

import lab5.AppProcessing.*;
import lab5.ExceptionsProcessing.ExitRequested;
import lab5.ExceptionsProcessing.IncorrectArgumentsException;
import lab5.ExceptionsProcessing.NullFieldException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Класс, осуществляющий парсинг экземпляра организации из консоли
 */
public class ConsoleParser {
    private final Validator validator = new Validator();
    private final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Парсинг имени
     * @return String name
     */
    public String parseName() {
        System.out.print("Пожалуйста, введите название организации: ");
        while (true) {
            try {
                String name = scanner.readLine().trim();
                if (validator.checkName(name)) {
                    throw new IncorrectArgumentsException("Вы ничего не ввели, попробуйте ещё: ");
                }
                else {
                    return name;
                }
            } catch (NullFieldException e) {
                System.out.println("Имя не может быть пустым, попробуйте ещё: ");
            } catch (IncorrectArgumentsException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO ERROR");
            } catch (NullPointerException e) {
                throw new ExitRequested();
            }
        }
    }

    /**
     * Парсинг координат
     * @return Coordinates coordinates
     */
    public Coordinates parseCoordinates() {
        System.out.println("Пожалуйста, введите координаты: ");
        long x = parseX();
        Long y = parseY();
        Coordinates coordinates = new Coordinates(x, y);
        return coordinates;
    }

    /**
     * Парсинг координаты X
     * @return long x
     * @throws NullFieldException
     */
    private long parseX() throws NullFieldException {
        System.out.print("Введите координату X: ");
        while (true) {
            try {
                String input = scanner.readLine().trim();
                if (input.isBlank() || input.equals(System.lineSeparator())) {
                    throw new NullFieldException();
                }
                else {
                    long x = Long.parseLong(input);
                    return x;
                }
            } catch (NullFieldException e) {
                System.out.println("Вы не ввели X, попробуйте снова: ");
            } catch (NumberFormatException e) {
                System.out.println("Координата X должна быть типа long. Попробуйте ввести снова: ");
            } catch (IOException e) {
                System.out.println("IO ERROR");
            }
        }
    }

    /**
     * Парсинг координаты Y
     * @return Long y
     */
    private Long parseY() {
        System.out.print("Введите координату Y: ");
        while (true) {
            try {
                String input = scanner.readLine();
                if (input.isBlank()) {
                    throw new NullFieldException();
                }
                else {
                    Long y = Long.parseLong(input);
                    return y;
                }
            } catch (NullFieldException e) {
                System.out.println("Вы не ввели Y, попробуйте снова: ");
            } catch (NumberFormatException e) {
                System.out.println("Координата Y должна быть типа Long. Попробуйте ввести снова: ");
            } catch (IOException e) {
                System.out.println("IO ERROR");
            }
        }
    }

    /**
     * Парсинг годового оборота
     * @return Long annualTurnover
     */
    public Long parseAnnualTurnover() {
        System.out.print("Пожалуйста, введите годовой оборот: ");
        while (true) {
            try {
                String input = scanner.readLine();
                if (input.isEmpty()) {
                    throw new NullFieldException();
                }
                else {
                    Long annualTurnover = Long.parseLong(input);
                    if (annualTurnover <= 0) {
                        throw new NumberFormatException();
                    }
                    return annualTurnover;
                }
            } catch (NullFieldException e) {
                System.out.println("Вы не ввели годовой оборот, попробуйте снова: ");
            } catch (NumberFormatException e) {
                System.out.println("Годовой оборот должен быть типа Long и больше нуля. Попробуйте ввести снова: ");
            } catch (IOException e) {
                System.out.println("IO ERROR");
            }
        }
    }

    /**
     * Парсинг полного имени
     * @return String fullName
     */
    public String parseFullName() {
        System.out.print("Пожалуйста, введите полное имя: ");
        while (true) {
            try {
                String fullName = scanner.readLine().trim();
                if (validator.checkFullName(fullName)) {
                    throw new NullFieldException();
                }
                else {
                    return fullName;
                }
            } catch (NullFieldException e) {
                System.out.println("Вы не ввели полное имя, попробуйте снова: ");
            } catch (IOException e) {
                System.out.println("IO ERROR");
            } catch (NullPointerException e) {
                throw new ExitRequested();
            }
        }
    }

    /**
     * Парсинг количества работников
     * @return long employeesCount
     */
    public long parseEmployeesCount() {
        System.out.print("Пожалуйста, введите количество сотрудников: ");
        while (true) {
            try {
                String input = scanner.readLine();
                if (input.isEmpty()) {
                    throw new NullFieldException();
                }
                else {
                    long employeesCount = Long.parseLong(input);
                    if (validator.checkEmployeesCount(employeesCount)) {
                        throw new IncorrectArgumentsException("Вы ничего не ввели или ввели неправильно. " +
                                "Пожалуйста, введите количество сотрудников(это положительное число): ");
                    }
                    else {
                        return employeesCount;
                    }
                }
            } catch (IncorrectArgumentsException | NullFieldException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Количество работников должно быть типа Long. Попробуйте ввести снова: ");
            } catch (IOException e) {
                System.out.println("IO ERROR");
            }
        }
    }

    /**
     * Парсинг типа организации
     * @return OrganizationType type
     */
    public OrganizationType parseType() {
        System.out.print("Пожалуйста, введите тип организации(GOVERNMENT, PRIVATE_LIMITED_COMPANY" +
                " или OPEN_JOINT_STOCK_COMPANY): ");
        while (true) {
            try {
                String type = scanner.readLine().trim();
                if (validator.checkType(type)) {
                    throw new NullFieldException();
                }
                else {
                    switch (type) {
                        case "GOVERNMENT" -> {
                            return OrganizationType.GOVERNMENT;
                        }
                        case "PRIVATE_LIMITED_COMPANY" -> {
                            return OrganizationType.PRIVATE_LIMITED_COMPANY;
                        }
                        case "OPEN_JOINT_STOCK_COMPANY" -> {
                            return OrganizationType.OPEN_JOINT_STOCK_COMPANY;
                        }
                    }
                }
            } catch (NullFieldException e) {
                System.out.println("Вы не ввели тип организации, попробуйте снова: ");
            } catch (IOException e) {
                System.out.println("IO ERROR");
            }
        }
    }

    /**
     * Парсинг почтового адреса
     * @return Address postalAddress
     */
    public Address parsePostalAddress() {
        System.out.println("Пожалуйста, введите почтовый адрес организации: ");
        String street = parseStreet();
        String zipCode = parseZipCode();
        Address postalAddress = new Address(street, zipCode);
        return postalAddress;
    }

    /**
     * Парсинг улицы
     * @return String street
     */
    private String parseStreet() {
        System.out.print("Введите улицу: ");
        while (true) {
            try {
                String street = scanner.readLine().trim();
                if (validator.checkStreet(street)) {
                    throw new IncorrectArgumentsException("Вы ничего не ввели или ввели неправильно. " +
                            "Пожалуйста, введите улицу(длина строки должна быть не более 125 символов): ");
                }
                else {
                    return street;
                }
            } catch (IncorrectArgumentsException | NullFieldException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO ERROR");
            }
        }
    }

    /**
     * Парсинг почтового индекса
     * @return String zipCode
     */
    private String parseZipCode() {
        System.out.print("Введите индекс: ");
        while (true) {
            try {
                String input = scanner.readLine().trim();
                if (!input.isEmpty()) {
                    String zipCode = input;
                    if (validator.checkStreet(zipCode)) {
                        throw new IncorrectArgumentsException("Вы ничего не ввели или ввели неправильно. " +
                                "Пожалуйста, введите индекс (длина строки должна быть не менее 4 символов)");
                    }
                    else {
                        return zipCode;
                    }
                }
                else {
                    throw new NullFieldException();
                }
            } catch (IncorrectArgumentsException | NullFieldException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("IO ERROR");
            }
        }
    }
}