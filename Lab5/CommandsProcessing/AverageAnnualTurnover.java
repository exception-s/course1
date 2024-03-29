package CommandsProcessing;

import AppProcessing.Organization;
import AppProcessing.TheCollection;
import ExceptionsProcessing.EmptyCollectionException;

/**
 * Класс, реализующий команду average_of_annual_turnover
 */
public class AverageAnnualTurnover implements Commandable {
    private final TheCollection collection;
    public AverageAnnualTurnover(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        if (collection.getSize() == 0) {
            throw new EmptyCollectionException();
        }
        double turnoverSum = 0;
        int count = 0;
        for (Organization org : collection.getCollection()) {
            turnoverSum += org.getAnnualTurnover();
            count++;
        }
        System.out.println(turnoverSum/count);
        //System.out.println(collection.getAverageTurnover());
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
