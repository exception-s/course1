package lab3_and_4.Classes.Actors;

import lab3_and_4.Abstracts.HumanAbstract;
import lab3_and_4.Enums.*;

public class Karlson extends HumanAbstract {
    public Karlson(){
        super("Карлсон");
    }
    public Karlson(int age){
        super("Карлсон", age);
    }
    public void hurt(){
        System.out.println(getName() + " было не до смеха. " + getName() + " всерьёз обиделся");
    }
    public void anxietyAndBuns(Items item){
        System.out.println(getName() + " запихал себе в рот " + item.getItem() + " и проглотил");
    }

}
