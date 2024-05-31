package CollectionObjects.Objects;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Функциональный интерфейс, высчитывающий расстояние от заданной точки до организаций(в моём случае начало отсчёта -
 * это общежитие на Вяземском переулке, где я живу :)
 * @param <T>  Тип первой координаты
 * @param <S>  Тип второй координаты
 */
@FunctionalInterface
interface PythagoreanDistance<T, S> {
    float distance(T x, S y);
}

/**
 * Класс, реализующий конкретную организацию
 */
@XmlRootElement(name = "Organization")
@XmlType(propOrder = {"id", "name", "coordinates", "date", "annualTurnover", "fullName",
                                            "employeesCount", "type", "postalAddress"})
public class Organization implements Comparable<Organization>, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Поле не может быть null
    private long employeesCount; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress = new Address("hz", "hz"); //Поле не может быть null

    /**
     * Сеттеры
     */
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }
    public void setAnnualTurnover(long annualTurnover) {
        this.annualTurnover = annualTurnover;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }
    public void setType(OrganizationType type) {
        this.type = type;
    }
    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * Геттеры
     */
    @XmlElement(name = "id")
    public int getId() {
        return id;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
    @XmlElement(name = "coordinates")
    public Coordinates getCoordinates() {
        return coordinates;
    }
    @XmlElement(name = "date")
    public java.util.Date getDate() {
        return creationDate;
    }
    @XmlElement(name = "annualTurnover")
    public long getAnnualTurnover() {
        return annualTurnover;
    }
    @XmlElement(name = "fullName")
    public String getFullName() {
        return fullName;
    }

    @XmlElement(name = "employeesCount")
    public long getEmployeesCount() {
        return employeesCount;
    }
    @XmlElement(name = "type")
    public OrganizationType getType() {
        return type;
    }
    @XmlElement(name = "postalAddress")
    public Address getPostalAddress() {
        return postalAddress;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id).append("; name: ").append(name);
        sb.append("; coordinates: {").append(coordinates.toString()).append("}; creationDate: ");
        sb.append(creationDate).append("; annualTurnover: ").append(annualTurnover);
        sb.append("; fullName: ").append(fullName).append("; employeesCount: ").append(employeesCount);
        sb.append("; type: ").append(type).append("; postalAddress: {").append(postalAddress.toString()).append("}");
        return sb.toString();
    }

    /**
     *
     * @param org the object to be compared.
     * @return int value - итог сравнения
     */
    @Override
    public int compareTo(Organization org) {
        PythagoreanDistance<Long, Long> eval = (x, y) -> (float) Math.sqrt((x - 59.972686) * (x - 59.972686) +
                                                                            (y - 30.301902) * (y - 30.301902));
        return Float.compare(eval.distance(this.coordinates.getX(), this.coordinates.getY()),
                eval.distance(org.getCoordinates().getX(), org.getCoordinates().getY()));
    }
}
