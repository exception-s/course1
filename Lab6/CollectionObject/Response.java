package CollectionObject;

import Server.TheCollection;

import java.io.Serializable;

public class Response implements Serializable {
    private final Status status;
    private final String message;
    private TheCollection collection;

    public Response(Status status, String message, TheCollection collection) {
        this.status = status;
        this.message = message;
        this.collection = collection;
    }
    public Response(Status status, String message) {
        this.status = status;
        this.message = message;
    }
    public Status getStatus() {
        return status;
    }

    public TheCollection getCollection() {
        return collection;
    }

    public String getMessage() {
        return message;
    }
}
