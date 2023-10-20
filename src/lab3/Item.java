package lab3;

public class Item {
    private String name;
    private String act;
    public Item(String name, String action) {
        this.name = name;
        this.act = action;
        System.out.println("Предмет " + name + " создан");
    }
    public String getName(){
        return name;
    }
    public String getAct(){
        return act;
    }
}
