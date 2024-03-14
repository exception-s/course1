package lab5.AppProcessing;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * Класс, обрабатывающий координаты организации
 */
@XmlRootElement(name = "coordinates")
@XmlType(propOrder = {"x", "y"})
public class Coordinates {
    private long x;
    private long y; // Поле не может быть null
    public Coordinates() {}
    public Coordinates(long x, Long y) {
        this.x = x;
        this.y = y;
    }
    @XmlElement(name = "x")
    public long getX() {
        return x;
    }
    @XmlElement(name = "y")
    public Long getY() {
        return y;
    }
    @Override
    public String toString() {
        return "X: " + x + "; Y: " + y;
    }
}
