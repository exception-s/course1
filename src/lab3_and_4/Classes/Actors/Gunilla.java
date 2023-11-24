package lab3_and_4.Classes.Actors;

import lab3_and_4.Abstracts.HumanAbstract;

public class Gunilla extends HumanAbstract {
    public Gunilla(){
        super("Гунилла");
    }
    public Gunilla(int age){
        super("Гунилла", age);
    }
    public static void mockery(){
        System.out.println("засмеют его!");
    }
}
