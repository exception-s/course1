package lab3_and_4;


public class Main {
    public static void main(String[] args) {
        try {
            //alive creatures
            HumanAbstract boy = new Human("Малыш");
            boy.addAction(ActionsAndConditions.Evening, " сидел у Карлсона на крыльце");
            boy.addAction(ActionsAndConditions.Calm, " сидел со своим лучшим другом, и они ели свежие плюшки ");
            boy.addCondition(ActionsAndConditions.AnxietyAndBuns, " было тревожно. ");
            boy.addAction(ActionsAndConditions.AnxietyAndBuns, " тоже взял плюшку и откусил кусочек. ");
            System.out.println();

            HumanAbstract karlson = new Human("Карлсон");
            karlson.addCondition(ActionsAndConditions.Hurt, "было не до смеха. Он всерьёз обиделся.");
            karlson.addAction(ActionsAndConditions.AnxietyAndBuns, " запихал себе в рот целую плюшку и проглотил ее. ");
            System.out.println();

            HumanAbstract julius = new Human("дядя Юлиус");
            julius.addCondition(ActionsAndConditions.Happiness, " был так счастлив, что ему хотелось, чтобы все были счастливы, и он тут же пригласил ");
            julius.addAction(ActionsAndConditions.Journey, " из вагона вышел ");
            System.out.println();

            HumanAbstract freken = new Human("Фрекен Бок");
            freken.addAction(ActionsAndConditions.Hurt, " посмеяться вволю.");
            freken.addAction(ActionsAndConditions.Happiness, " сказала, что тогда свадьба будет без неё.");
            freken.addAction(ActionsAndConditions.Calm, " была у себя дома, на Фрейгатен, чтобы ободрить Фриду. ");
            System.out.println();

            Dog bimbo = new Dog("Бимбо");
            bimbo.addAction(ActionsAndConditions.Calm, " спал в своей корзинке. ");
            System.out.println();

            //locations
            PlaceAbstract location1 = new Place("Место №1");
            location1.setType(Places.Vazastan);
            System.out.println();

            PlaceAbstract location2 = new Place("Место №2");
            location2.setType(Places.Stockholm);
            System.out.println();

            PlaceAbstract location3 = new Place("Место №3");
            location3.setType(Places.Vastergotland);
            System.out.println();

            PlaceAbstract location4 = new Place("Место №4");
            location4.setType(Places.Sea);
            System.out.println();

            PlaceAbstract location5 = new Place("Место №5");
            location5.setType(Places.Freygaten);
            System.out.println();

            PlaceAbstract location6 = new Place("Место №6");
            location6.setType(Places.Roof);
            System.out.println();

            //"nature" conditions
            Condition cond1 = new Condition(" настал вечер. ");
            Condition cond2 = new Condition(", сгущались сумерки, ");
            Condition cond3 = new Condition("зажглись огни, ");
            Condition cond4 = new Condition("море огней. ");
            Condition cond5 = new Condition("и это было хорошо.");
            Condition cond6 = new Condition("Всё это было замечательно. ");

            //transport
            TransportAbstract train = new Transport("поезд", "наземный");
            train.addAction(ActionsAndConditions.Journey, " на маленькой станции остановился ");
            TransportAbstract steamship = new Transport("белый пароход", "морской");
            steamship.addAction(ActionsAndConditions.Journey, "Где-то в море плывёт назад, ");
            System.out.println();


            // new characters/items/etc. from Lab №4
            Item costum = new Item("Черный бархатный костюм");
            HumanAbstract krister = new Human("Кристер");
            HumanAbstract gunilla = new Human("Гунилла");
            krister.addAction(ActionsAndConditions.Mockery, "засмеют его!");
            gunilla.addAction(ActionsAndConditions.Mockery, "засмеют его!");

            //text
            System.out.println();
            Human.HumanActions.mockery(boy, costum, krister, gunilla);
            Human.HumanActions.hurt(karlson, freken);
            Human.HumanActions.happiness(julius, karlson, freken);
            Human.HumanActions.evening(cond1, boy, karlson, cond2, location1, cond3, location2, cond4, cond5);
            Human.HumanActions.journey(location3, train, julius, location2, steamship);
            Human.HumanActions.calm(freken, bimbo, location6, boy, cond6);
            Human.HumanActions.anxietyAndBuns(boy, karlson);
            System.out.println();
        }
        catch (Human.MyNullException ex){
            System.out.println("Null Exception: " + ex.getMessage());
        }
        catch (NullPointerException ex){
            System.out.println("NullPointer Exception: " + ex.getMessage());
        }
        finally {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("It was only a fragment.\nIf you are interested, look for the full version in the book by Astrid Lindgren!");
        }
    }
}