package lab4;


public abstract class PlaceAbstract implements InPlace {
    private String placeName;
    private String placeType;

    public PlaceAbstract(String placeName){
        this.placeName = placeName;
    }
    public String getPlaceName(){
        return placeName;
    }

    @Override
    public String toString() {
        return "Место " + placeName;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getPlaceName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }
}
