package lab3;

public class Main {
    public static void main(String[] args) {
        HumanAbstract boy = new Human("Малыш");
        boy.addAction(new Actions("сидел", "на крыльце"));
        boy.addAction(new Actions("было тревожно", ""));
        boy.addAction(new Actions("Есть", "свежие плюшки"));
        System.out.println();

        HumanAbstract karlson = new Human("Карлсон");
        karlson.addAction(new Actions("Летать", "везде"));
        karlson.addAction(new Actions("Есть", "свежие плюшки"));
        System.out.println();

        HumanAbstract julius = new Human("дядя Юлиус");
        julius.addAction(new Actions("вышел", "из вагона"));
        System.out.println();

        HumanAbstract freken = new Human("Фрекен Бок");
        freken.addAction(new Actions("была", "у себя дома"));
        System.out.println();

        Dog bimbo = new Dog("Бимбо");
        bimbo.addAction(new Actions("спал", "в своей корзинке"));
        System.out.println();

        boy.addCondition(new Actions("тревожность", ""));

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

        Condition cond1 = new Condition("настал вечер");
        Condition cond2 = new Condition("сгущались сумерки");
        Condition cond3 = new Condition("зажглись огни");
        Condition cond4 = new Condition("море огней");
        Condition cond5 = new Condition("и это было хорошо");
        Condition cond6 = new Condition("Всё это было замечательно. ");

        Item train = new Item("поезд", "остановился");
        Item steamship = new Item("белый пароход", "плывёт назад");
        System.out.println();

        TransportAbstract train1 = new Transport("Поезд", "наземный");
        TransportAbstract steamship1 = new Transport("Пароход", "морской");

        // 1st sentence
        System.out.print("и в тот же день " + cond1.getName() + ". ");
        // 2nd sentence
        System.out.print(boy.getName() + " " + boy.getActionsName(0) + " у " + karlson.getName() + "а " + boy.getActionsAbility(0) +
                ", " + cond2.getName() + ", и во всём " + location1.getType() + "е " + cond3.getName() + ", и во всём \n" +
                location2.getType() + "е - " + cond4.getName() + ", куда не погляди. ");
        // 3rd sentence
        System.out.print("Да, " + cond1.getName() + ", " + boy.getName() + " " + boy.getActionsName(0) + " рядом с " +
                karlson.getName() + "ом, " + cond5.getName() + ". ");
        // 4th sentence
        System.out.print("Как раз сейчас в \n" + location3.getType() + "е на маленькой станции " + train.getAct() + " " +
                train.getName() + " и " + julius.getActionsAbility(0) + " " + julius.getActionsName(0) + " " + julius.getName() + ". ");
        // 5th sentence
        System.out.print(location4.getType() + " " + steamship.getAct() + ", в " + location2.getType() + ", " + steamship.getName()
        + ",\nа на его палубе стоят мама и папа. ");
        // 6th sentence
        System.out.print(freken.getName() + " " + freken.getActionsAbility(0) + " " + freken.getActionsName(0) + ", на "
                + location5.getType() + ", чтобы ободрить Фриду. ");
        // 7th sentence
        System.out.print(bimbo.getName() + " " + bimbo.getActionsName(0) + " " + bimbo.getActionsAbility(0) + ". ");
        // 8th sentence
        System.out.print("Но\nздесь, " + location6.getType() + ", " + boy.getName() + " " + boy.getActionsName(0) +
                " со своим лучшим другом, и они ели свежие плюшки " + freken.getName() + ". ");
        // 9th sentence
        System.out.print(cond6.getName());
        // 10th sentence
        System.out.print("и всё же " + boy.getName() + "у " + boy.getActionsName(1) + ". ");
    }
}