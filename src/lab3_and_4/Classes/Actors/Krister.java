package lab3_and_4.Classes.Actors;

import lab3_and_4.Abstracts.HumanAbstract;

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
