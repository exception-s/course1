package lab5.AppProcessing;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Класс, обрабатывающий адрес организации
 */
@XmlRootElement(name = "postalAddress")
@XmlType(propOrder = {"street", "zipCode"})
public class Address {
    private String street; //Длина строки не должна быть больше 125, Поле не может быть null
    private String zipCode; //Длина строки должна быть не меньше 4, Поле не может быть null
    public Address() {}
    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    @XmlElement(name = "street")
    public String getStreet() {
        return street;
    }
    @XmlElement(name = "zipCode")
    public String getZipCode() {
        return zipCode;
    }
    @Override
    public String toString() {
        return "street: " + street + "; zipcode: " + zipCode;
    }
}
