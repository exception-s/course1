package lab5.XMLProcessing;

import lab5.AppProcessing.Organization;
import lab5.AppProcessing.TheCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

/**
 * Класс, осуществляющий запись коллекции в XML-файл
 */
public class WriteToXML {
    private final TheCollection organizations;
    public WriteToXML(TheCollection organizations) {
        this.organizations = organizations;
    }

    /**
     * Запись в файл
     * @throws IOException
     */
    public void write() throws IOException {
        try {
            String xmlResult = "C:\\Users\\flqme\\IdeaProjects\\course1\\src\\lab5\\xmlResult";
            var context = JAXBContext.newInstance(TheCollection.class);
            var m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(organizations, new File(xmlResult));
            System.out.println("Коллекция была успешно сохранена в файл.");
        } catch (JAXBException e) {
            System.out.println("JAXB error");;
        }
    }
}
