package lab3_and_4;

public class myHashMap extends PrimitiveHashMap{
    int current = 0;
    ActionsAndConditions[] keys = new ActionsAndConditions[size];
    String[] values = new String[size];
    public myHashMap() {
        super();
    }
    public myHashMap(int size) {
        super(size);
    }
    public void put(ActionsAndConditions key, String value){
        int index = key.hashCode() & (size - 1);
        keys[current] = key;
        values[current] = value;
        arr[index] = value;
        current++;
        if (current >= size - 1){
            String[] help_arr = new String[size * 2];
            for (int i = 0; i < size; i++){
                int helpIndex = keys[i].hashCode() & (2 * size - 1);
                help_arr[helpIndex] = values[i];
            }
            arr = help_arr;
        }
    }
    public boolean isExist(ActionsAndConditions key){
        int index = key.hashCode() & (size - 1);
        if (arr[index] == null) return false;
        return true;
    }
    public String getValue(ActionsAndConditions key){
        int index = key.hashCode() & (size - 1);
        return arr[index];
    }

    //to do
    public void remove(ActionsAndConditions key){
        int index = key.hashCode() & (size - 1);
        arr[index] = null;
        current--;
    }

    public int getSize(){
        return size;
    }
}

