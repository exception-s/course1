package Server;


import CollectionObject.Objects.Organization;
import Server.CommandsProcessing.Commandable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;


/**
 * Класс, управляющий всей коллекцией
 */
@XmlRootElement(namespace = "TheCollection")
public class TheCollection implements Serializable {
    @XmlElementWrapper(name = "Organizations")

    @XmlElement(name = "Organization")
    private final LinkedHashSet<Organization> collection = new LinkedHashSet<>();
    private HashMap<String, Commandable> commands;
    Date creation = new Date();
    private int uniqueId = getSize() + 1;
    public LinkedHashSet<Organization> getCollection() {
        return collection;
    }

    /**
     * Добавление организации в коллекцию с генерацией ID
     * @param org экземпляр организации
     */
    public void add(Organization org) {
        org.setId(idGenerator());
        collection.add(org);
    }

    /**
     * Удаление организации по id
     * @return boolean true, если
     * @param id - id организации
     */
    public boolean removeByID(int id) {
        for (Organization org : collection) {
            if (org.getId() == id) {
                collection.remove(org);
                return true;
            }
        }
        return false;
    }

    /**
     * Очищение коллекции
     */
    public void clear() {
        collection.clear();
    }

    /**
     * Геттеры
     */
    public Date getCreationDate() {
        return creation;
    }
    public int getSize() {
        return collection.size();
    }
    public Organization getMin() {
        return Collections.min(collection);
    }
    public void setCommandList(HashMap<String, Commandable> commands) {
        this.commands = commands;
    }
    public HashMap<String, Commandable> getCommandsList() {
        return commands;
    }

    /**
     * Генерация id
     * @return ind id
     */
    public int idGenerator() {
        return ++uniqueId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Organization org : collection) {
            sb.append(org.toString());
            sb.append('\n');
        }
        return sb.toString();
    }
}
