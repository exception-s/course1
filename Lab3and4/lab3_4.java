import Abstracts.PlaceAbstract;
import Classes.Actors.*;
import Classes.Condition;
import Classes.Place;
import Classes.*;
import Enums.Items;
import Enums.Places;
import Exceptions.AgeException;
import Exceptions.BunsException;

public class lab3_4 {
    public static void main(String[] args) {
        try {
            //alive creatures
            Boy boy = new Boy(10);
            Karlson karlson = new Karlson();
            Julius julius = new Julius();
            Freken freken = new Freken();
            Krister krister = new Krister();
            Gunilla gunilla = new Gunilla();
            Frida frida = new Frida();
            Bimbo bimbo = new Bimbo();

            //locations
            PlaceAbstract vazastan = new Place(Places.Vazastan.getPlace());
            PlaceAbstract stockholm = new Place(Places.Stockholm.getPlace());
            PlaceAbstract vastergotland = new Place(Places.Vastergotland.getPlace());
            PlaceAbstract sea = new Place(Places.Sea.getPlace());
            PlaceAbstract freygaten = new Place(Places.Freygaten.getPlace());
            PlaceAbstract roof = new Place(Places.Roof.getPlace());
            PlaceAbstract station = new Place(Places.Station.getPlace());

            //"nature" conditions
            Condition cond1 = new Condition("В тот же день настал вечер");
            Condition cond2 = new Condition("Cгущались сумерки");
            Condition cond3 = new Condition("Во всём " + vazastan.getPlaceName() + " зажглись огни");
            Condition cond4 = new Condition("Во всём " + stockholm.getPlaceName() + " море огней!");
            Condition cond5 = new Condition("И это было хорошо.");
            Condition cond6 = new Condition("Всё это было замечательно. ");

            //transport
            Train train = new Train();
            Steamship steamship = new Steamship();

            // Some items
            Items costum = Items.Costum;
            Items buns = Items.Buns;
            Items basket = Items.Basket;

            System.out.println("Initialization is over");
            System.out.println();
            System.out.println();
            System.out.println();


            //text
            boy.shiver();
            System.out.println(costum.getItem());
            krister.mockery(gunilla, boy);
            karlson.hurt();
            freken.hurt();
            julius.happiness(karlson);
            freken.happiness();
            cond1.getName();
            boy.evening(karlson);
            cond2.getName();
            cond3.getName();
            cond4.getName();
            boy.evening(karlson);
            cond5.getName();
            train.journey(vastergotland, station);
            julius.journey();
            steamship.journey(sea, stockholm);
            freken.calm(freygaten, frida);
            bimbo.calm(basket);
            boy.calm(roof, buns, karlson, freken);
            cond6.getName();
            boy.anxiety();
            karlson.anxietyAndBuns(buns);
            boy.anxietyAndBuns(buns);
            System.out.println();
        }
        catch (BunsException ex){
            System.out.println("Упс, " + ex.getMessage());
            //ex.printStackTrace();
        }
        catch (AgeException ex){
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
        }
        finally {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("It was only a fragment.\nIf you are interested, look for the full version in the book by Astrid Lindgren!");
        }
    }
}