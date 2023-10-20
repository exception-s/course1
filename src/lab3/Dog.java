package lab3;

import java.util.ArrayList;

public class Dog {
    private String name;
    private ArrayList<Actions> actions = new ArrayList<>();
    public Dog(String name){
        this.name = name;
        System.out.println("Собачка " + name + " создана");
    }
    public void addAction(Actions action) {
        actions.add(action);
    }
    public String getActionsName(int i){
        return actions.get(i).getName();
    }
    public String getActionsAbility(int i){
        return actions.get(i).getAbility();
    }
    public String getName(){
        return name;
    }
}
