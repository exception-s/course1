package XMLProcessing;

import AppProcessing.TheCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

/**
 * Класс, осуществляющий запись коллекции в XML-файл
 */
public class WriteToXML {
    private final TheCollection collection;
    private final String file;
    public WriteToXML(TheCollection collection, String file) {
        this.collection = collection;
        this.file = file;
    }

    /**
     * Запись в файл
     * @throws IOException
     */
    public void write() throws IOException {
        try {
            //String xmlResult = "C:\\Users\\flqme\\IdeaProjects\\course1\\src\\lab5\\xmlResult";
            var context = JAXBContext.newInstance(TheCollection.class);
            var m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(collection, new File(file));
            System.out.println("Коллекция была успешно сохранена в файл.");
        } catch (JAXBException e) {
            System.out.println("JAXB error");;
        }
    }
}
