package Server.CommandsProcessing;

import CollectionObject.Objects.Organization;
import CollectionObject.Response;
import CollectionObject.Status;
import Server.Server;
import Server.TheCollection;
import CollectionObject.Exceptions.EmptyCollectionException;

import java.io.Serializable;

/**
 * Класс, реализующий команду average_of_annual_turnover
 */
public class AverageAnnualTurnover implements Commandable, Serializable {
    private final TheCollection collection;
    public AverageAnnualTurnover(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public Response execute(String[] input) {
        if (collection.getSize() == 0) {
            return new Response(Status.REQUEST_ERROR, "В коллекции нет элементов.");
        }
        double turnoverSum = 0;
        int count = 0;
        for (Organization org : collection.getCollection()) {
            turnoverSum += org.getAnnualTurnover();
            count++;
        }
        return new Response(Status.OK, Double.toString(turnoverSum/count));
    }
    @Override
    public String getName() {
        return "average_of_annual_turnover";
    }

    @Override
    public String getInfo() {
        return "вывести среднее значение поля annualTurnover для всех элементов коллекции";
    }
}
