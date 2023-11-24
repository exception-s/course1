package lab3_and_4.Classes.Actors;

import lab3_and_4.Abstracts.PlaceAbstract;
import lab3_and_4.Abstracts.TransportAbstract;
import lab3_and_4.Enums.Places;

public class Steamship extends TransportAbstract {
    public Steamship(){
        super("белый пароход", "водный");
    }
    public void journey(PlaceAbstract place1, PlaceAbstract place2){
        System.out.println("Где-то в " + place1.getPlaceName() + " плывёт назад, в " + place2.getPlaceName() + " " + getName());
    }
}
