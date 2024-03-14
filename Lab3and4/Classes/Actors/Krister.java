package Classes.Actors;

import Abstracts.HumanAbstract;

public class Krister extends HumanAbstract {
    public Krister(){
        super("Кристер");
    }
    public Krister(int age){
        super("Кристер", age);
    }
    public void mockery(HumanAbstract person1, HumanAbstract person2){
        System.out.println(person1.getName() + " и " + getName() + " засмеют " + person2.getName() + "!");
    }
}
