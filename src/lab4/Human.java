package lab4;

public class Human extends HumanAbstract {
    private myHashMap actions = new myHashMap(16);
    private myHashMap conditions = new myHashMap(16);
    public static class MyNullException extends Exception{
        public MyNullException(String info){
            super(info);
        }
    }
    public Human(String name) throws MyNullException {
        super(name);
        if (name.isEmpty()){
            throw new MyNullException("У человека нет имени");
        }
        System.out.println("Человек с именем " + name + " создан");
    }
    public void addAction(ActionsAndConditions action, String info) {
        actions.put(action, info);
    }
    public myHashMap getActions(){
        return actions;
    }
    public void addCondition(ActionsAndConditions condition, String info) {
        conditions.put(condition, info);
    }
    public myHashMap getConditions(){
        return conditions;
    }

    public static class HumanActions{
        public static void mockery(HumanAbstract name1, Item item, HumanAbstract name2, HumanAbstract name3){
            System.out.println(name1.getName() + " содрогнулся. " + item.getName() + "... " + name2.getName() + " " +
                    name3.getName() + " " + name2.getActions().getValue(ActionsAndConditions.Mockery));
        }
        public static void hurt(HumanAbstract name1, HumanAbstract name2){
            System.out.println(name1.getName() + "у " + name1.getConditions().getValue(ActionsAndConditions.Hurt) +
                    " Настала очередь " + name2.getName() + name2.getActions().getValue(ActionsAndConditions.Hurt));
        }
        public static void happiness(HumanAbstract name1, HumanAbstract name2, HumanAbstract name3){
            System.out.println(name1.getName() + name1.getConditions().getValue(ActionsAndConditions.Happiness) +
                    name2.getName() + "а. " + name3.getName() + name3.getActions().getValue(ActionsAndConditions.Happiness));
        }
        public static void evening(Condition cond1, HumanAbstract name1, HumanAbstract name2, Condition cond2, PlaceAbstract place1, Condition cond3,
                                   PlaceAbstract place2, Condition cond4, Condition cond5){
            System.out.println("В тот же день" + cond1.getName() + name1.getName() + name1.getActions().getValue(ActionsAndConditions.Evening) +
                    cond2.getName() + "во всём " + place1.getType() + "e " + cond3.getName() + "во всём " + place2.getType() + "e - " +
                    cond4.getName() + "Да," + cond1.getName() + name1.getName() + " сидел рядом с " + name2.getName() + "ом, " + cond5.getName()       );
        }
        public static void journey(PlaceAbstract place1, TransportAbstract tr1, HumanAbstract name1, PlaceAbstract place2,
                                   TransportAbstract tr2){
            System.out.println("В " + place1.getType() + "e" + tr1.getActions().getValue(ActionsAndConditions.Journey) +
                    tr1.getName() + " и" + name1.getActions().getValue(ActionsAndConditions.Journey) + name1.getName() + ". " +
                    tr2.getActions().getValue(ActionsAndConditions.Journey) + "в " + place2.getType() + ", " + tr2.getName() +
                    ", а на его палубе стоят мама и папа.");
        }
        public static void calm(HumanAbstract name1, Dog dog, PlaceAbstract place1, HumanAbstract name2, Condition cond1){
            System.out.println(name1.getName() + name1.getActions().getValue(ActionsAndConditions.Calm) + dog.getName() +
                    dog.getActions().getValue(ActionsAndConditions.Calm) + "Но здесь, " + place1.getType() + ", " + name2.getName() +
                    name2.getActions().getValue(ActionsAndConditions.Calm) + name1.getName() + ". " + cond1.getName());
        }
        public static void anxietyAndBuns(HumanAbstract name1, HumanAbstract name2){
            System.out.println(name1.getName() + "у" + name1.getConditions().getValue(ActionsAndConditions.AnxietyAndBuns) +
                    "Нет тебе покоя, если ты дружишь с " + name2.getName() + "ом! " + name2.getName() +
                    name2.getActions().getValue(ActionsAndConditions.AnxietyAndBuns) + name1.getName() +
                    name1.getActions().getValue(ActionsAndConditions.AnxietyAndBuns));
        }
    }
}
