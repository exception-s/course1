package lab4;


public interface BeHuman {
    String getName();
    void addAction(ActionsAndConditions action, String info);
    myHashMap getActions();
    myHashMap getConditions();

}
