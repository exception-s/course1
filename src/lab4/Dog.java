package lab4;


public class Dog {
    private String name;
    private myHashMap actions = new myHashMap(16);
    public Dog(String name){
        this.name = name;
        System.out.println("Собачка " + name + " создана");
    }
    public void addAction(ActionsAndConditions action, String info) {
        actions.put(action, info);
    }
    public myHashMap getActions(){
        return actions;
    }
    public String getName(){
        return name;
    }
}
