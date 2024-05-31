package Server;

import Client.Hasher;
import Server.CommandsProcessing.*;

import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка. Драйвер отсуствует или не подключен.");
        }
        DataBase.setConnection("jdbc:postgresql://localhost:9000/studs", "s408321", "from pgpass");  // local test
        //DataBase.setConnection("jdbc:postgresql://pg:5432/studs", "s408321", "from pgpgass"); // for helios
        TheCollection collection = DataBase.getCollection();
        HistoryContainer history = new HistoryContainer();
        CommandHandler handler = new CommandHandler(collection, history);
        handler.addCommand("add", new Add(collection));
        handler.addCommand("add_if_min", new AddIfMin(collection));
        handler.addCommand("average_of_annual_turnover", new AverageAnnualTurnover(collection));
        handler.addCommand("clear", new Clear(collection));
        handler.addCommand("exit", new Exit(collection));
        handler.addCommand("help", new Help(collection, handler.getCommands()));
        handler.addCommand("history", new History(collection, history));
        handler.addCommand("info", new Info(collection));
        handler.addCommand("print_descending", new PrintDescending(collection));
        handler.addCommand("print_unique_full_name", new PrintUniqueFullname(collection));
        handler.addCommand("remove_by_id", new RemoveById(collection));
        handler.addCommand("remove_greater", new RemoveGreater(collection));
        handler.addCommand("show", new Show(collection));
        handler.addCommand("update", new Update(collection));
        collection.setCommandList(handler.getCommands());

        Server server = new Server(new InetSocketAddress(52829), handler); // localhost
        //Server server = new Server(new InetSocketAddress(2829), handler); // helios
        server.launch();
    }
}
