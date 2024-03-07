package lab5.XMLProcessing;

import lab5.AppProcessing.Organization;
import lab5.AppProcessing.TheCollection;

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
            var context = JAXBContext.newInstance(TheCollection.class);
            var um = context.createUnmarshaller();
            collection = (TheCollection) um.unmarshal(
                    new InputStreamReader(
                            new FileInputStream(fileName),
                            StandardCharsets.UTF_8
                    )
            );
        } catch (JAXBException e) {
            System.out.println("JAXB error");
        }
        return collection;
    }
}
