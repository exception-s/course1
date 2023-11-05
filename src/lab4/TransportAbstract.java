package lab4;

public abstract class TransportAbstract {
    private String name;
    private String type;
    public TransportAbstract(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String getName(){
        return name;
    }

    public abstract void addAction(Actions action);
}
