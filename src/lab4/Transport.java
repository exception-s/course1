package lab4;

import java.util.ArrayList;

public class Transport extends TransportAbstract{
    private ArrayList<Actions> actions = new ArrayList<>();
    public Transport(String name, String type) {
        super(name, type);
        System.out.println("Транспорт " + name + " типа " + type + " создан");
    }

    public void addAction(Actions action) {
        actions.add(action);
    }
}
