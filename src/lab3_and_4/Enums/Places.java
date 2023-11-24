package lab3_and_4.Enums;

public enum Places {
    Vazastan("Вазастан"),
    Stockholm("Стокгольм"),
    Vastergotland("Вестергетланд"),
    Sea("море"),
    Freygaten("Фрейгатен"),
    Roof("на крыше"),
    Station("маленькая станция");
    private String place;
    Places(String place){
        this.place = place;
    }
    public String getPlace(){
        return place;
    }
}
