package Server.CommandsProcessing;

import CollectionObjects.Response;
import CollectionObjects.Status;
import CollectionObjects.User;
import Server.TheCollection;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Класс, реализующий команду help
 */
public class Help implements Commandable, Serializable {
    private final TheCollection collection;
    private final HashMap<String, Commandable> commands;
    public Help(TheCollection collection, HashMap<String, Commandable> commands) {
        this.collection = collection;
        this.commands = commands;
    }
    @Override
    public Response execute(String[] input, User user) {
        return new Response(Status.OK,
                """
                        help : вывести справку по доступным командам
                        info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                        show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                        add {element} : добавить новый элемент в коллекцию
                        update id {element} : обновить значение элемента коллекции, id которого равен заданному
                        remove_by_id id : удалить элемент из коллекции по его id
                        clear : очистить коллекцию
                        execute_script file_name : считать и исполнить скрипт из указанного файла
                        exit : завершить программу (без сохранения в файл)
                        add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                        remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
                        history : вывести последние 6 команд (без их аргументов)
                        average_of_annual_turnover : вывести среднее значение поля annualTurnover для всех элементов коллекции
                        print_descending : вывести элементы коллекции в порядке убывания
                        print_unique_full_name : вывести уникальные значения поля fullName всех элементов в коллекции
                        """);
    }
    @Override
    public String getName() {
        return "help";
    }


    @Override
    public String getInfo() {
        return "вывести справку по доступным командам";
    }
}
