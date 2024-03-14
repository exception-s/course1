package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;

import java.io.File;

/**
 * Класс, реализующий команду info
 */
public class Info implements Commandable {
    private final TheCollection collection;
    public Info(TheCollection collection) {
        this.collection = collection;
    }
    @Override
    public void execute(String[] input) {
        System.out.println("Тип: " + collection.getClass().getSimpleName());
        System.out.println("Дата инициализации: " + collection.getCreationDate());
        System.out.println("Количество элементов: " + collection.getSize());
    }
    @Override
    public String getName() {
        return "info";
    }


    @Override
    public String getInfo() {
        return "вывести в стандартный поток вывода информацию " +
                "о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
