package Classes.Actors;

import Abstracts.PlaceAbstract;
import Abstracts.TransportAbstract;

public class Steamship extends TransportAbstract {
    public Steamship(){
        super("белый пароход", "водный");
    }
    public void journey(PlaceAbstract place1, PlaceAbstract place2){
        System.out.println("Где-то в " + place1.getPlaceName() + " плывёт назад, в " + place2.getPlaceName() + " " + getName());
    }
    class Sail{
        private final String material;
        private final int square;
        public Sail(String material, int square){
            this.material = material;
            this.square = square;
        }
    }
    Sail sail = new Sail("Carbon", 8);
}
