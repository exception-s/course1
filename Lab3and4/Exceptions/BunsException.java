package Exceptions;

public class BunsException extends RuntimeException {
    private int cause;
    private String info;
    public BunsException(int cause, String info){
        this.cause = cause;
        this.info = info;
    }

    @Override
    public String getMessage() {
        return "взято " + cause + " " + info;
    }
}
