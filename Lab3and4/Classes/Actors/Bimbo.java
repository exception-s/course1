package Classes.Actors;

import Classes.Dog;
import Enums.Items;
import Enums.*;

public class Bimbo extends Dog {
    public Bimbo(){
        super("Бимбо");
    }
    public void calm(Items item){
            System.out.println(getName() + " спал в своей " + item.getItem());
    }
}
