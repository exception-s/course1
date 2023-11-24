package lab3_and_4.Classes.Actors;

import lab3_and_4.Abstracts.HumanAbstract;

public class Julius extends HumanAbstract {
    public Julius(){
        super("дядя Юлиус");
    }
    public Julius(int age){
        super("дядя Юлиус", age);
    }
    public void journey(){
            System.out.println("Из вагона вышел " + getName());
    }
    public void happiness(HumanAbstract person){
        System.out.println(getName() + " был так счастлив, что ему хотелось, чтобы все были счастливы, и " + getName() + " тут же пригласил " + person.getName());
    }
}
