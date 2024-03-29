package Classes.Actors;
import java.util.Random;
import Abstracts.HumanAbstract;
import Abstracts.PlaceAbstract;
import Enums.Items;
import Exceptions.AgeException;
import Exceptions.BunsException;
import Enums.*;

public class Boy extends HumanAbstract {
    private int bunsChance;
    public Boy() {
        super("Малыш");
    }
    public Boy(int age) throws AgeException{
        super("Малыш", age);
        if (age > 13) throw new AgeException("Стоп... Малышу " + age + " лет? Не сходится как-то, давай по новой.");
    }
    public void shiver(){
        System.out.println(getName() + " содрогнулся");
    }
    public void evening(HumanAbstract person){
        System.out.println(getName() + " сидел с " + person.getName());
    }
    public void calm(PlaceAbstract place, Items item, HumanAbstract person1, HumanAbstract person2) {
        Random random = new Random();
        bunsChance = random.nextInt(0, 4);
        System.out.println("Малыш и Карлсон взяли " + bunsChance + " плюшки(-ку)");
        System.out.println(getName() + " " + place.getPlaceName() + " сидел c " + person1.getName() + ", и они ели свежие " + item.getItem() + " " + person2.getName());
        if (bunsChance < 1) throw new BunsException(bunsChance, "плюшек");
    }
    public void anxietyAndBuns(Items item){
        System.out.println(getName() + " тоже взял " + item.getItem() + " и откусил кусочек");
    }
    public void anxiety(){
        System.out.println(getName() + " всё же был тревожен");
    }
}
