package lab5.XMLProcessing;

import lab5.AppProcessing.Organization;
import lab5.AppProcessing.TheCollection;
import lab5.ConsoleProcessing.Validator;
import lab5.ExceptionsProcessing.IncorrectArgumentsException;
import lab5.ExceptionsProcessing.NoFileAccessException;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Класс, осуществляющий чтение из XML-файла
 */
public class ReadFromXML {
    private String fileName;
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
            //System.out.println("JAXB error");
             e.printStackTrace();
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
