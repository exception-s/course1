package lab3_and_4.Classes;


import lab3_and_4.Abstracts.PlaceAbstract;
import lab3_and_4.Enums.Places;

public class Place extends PlaceAbstract {
    private String name;
    private Places type;
    private String typeName;
    public Place(String name) {
        super(name);
        System.out.println("Место " + name + " создано");
    }
    public String getName(){
        return this.name;
    }
    public Places getPlaceType() {
        return this.type;
    }
    public String getType(){
        return typeName;
    }
}
