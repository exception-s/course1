package Server.FileProcessing;

import CollectionObject.Objects.Organization;
import Server.TheCollection;
import Client.ConsoleProcessing.Validator;
import Server.Exceptions.IncorrectArgumentsException;
import Server.Exceptions.NoFileAccessException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Класс, осуществляющий чтение из XML-файла
 */
public class ReadFromXML {
    private final String fileName;
    private String content;
    private StringBuilder sb;
    public ReadFromXML(String file) {
        this.fileName = file;
    }

    /**
     * Парсинг файла
     * @return TheCollection collection
     * @throws IOException
     */
    public TheCollection parse() throws IOException {
        TheCollection collection = new TheCollection();
        try {
            if (!new File((fileName)).canRead()) {
                throw new NoFileAccessException();
            }
            var context = JAXBContext.newInstance(TheCollection.class);
            var um = context.createUnmarshaller();
            collection = (TheCollection) um.unmarshal(
                    new InputStreamReader(
                            new FileInputStream(fileName),
                            StandardCharsets.UTF_8)
            );
        } catch (JAXBException e) {
            System.out.println("JAXB: file reading error");
            // e.printStackTrace();
        }
        Validator valid = new Validator();
        for (Organization org : collection.getCollection()) {
            //System.out.println(org);
            if (valid.checkName(org.getName()) || valid.checkCoordinates(org.getCoordinates()) ||
                    org.getCoordinates().getY() == null || valid.checkCreationDate(org.getDate().toString()) || valid.checkAnnualTurnover(org.getAnnualTurnover()) ||
                    valid.checkAddress(org.getPostalAddress()) || valid.checkFullName(org.getFullName()) ||
                    valid.checkEmployeesCount(org.getEmployeesCount()) || valid.checkType(org.getType().toString()) ||
                    valid.checkStreet(org.getPostalAddress().getStreet()) ||
                    valid.checkZipCode(org.getPostalAddress().getZipCode())
            ) {
                throw new IncorrectArgumentsException("Данные во входном файле невалидны, попробуйте исправить файл.");
            }
        }
        return collection;
    }
}
