package lab4;

import java.util.ArrayList;

public class Human extends HumanAbstract {
    private ArrayList<Actions> actions = new ArrayList<>();
    private ArrayList<Actions> conditions = new ArrayList<>();
    public static class MyNullException extends Exception{
        public MyNullException(String info){
            super(info);
        }
    }
    public Human(String name) throws MyNullException {
        super(name);
        if (name.isEmpty()){
            throw new MyNullException("У человека нет имени");
        }
        System.out.println("Человек с именем " + name + " создан");
    }
    public void addAction(Actions action) {
        actions.add(action);
    }
    public String getActionsName(int i){
        if (i > actions.size()){
            throw new OutOfRange("ERROR, такого имени нет");
        }
        return actions.get(i).getName();
    }
    public String getActionsAbility(int i){
        if (i > actions.size()){
            throw new OutOfRange("ERROR, Нет такого действия");
        }
        return actions.get(i).getAbility();
    }
    public void addCondition(Actions condition) {
        conditions.add(condition);
    }
}
