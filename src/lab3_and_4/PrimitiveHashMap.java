package lab3_and_4;

public abstract class PrimitiveHashMap {
    String[] arr;
    int size;

    public PrimitiveHashMap(){
        arr = new String[0];
        this.size = 0;
    }

    public PrimitiveHashMap(int size) {
        arr = new String[size];
        this.size = size;
    }

    public abstract void put(ActionsAndConditions key, String value);

    public abstract boolean isExist(ActionsAndConditions key);

    public abstract void remove(ActionsAndConditions key);

    public abstract int getSize();
    public abstract String getValue(ActionsAndConditions key);

}

