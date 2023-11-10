package lab4;


public class Transport extends TransportAbstract{
    private myHashMap actions = new myHashMap(16);
    public Transport(String name, String type) {
        super(name, type);
        System.out.println("Транспорт " + name + " типа " + type + " создан");
    }

    public void addAction(ActionsAndConditions action, String info) {
        actions.put(action, info);
    }
    public myHashMap getActions(){
        return actions;
    }
}
