package Classes.Actors;

import Abstracts.HumanAbstract;
import Enums.Items;
import Enums.*;

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
