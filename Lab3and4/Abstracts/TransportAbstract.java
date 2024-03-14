package Abstracts;


public abstract class TransportAbstract {
    private String name;
    private String type;
    public TransportAbstract(String name, String type) {
        this.name = name;
        this.type = type;
        System.out.println("Транспорт " + name + " типа " + type + " создан");
    }
    public String getName(){
        return name;
    }

}
