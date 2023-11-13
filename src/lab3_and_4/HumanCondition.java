package lab3_and_4;

public class HumanCondition {
    private String typeName;
    public HumanCondition(ActionsAndConditions type) {
        switch (type){
            case Anxiety -> typeName = "тревожность";
            case Sad -> typeName = "грусть";
            case Happy -> typeName = "счастье";
            case Good -> typeName = "хорошо";
            case Amazing -> typeName = "замечательно";
        }
    }
    public String getType(){
        return typeName;
    }
}
