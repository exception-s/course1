package lab3_and_4.Classes.Actors;

import lab3_and_4.Classes.Dog;
import lab3_and_4.Enums.*;

public class Bimbo extends Dog {
    public Bimbo(){
        super("Бимбо");
    }
    public void calm(Items item){
            System.out.println(getName() + " спал в своей " + item.getItem());
    }
}
