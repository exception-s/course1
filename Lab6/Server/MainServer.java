package Server;

import Server.CommandsProcessing.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MainServer {
    public static void main(String[] args) {
        TheCollection collection = new TheCollection();
        HistoryContainer history = new HistoryContainer();
        CommandHandler handler = new CommandHandler(collection, history, "collection.xml");
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
        handler.addCommand("save", new Save(collection));
        handler.addCommand("show", new Show(collection));
        handler.addCommand("update", new Update(collection));
        collection.setCommandList(handler.getCommands());

        Server server = new Server(new InetSocketAddress(63342)); //port 8000 for time excess
        server.launch(handler);
    }
}
