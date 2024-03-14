package Classes.Actors;

import Abstracts.PlaceAbstract;
import Abstracts.TransportAbstract;

public class Train extends TransportAbstract {
    public Train(){
        super("Поезд", "наземный");
    }
    public  void journey(PlaceAbstract place1, PlaceAbstract place2){
        System.out.println("Сейчас в " + place1.getPlaceName() + " на " + place2.getPlaceName() + " остановился " + getName());
    }
    class Engine{
        private final int power;
        private final String model;
        private final int year;
        public Engine(int pow, String model, int year){
            this.power = pow;
            this.model = model;
            this.year = year;
        }
        public boolean isItWorking(){
            return power >= 100;
        }
        public boolean isItRelevant(){
            return year > 2020;
        }
        // etc
    }
    Engine trainEngine = new Engine(100, "MegaCoolEngine", 2077);
}
