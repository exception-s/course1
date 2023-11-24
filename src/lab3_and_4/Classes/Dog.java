package lab3_and_4.Classes;


public class Dog {
    private String name;
    public Dog(String name){
        this.name = name;
        System.out.println("Собачка " + name + " создана");
    }
    public String getName(){
        return name;
    }
}
