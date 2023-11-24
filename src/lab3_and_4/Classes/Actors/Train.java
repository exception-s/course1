package lab3_and_4.Classes.Actors;

import lab3_and_4.Abstracts.PlaceAbstract;
import lab3_and_4.Abstracts.TransportAbstract;

public class Train extends TransportAbstract {
    public Train(){
        super("Поезд", "наземный");
    }
    public  void journey(PlaceAbstract place1, PlaceAbstract place2){
        System.out.println("Сейчас в " + place1.getPlaceName() + " на " + place2.getPlaceName() + " остановился " + getName());
    }
    class Engine{
    }
}
