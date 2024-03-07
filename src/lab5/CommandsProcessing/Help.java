package lab5.CommandsProcessing;

import lab5.AppProcessing.TheCollection;

import java.util.HashMap;

/**
 * Класс, реализующий команду help
 */
public class Help implements Commandable {
    private final TheCollection collection;
    private final HashMap<String, Commandable> commands;
    public Help(TheCollection collection, HashMap<String, Commandable> commands) {
        this.collection = collection;
        this.commands = commands;
    }
    @Override
    public void execute(String[] input) {
        System.out.println(commands.get("help").getName() + " : " + commands.get("help").getInfo());
        System.out.println(commands.get("info").getName() + " : " + commands.get("info").getInfo());
        System.out.println(commands.get("show").getName() + " : " + commands.get("show").getInfo());
        System.out.println(commands.get("add").getName() + " : " + commands.get("add").getInfo());
        System.out.println(commands.get("update").getName() + " : " + commands.get("update").getInfo());
        System.out.println(commands.get("remove_by_id").getName() + " : " + commands.get("remove_by_id").getInfo());
        System.out.println(commands.get("clear").getName() + " : " + commands.get("clear").getInfo());
        System.out.println(commands.get("save").getName() + " : " + commands.get("save").getInfo());
        System.out.println(commands.get("execute_script").getName() + " : " + commands.get("execute_script").getInfo());
        System.out.println(commands.get("exit").getName() + " : " + commands.get("exit").getInfo());
        System.out.println(commands.get("add_if_min").getName() + " : " + commands.get("add_if_min").getInfo());
        System.out.println(commands.get("remove_greater").getName() + " : " + commands.get("remove_greater").getInfo());
        System.out.println(commands.get("history").getName() + " : " + commands.get("history").getInfo());
        System.out.println(commands.get("average_of_annual_turnover").getName() + " : " + commands.get("average_of_annual_turnover").getInfo());
        System.out.println(commands.get("print_descending").getName() + " : " + commands.get("print_descending").getInfo());
        System.out.println(commands.get("print_unique_full_name").getName() + " : " + commands.get("print_unique_full_name").getInfo());
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
