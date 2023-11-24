package lab3_and_4.Classes.Actors;

import lab3_and_4.Abstracts.HumanAbstract;
import lab3_and_4.Abstracts.PlaceAbstract;
import lab3_and_4.Enums.Places;

public class Freken extends HumanAbstract {
    public Freken(){
        super("Фрекен бок");
    }
    public Freken(int age){
        super("Фрекен бок", age);
    }
    public void hurt(){
        System.out.println(getName() + " посмеялась вволю");
    }
    public void happiness(){
        System.out.println(getName() + " сказала, что тогда свадьба будет без неё");
    }
    public void calm(PlaceAbstract place, HumanAbstract person){
        System.out.println(getName() + " была на " + place.getPlaceName() + " , чтобы ободрить " + person.getName());
    }
}
