package lab3_and_4;


public class Place extends PlaceAbstract {
    private String name;
    private Places type;
    private String typeName;
    public Place(String name) {
        super(name);
        System.out.println(name + " создано");
    }
    public void setType(Places type){
        this.type = type;
        switch (type){
            case Vazastan -> typeName = "Вазастан";
            case Stockholm -> typeName = "Стокгольм";
            case Vastergotland -> typeName = "Вестергетланд";
            case Sea -> typeName = "Где-то в море";
            case Freygaten -> typeName = "Фрейгатен";
            case Roof -> typeName = "на крыше";
        }
        System.out.println(super.getPlaceName() + ": " + typeName);
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
