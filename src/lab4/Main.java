package lab4;


public class Main {
    public static void main(String[] args) {
        try {
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

            TransportAbstract train = new Transport("поезд", "наземный");
            TransportAbstract steamship = new Transport("белый пароход", "морской");
            System.out.println();


            // new characters/items/etc. from Lab №4
            boy.addAction(new Actions("содрогнулся", ""));
            Item costum = new Item("Черный бархатный костюм");
            HumanAbstract krister = new Human("Кристер");
            HumanAbstract gunilla = new Human("Гунилла");
            krister.addAction(new Actions("засмеют", "его"));
            gunilla.addAction(new Actions("засмеют", "его"));
            karlson.addAction(new Actions("было", "не до смеха"));
            karlson.addAction(new Actions("обиделся", "всерьёз"));
            freken.addAction(new Actions("посмеяться", "вволю"));
            julius.addAction(new Actions("был", "так счастлив"));
            julius.addAction(new Actions("хотелось", ""));
            julius.addAction(new Actions("пригласил", ""));
            freken.addAction(new Actions("сказала", "что тогда свадьба будет без нее"));
            karlson.addAction(new Actions("запихал", "себе в рот целую плюшку"));
            karlson.addAction(new Actions("проглотил", "её"));
            boy.addAction(new Actions("тоже взял", "плюшку"));
            boy.addAction(new Actions("откусил", "кусочек"));
            System.out.println();


            // 1st sentence
            System.out.print(boy.getName() + " " + boy.getActionsName(3) + ". ");
            // 2nd sentence
            System.out.print(costum.getName() + "... ");
            // 3rd sentence
            System.out.print("Да " + krister.getName() + " и " + gunilla.getName() + " " + krister.getActionsAbility(0)
                    + " " + krister.getActionsName(0) + "! ");
            // 4th sentence
            System.out.print("Зато " + karlson.getName() + "у " + karlson.getActionsName(2) + " " + karlson.getActionsAbility(2) + ". ");
            // 5th sentence
            System.out.print("Он " + karlson.getActionsAbility(3) + " " + karlson.getActionsName(3) + ". ");
            // 6th sentence
            System.out.print("Тут настала очередь\n" + freken.getName() + " " + freken.getActionsName(1) + " " +
                    freken.getActionsAbility(1) + ". ");
            // 7th sentence
            System.out.print(julius.getName() + " " + julius.getActionsName(1) + " " + julius.getActionsAbility(1) +
                    ", что ему " + julius.getActionsName(2) + ", чтобы все были счастливы, и он тут же " + julius.getActionsName(3) +
                    " " + karlson.getName() + "а. ");
            // 8th sentence
            System.out.print("Но " + freken.getName() + " " + freken.getActionsName(2) + ",\n" + freken.getActionsAbility(2) + ". ");
            // 9th sentence
            System.out.print("и в тот же день " + cond1.getName() + ". ");
            // 10th sentence
            System.out.print(boy.getName() + " " + boy.getActionsName(0) + " у " + karlson.getName() + "а " + boy.getActionsAbility(0) +
                    ", " + cond2.getName() + ", и во всём " + location1.getType() + "е " + cond3.getName() + ", и во всём \n" +
                    location2.getType() + "е - " + cond4.getName() + ", куда не погляди. ");
            // 11th sentence
            System.out.print("Да, " + cond1.getName() + ", " + boy.getName() + " " + boy.getActionsName(0) + " рядом с " +
                    karlson.getName() + "ом, " + cond5.getName() + ". ");
            // 12th sentence
            System.out.print("Как раз сейчас в " + location3.getType() + "е на\nмаленькой станции остановился " +
                    train.getName() + " и " + julius.getActionsAbility(0) + " " + julius.getActionsName(0) + " " + julius.getName() + ". ");
            // 13th sentence
            System.out.print(location4.getType() + " плывёт назад" + ", в " + location2.getType() + ", " + steamship.getName()
                    + ", а на его палубе стоят мама и папа.\n");
            // 14th sentence
            System.out.print(freken.getName() + " " + freken.getActionsAbility(0) + " " + freken.getActionsName(0) + ", на "
                    + location5.getType() + ", чтобы ободрить Фриду. ");
            // 15th sentence
            System.out.print(bimbo.getName() + " " + bimbo.getActionsName(0) + " " + bimbo.getActionsAbility(0) + ". ");
            // 16th sentence
            System.out.print("Но здесь, " + location6.getType() + ", " + boy.getName() + " " + boy.getActionsName(0) +
                    " со своим лучшим другом, и\nони ели свежие плюшки " + freken.getName() + ". ");
            // 17th sentence
            System.out.print(cond6.getName());
            // 18th sentence
            System.out.print("и всё же " + boy.getName() + "у " + boy.getActionsName(1) + ". ");
            // 19th sentence
            System.out.print("Нет тебе покоя, если ты дружишь с " + karlson.getName() + "ом! ");
            // 20 sentence
            System.out.print(karlson.getName() + "\n" + karlson.getActionsName(4) + " " + karlson.getActionsAbility(4) +
                    " и " + karlson.getActionsName(5) + " " + karlson.getActionsAbility(5) + ". ");
            // 21st sentence
            System.out.print(boy.getName() + " " + boy.getActionsName(4) + " " + boy.getActionsAbility(4) + " и " +
                    boy.getActionsName(5) + " " + boy.getActionsAbility(5) + ". ");
        }
        catch (Human.MyNullException ex){
            System.out.println("Null Exception: " + ex.getMessage());
        }
        finally {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("It was only a fragment.\nIf you are interested, look for the full version in the book by Astrid Lindgren!");
        }
    }
}