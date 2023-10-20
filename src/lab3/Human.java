package lab3;

import java.util.ArrayList;

public class Human extends HumanAbstract {
    private ArrayList<Actions> actions = new ArrayList<>();
    public Human(String name) {
        super(name);
        System.out.println("Человек с именем " + name + " создан");
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
}
